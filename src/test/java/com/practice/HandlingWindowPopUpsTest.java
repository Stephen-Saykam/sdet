package com.practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingWindowPopUpsTest {
	@Test
	public void handlingWindowPopUpsTest()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.naukri.com/");
		//driver.switchTo().window(null)
		
		Set<String> windids = driver.getWindowHandles();
		
		for(String win:windids) 
		{
			driver.switchTo().window(win);
			System.out.println(driver.getTitle());
		
			if(driver.switchTo().window(win).getTitle().equalsIgnoreCase("Tech Mahindra"))
			{
				driver.manage().window().maximize();
				break;
			}
		}
		
	}

}
