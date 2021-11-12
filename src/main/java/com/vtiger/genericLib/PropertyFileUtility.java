package com.vtiger.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Test;

public class PropertyFileUtility {
	
	@Test
	public String propertyFileUtility(String Key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.PROPERTYFILEPATH);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(Key);
		return value;
		
		
	}

}
