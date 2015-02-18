package com.fornsys.mapper.model;

import org.joda.time.DateTime;

/*
 * A raw file row of data
 */
public interface Row {
	public String getStringField(int i);
	public Integer getIntegerField(int i);
	public DateTime getDateField(int i);
	public Double getDoubleField(int i);
}
