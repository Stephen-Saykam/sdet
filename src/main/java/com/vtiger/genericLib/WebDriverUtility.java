package com.vtiger.genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	@Test
	public void selectByIndex(WebElement ele, int index)
	{
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}
	
	public void selectByVisibleText(WebElement ele, String visText)
	{
		Select sel = new Select(ele);
		sel.selectByVisibleText(visText);
	}
	
	public void SelectByValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions ac = new Actions(driver);
		ac.doubleClick(element).perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions ac = new Actions(driver);
		ac.contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement src, WebElement des)
	{
		Actions ac = new Actions(driver);
		ac.dragAndDrop(src, des).perform();
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void swichToWindow(WebDriver driver, String partialWinTitle)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String winID = it.next();
			String title = driver.switchTo().window(winID).getTitle();
			if(title.contains(partialWinTitle))
			{
				break;
			}
		}
		
	}
	
	public void switchToFrame(WebDriver driver, String index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToframne(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	public void switchToframe(WebDriver driver, String element)
	{
		driver.switchTo().frame(element);
	}
	
	public String takesScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		String currentDate = new Date().toString().replace(" ", "_");
		String screenshotpath="./screenshots/"+screenshotName+".PNG";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(screenshotpath);
		Files.copy(src, dst);
		return screenshotpath;
		
	}
	
	public void scrollToWebElement(WebDriver driver, WebElement element)
	{
		Point loc = element.getLocation();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy()"+loc);
		
	}
	
//	public void openBrowser(String browser)
//	{
//		if(browser.equalsIgnoreCase("chrome"))
//		{
//			System.setProperty(IPathConstant.CHROME_KEY, IPathConstant.CHROME_VALUE );
//			new ChromeDriver();
//		}
//		else if(browser.equalsIgnoreCase("firefox"))
//		{
//			System.setProperty(IPathConstant.GECKO_KEY, IPathConstant.GECKO_VALUE);
//			new FirefoxDriver();
//		}
//		else
//		{
//			System.out.println("Please Enter the Proper Browser Name");
//		}
//		
//	}
//	
//	public void closeBrowser(WebDriver driver)
//	{
//		driver.close();
//	}
	
	public void sendKeys(WebDriver driver, WebElement textBox, String value, String script)
	{
		if(textBox.isEnabled())
		{
			textBox.sendKeys(value);
		}
		else
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript(script);
			
		}
	}
	
	public void openBrowserWithoutBrowserNotification(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty(IPathConstant.CHROME_KEY, IPathConstant.CHROME_VALUE);
			ChromeOptions co = new ChromeOptions();
			co.addArguments("----disable-notifications----");
			ChromeDriver driver = new ChromeDriver(co);
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty(IPathConstant.GECKO_KEY, IPathConstant.GECKO_VALUE);
			FirefoxOptions fo = new FirefoxOptions();
			fo.addArguments("----disable-notifications----");
			FirefoxDriver driver = new FirefoxDriver(fo);
		}
		else
		{
			System.out.println("Please Enter the Proper Browser Name");
		}
	}
	
	
	
	
	
	
}

