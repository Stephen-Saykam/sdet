package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MIPhonePriceInAmazon {
	
	@Test
	public void mIPhonePriceInAmazon() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("mobiles under 15000");
		driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"See more\"]")).click();
		driver.findElement(By.xpath("//i[@class=\"a-icon a-icon-checkbox\"]//ancestor::li[@id=\"p_89/MI\"]//descendant::span[text()=\"MI\"]")).click();
		Thread.sleep(2000);
		WebElement mobileName = driver.findElement(By.xpath("//span[text()=\"MI Xiaomi Mi A2 (Black, 4GB RAM, 64GB Storage)\"]"));
//		mobileName.click();
		System.out.println(mobileName);
//		WebElement price = driver.findElement(By.xpath("//span[text()=\"₹13,499.00\"]//ancestor::div[@id=\"price\"]"));
//		System.out.println(price);
		

	}

}
