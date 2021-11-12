package com.practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SVGHandlingTest {
	
	@Test
	public void sVGHandlingTest()
	{
		
		Date dt = new Date();
		String s = dt.toString();
		String[] arr = s.split(" ");
		String day = arr[0];
		String month = arr[1];
		String currentdate = arr[2];
		String year = arr[5];
		
		
		
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
//		WebDriver driver=new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
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
		
		driver.findElement(By.xpath("//div[@aria-label='"+day+" "+month+" "+currentdate+" "+year+"']")).click();
		
	}

}
