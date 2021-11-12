package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ToolTipInLenskartTest {
	
	@Test
	public void toolTipInlenskartTest()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.lenskart.com/");
		String logo = driver.findElement(By.xpath("//img[@title=\"Lenskart\"]")).getAttribute("title");
		System.out.println(logo);
		driver.findElement(By.xpath("//input[@class=\"search_input-bar autoSuggest\"]")).click();
		List<WebElement> links = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']//li"));
		//System.out.println(links);
		for(WebElement link:links)
		{
			System.out.println(link.getText());
		}
			
	}

}
