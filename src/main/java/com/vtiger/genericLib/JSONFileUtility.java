package com.vtiger.genericLib;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JSONFileUtility {
	
	public String jsonFileUtility(String key) throws Throwable
	{
		FileReader fr = new FileReader(IPathConstant.JSONFILEPATH);
		JSONParser parser = new JSONParser();
		Object jObj = parser.parse(fr);
		HashMap obj = (HashMap)jObj;
		String value = (String) obj.get(key);
		return value;
		
		
	}

}
