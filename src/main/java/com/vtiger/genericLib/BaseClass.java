package com.vtiger.genericLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vtiger.objectRepository.LoginClass;


public class BaseClass {

	public  static WebDriver driver;
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	public static WebDriver sdriver;



	@BeforeSuite(groups={"smokeTest", "regTest", "itTest"})
	public void connectToDataBase()
	{
		System.out.println("Connect to Data Base");
	}

	//@Parameters("browser")
	@BeforeClass(groups={"smokeTest", "regTest", "itTest"})
	public void openBrowser() throws Throwable
	{
		String browserValue=pUtil.propertyFileUtility("browser");
		if(browserValue.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty(IPathConstant.CHROME_KEY, IPathConstant.CHROME_VALUE );
			driver=new ChromeDriver();
			Thread.sleep(1000);
			
		}
		else if(browserValue.equalsIgnoreCase("firefox"))
		{
			System.setProperty(IPathConstant.GECKO_KEY, IPathConstant.GECKO_VALUE);
			driver=new FirefoxDriver();
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("Please Enter the Proper Browser Name");
		}
		//sdriver=driver;
	}
	
	@BeforeMethod(groups={"smokeTest", "regTest", "itTest"})
	public void login() throws Throwable
	{
		System.out.println("Login into the Application");
		driver.get(pUtil.propertyFileUtility("url"));

//		String UN = pUtil.propertyFileUtility("username");
//		String PWD = pUtil.propertyFileUtility("password");
//
//
//		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(UN);
//		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PWD);
//		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		
		//POM class
		LoginClass lp=new LoginClass(driver);
		lp.loginIntoApp(pUtil.propertyFileUtility("username"), pUtil.propertyFileUtility("password"));

	}
	//  *********Test will be run in Main Method********
	//  



	@AfterMethod(groups={"smokeTest", "regTest", "itTest"})
	public void logOut() throws InterruptedException
	{
		System.out.println("LogOut from the Apllication");
		Thread.sleep(2000);

		WebElement signout = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		wUtil.mouseHover(driver, signout);
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();

	}

	@AfterClass(groups={"smokeTest", "regTest", "itTest"})
	public void closeBrowser()
	{
		System.out.println("Close the Browser");
		driver.close();
	}

	@AfterSuite(groups={"smokeTest", "regTest", "itTest"})
	public void disConnectToDataBase()
	{
		System.out.println("DisConnect to the Data Base");
	}


}
