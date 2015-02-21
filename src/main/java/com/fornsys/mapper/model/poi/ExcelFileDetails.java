package com.fornsys.mapper.model.poi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fornsys.mapper.model.FileDetails;

public class ExcelFileDetails extends FileDetails {
	private static final Logger _log = LoggerFactory.getLogger(ExcelFileDetails.class);
	
	private Integer ws;
	private String[] sheetNames;
	
	PoiSourceReader reader;
	
	public ExcelFileDetails(String name, String contentType) {
		super(name, contentType);
		ws = null;

		reader = new PoiSourceReader(this);
		sheetNames = reader.getSheetNames();
		setHeader(true);
	}
	
	public ExcelFileDetails(String name) {
		this(name, (String)null);
	}
	
	public Integer getSheet() {
		return ws;
	}
	
	public void setSheet(Integer index) {
		ws = index;
	}
	
	public void setSheetNames(String[] sheetNames) {
		this.sheetNames = sheetNames;
	}
	
	public String[] getSheetNames() {
		return sheetNames;
	}
	
	public String getType() {
		return "Excel";
	}

	@Override
	public void update(ObjectNode updater) {
		JsonNode jn = updater.get("sheet");
		if( jn != null ) {
			ws = jn.asInt(this.ws == null ? -1 : this.ws);
		}
		
		super.update(updater);
	}
}
