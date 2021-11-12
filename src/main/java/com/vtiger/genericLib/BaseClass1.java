package com.vtiger.genericLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.vtiger.objectRepository.HomeClass;
import com.vtiger.objectRepository.LoginClass;

public class BaseClass1 {
	
	public static WebDriver driver;
	public WebDriverUtility wUtil=new WebDriverUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	
	
	@BeforeSuite
	public void connectToDataBase()
	{
		System.out.println("Connect to DataBase");
	}
	
	@BeforeClass
	public void openBrowser() throws Throwable
	{
		System.out.println("Open the Browser");
		String browserValue = pUtil.propertyFileUtility("browser");
		if(browserValue.equalsIgnoreCase("chrome"))
		{
		System.setProperty(IPathConstant.CHROME_KEY, IPathConstant.CHROME_VALUE);
		driver=new ChromeDriver();
		}
		
		else if(browserValue.equalsIgnoreCase("firefox"))
		{
			System.setProperty(IPathConstant.GECKO_KEY, IPathConstant.GECKO_VALUE);
			driver=new FirefoxDriver();
		}
		
		else
		{
			System.out.println("Please Enter The Proper Browser Name");
		}
	}
	
	@BeforeMethod
	public void login() throws Throwable
	{
		System.out.println("Login into Apllication");
//		driver.get(pUtil.propertyFileUtility("url"));
//		String UN = pUtil.propertyFileUtility("username");
//		String PWD = pUtil.propertyFileUtility("password");
//		
//		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(UN);
//		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PWD);
//		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
//		wUtil.waitForPageLoad(driver);
		
		driver.get(pUtil.propertyFileUtility("url"));
		LoginClass lp=new LoginClass(driver);
		lp.loginIntoApp(pUtil.propertyFileUtility("username"), pUtil.propertyFileUtility("password"));
		
	}
	
	
	
	//*******Test will be run in Main MEthod*****
	
	
	
	@AfterMethod
	public void logOut() throws InterruptedException
	{
		System.out.println("LogOut from the Application");
		Thread.sleep(2000);
//		WebElement signOut = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//		wUtil.mouseHover(driver, signOut);
//		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		
		HomeClass hc = new HomeClass(driver);
		hc.signOutFromApp();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Close the Browser");
		driver.close();
	}
	
	@AfterSuite
	public void disConnectToDataBase()
	{
		System.out.println("DisConnect to DataBase");
	}


}
