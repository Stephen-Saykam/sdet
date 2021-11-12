package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingStaticWebTableTest {
	
	@Test
	public void handlingStaticWebTableTest()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro");
		driver.switchTo().frame("iframeResult");
		List<WebElement> RowCount = driver.findElements(By.xpath("//table//tbody//tr"));
		List<WebElement> ColCount = driver.findElements(By.xpath("//table//tbody//tr[1]//th"));
		System.out.println(RowCount);
		System.out.println(ColCount);
		System.out.println(driver.findElement(By.xpath("//table//tbody")).getText());
		
		
	}

}
