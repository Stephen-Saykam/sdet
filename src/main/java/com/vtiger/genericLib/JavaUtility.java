package com.vtiger.genericLib;

import java.util.Random;

import org.junit.Test;

public class JavaUtility {
	
	@Test
	public static int generateRandomNumber()
	{
		Random r = new Random();
		int number = r.nextInt(1000);
		return number;
		
	}
	

}
