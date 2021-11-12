package com.practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MakeMyTripTest {
	
	@Test(dataProvider="getvalue")
	public void makeMyTripTest(String src, String dest) throws InterruptedException
	{
		//System.out.println(dt);
		//Wed Nov 10 13:27:05 IST 2021
		// 0    1   2     3     4    5
		Date dt = new Date();
		String s = dt.toString();
		String[] arr = s.split(" ");
		String day = arr[0];
		String month = arr[1];
		String currentdate = arr[2];
		String year = arr[5];
		
		
		
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
		driver.findElement(By.xpath("//div[@aria-label='"+day+" "+month+" "+currentdate+" "+year+"']")).click();
		
	}
	
	@DataProvider
	public Object[][] getvalue()
	{
		Object arr[][]=new Object[5][2];
		
		arr[0][0]="PNQ";
		arr[0][1]="HYD";
		
		arr[1][0]="BLR";
		arr[1][1]="MAA";
		
		arr[2][0]="BOM";
		arr[2][1]="DEL";
		
		arr[3][0]="HYD";
		arr[3][1]="CCU";
		
		arr[4][0]="SIN";
		arr[4][1]="KTM";
		return arr;
		
		
		
	}	
	

}
