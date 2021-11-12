package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NormalizePathTest {
	
	@Test
	public void normalizePathTest() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		Thread.sleep(2000);
		String txt = driver.findElement(By.xpath("//div[normalize-space()=\"Fixtures\"]")).getText();
//		String txt = driver.findElement(By.xpath("//div[contains(text(),\'Fixtures\')]")).getText();
		System.out.println(txt);
	}

}
