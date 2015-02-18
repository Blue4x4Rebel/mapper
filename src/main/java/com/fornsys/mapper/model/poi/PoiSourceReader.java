package com.fornsys.mapper.model.poi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fornsys.mapper.model.FileDetails;
import com.fornsys.mapper.model.Row;
import com.fornsys.mapper.model.SourceReader;

public class PoiSourceReader implements SourceReader {
	private static final Logger _log = LoggerFactory.getLogger(PoiSourceReader.class);
	
	private Workbook wb;
	private ExcelFileDetails pfd;
	
	public PoiSourceReader(ExcelFileDetails fileDetails) {
		_log.info("Creating workbook.");
		pfd = fileDetails;
		try {
			wb = WorkbookFactory.create(new File(fileDetails.getName()));
		} catch( IOException | InvalidFormatException e) {
			_log.error("Exception opening spreadsheet...", e);
			throw new RuntimeException(e);
		}
		//pfd.setSheetNames(getSheetNames());
	}
	
	String[] getSheetNames() {
		String[] names = new String[wb.getNumberOfSheets()];
		for(int i=0; i < names.length; i++) {
			names[i] = wb.getSheetName(i);
		}
		
		return names;
	}
	
	@Override
	public String readString(int column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Row> getPreview() {
		List<Row> result = new ArrayList<>();
		if( pfd.getSheet() == null ) {
			return result;
		}
		
		return result;
	}
	
	@Override
	public FileDetails getFileDetails() {
		return pfd;
	}
}
