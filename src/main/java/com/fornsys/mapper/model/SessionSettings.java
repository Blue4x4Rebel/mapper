package com.fornsys.mapper.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("sset")
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
public class SessionSettings {
	private FileDetails file;
	//private RecordDetails record;
	//private FieldDetails field;
	
	public FileDetails getFileDetails() {
		return file;
	}
	
	public void setFileDetails(FileDetails fileDetails) {
		this.file = fileDetails;
	}
}
