package com.practice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OlympicsMedalsTest {
	
	@Test
	public void olympicsMedalsTest() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://olympics.com/");
//		String txt = driver.findElement(By.xpath("//span[text()=\"Eliud KIPCHOGE\"]/ancestor::ul/li[1]//div[@class=\"featured-athlete__medals text-body-sm\"]")).getText();
//		System.out.println(txt);
//		Thread.sleep(2000);
//		List<WebElement> allTxt = driver.findElements(By.xpath("//span[text()=\"Eliud KIPCHOGE\"]/ancestor::ul/li[*]//div[@class=\"featured-athlete__medals text-body-sm\"]"));
//		
//		String particularPerson = driver.findElement(By.xpath("//span[text()=\"Eliud KIPCHOGE\"]")).getText();
//		
//		for(WebElement oneTxt:allTxt)
//		{
//			String person = oneTxt.getText();
//			System.out.println(person);
//			
//			if(person.equalsIgnoreCase(particularPerson))
//			{
//				
//			}
//		}
		
		List<WebElement> medalsforall = driver.findElements(By.xpath("//div[@class='featured-athlete__medals text-body-sm']"));
		List<WebElement> namesforall = driver.findElements(By.xpath("//a[@class='featured-athlete__name d-flex text-body']/span"));

		for (int i = 0; i < medalsforall.size(); i++) 
		{
			System.out.println(namesforall.get(i).getText()+"\n"+medalsforall.get(i).getText());
			
		}
		
		
	}

}
