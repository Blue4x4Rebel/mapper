package com.fornsys.mapper.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SourceFactoryLocator {
	Map<String,SourceFactory> index = new HashMap<String,SourceFactory>();
	
	public SourceFactoryLocator() { }
	
	public void setIndex(List<SourceFactory> factories) {
		index.clear();
		for(SourceFactory sf : factories) {
			for(String key : sf.getSupportedTypes()) {
				index.put(key, sf);
			}
		}
	}
	
	public Map<String,SourceFactory>getIndex() {
		return index;
	}

	public SourceFactory getFactory(String contentType) {
		return index.get(contentType);
	}
}
