package com.fornsys.mapper.model;

public abstract class FileDetails {
	private String name;
	private String contentType;
	private boolean firstRowHeader;
	private boolean lastRowFooter;
	
	public FileDetails(String name, String contentType) {
		this.name = name;
		this.contentType = contentType;
	}
	
	public FileDetails(String fileName) {
		this.name = fileName;
	}
	
	public FileDetails() { }

	public String getName() {
		return this.name;
	}

	public String getContentType() {
		return this.contentType;
	}
	
	public void setContentType(String type) {
		this.contentType = type;
	}
	
	public boolean hasHeader() {
		return firstRowHeader;
	}
	
	public boolean getHeader() {
		return firstRowHeader;
	}
	
	public void setHeader(boolean hasHeader) {
		this.firstRowHeader = hasHeader;
	}
	
	public boolean hasFooter() {
		return lastRowFooter;
	}
	
	public boolean getFooter() {
		return lastRowFooter;
	}
	
	public void setFooter(boolean hasFooter) {
		this.lastRowFooter = hasFooter;
	}
	
	public abstract String getType();
}
