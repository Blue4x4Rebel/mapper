package com.fornsys.mapper.model;

public abstract class SourceFactory {
	/**
	 * Gets a list of supported Mime-Types
	 * @return an array of supported Mime-Types
	 */
	public abstract String[] getSupportedTypes();
	
	public abstract FileDetails createFileDetails(String fileName);
	
	/*
	public abstract RecordDetails createRecordDetails();
	public abstract FieldDetails createFieldDetails();
	public abstract Settings createSettings();
	*/
}
