package com.fornsys.mapper.model.poi;

import com.fornsys.mapper.model.FileDetails;
import com.fornsys.mapper.model.SourceFactory;

public class ExcelSourceFactory extends SourceFactory {

	@Override
	public String[] getSupportedTypes() {
		String[] types = new String[] { "application/vnd.ms-excel",
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
		};
		return types;
	}

	@Override
	public FileDetails createFileDetails(String fileName) {
		return new ExcelFileDetails(fileName);
	}

}
