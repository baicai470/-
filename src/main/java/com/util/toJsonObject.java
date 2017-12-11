package com.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class toJsonObject {
	
	public static Object JsonObject(Object object) throws IOException{
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(object);
		return mapper.readValue(json, Object.class);	
	}

}
