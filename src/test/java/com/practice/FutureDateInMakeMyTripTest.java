package com.practice;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FutureDateInMakeMyTripTest {
	
	@Test(dataProvider="getvalue")
	public void futureDateInMakeMyTripTest(String src, String dest) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		WebElement close = driver.findElement(By.xpath("//span[@class=\"langCardClose\"]"));
		close.click();
//		WebDriverWait wait = new WebDriverWait(driver,20);
//		wait.until(ExpectedConditions.close);
		driver.findElement(By.xpath("//li[@class=\"makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut\"]")).click();
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//input[@class=\"react-autosuggest__input react-autosuggest__input--open\"]")).sendKeys(src);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[contains(text(),'"+src+"')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("toCity")).sendKeys(dest);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'"+dest+"')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()=\"DEPARTURE\"]")).click();
		//driver.findElement(By.xpath("//div[@aria-label=\"Wed Nov 10 2021\"]")).click();
		//driver.findElement(By.xpath("//div[@aria-label='"+day+" "+month+" "+currentdate+" "+year+"']")).click();
		
		for (int i = 0; i < 11; i++) 
		{	
			try
			{
				driver.findElement(By.xpath("//div[@aria-label=\"Thu Apr 21 2022\"]")).click();	
				break;
			} 
			catch (Exception e) 
			{
				driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]")).click();
			}
		}
				
		}
		
		
		@DataProvider
		public Object[][] getvalue()
		{
			Object arr[][]=new Object[1][2];
			
//			arr[0][0]="PNQ";
//			arr[0][1]="HYD";
			
			arr[1][0]="BLR";
			arr[1][1]="MAA";
			return arr;
	}
}
