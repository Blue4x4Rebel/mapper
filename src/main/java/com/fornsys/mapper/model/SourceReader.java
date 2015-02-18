package com.fornsys.mapper.model;

import java.util.List;

public interface SourceReader {
	public String readString(int column);
	public FileDetails getFileDetails();
	public List<Row> getPreview();
}
