package com.vtiger.purchaseorder;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;
import com.vtiger.genericLib.ExcelUtility;
import com.vtiger.genericLib.IPathConstant;
import com.vtiger.genericLib.JavaUtility;
import com.vtiger.genericLib.PropertyFileUtility;
import com.vtiger.genericLib.WebDriverUtility;

/**
 * Create purchase Order & Select the Status As APPROVED
 * @author stephen
 *
 */

public class CreatePO_StatusAsApprovedTest extends BaseClass {
	
	@Test
	public void createPO_StatusAsApprovedTest() throws Throwable
	{
//		System.setProperty(IPathConstant.CHROME_KEY, IPathConstant.CHROME_VALUE);
//		WebDriver driver = new ChromeDriver();
//		
//		WebDriverUtility wUtil = new WebDriverUtility();
//		ExcelUtility eUtil = new ExcelUtility();
//		PropertyFileUtility pUtil = new PropertyFileUtility();
//		//JavaUtility jUtil = new JavaUtility();
//		
//		driver.get(pUtil.propertyFileUtility("url"));
//		driver.findElement(By.name("user_name")).sendKeys(pUtil.propertyFileUtility("username"));
//		driver.findElement(By.name("user_password")).sendKeys(pUtil.propertyFileUtility("password"));
//		driver.findElement(By.id("submitButton")).click();
		
		wUtil.waitForPageLoad(driver);
		WebElement more = driver.findElement(By.xpath("//a[text()=\"More\"]"));
		wUtil.mouseHover(driver, more);
		WebElement poAdd = driver.findElement(By.xpath("//a[@name=\"Purchase Order\"]"));
		poAdd.click();
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"subject\"]")).sendKeys(eUtil.excelUtility("PO", 1, 1));
		driver.findElement(By.xpath("//input[@name=\"vendor_name\"]//following-sibling::img[@src=\"themes/softed/images/select.gif\"]")).click();
		
		//Switch to ChildWindow
		String childtitle = "Vendors";
		wUtil.swichToWindow(driver, childtitle);
		driver.findElement(By.xpath("//a[@href=\"javascript:window.close();\"]")).click();
		Thread.sleep(2000);
		
		//Switch to ParentWindow
		String pTitle = "PurchaseOrder";
		wUtil.swichToWindow(driver, pTitle);
		
		
		
		driver.findElement(By.xpath("//input[@id=\"requisition_no\"]")).sendKeys(eUtil.excelUtility("PO", 3, 1)+JavaUtility.generateRandomNumber());
		driver.findElement(By.xpath("//input[@id=\"tracking_no\"]")).sendKeys(eUtil.excelUtility("PO", 4, 1)+JavaUtility.generateRandomNumber());
//		driver.findElement(By.xpath("//input[@id=\"salescommission\"]")).sendKeys(eUtil.excelUtility("PO", 6, 1)+JavaUtility.generateRandomNumber());
//		driver.findElement(By.xpath("//input[@id=\"exciseduty\"]")).sendKeys(eUtil.excelUtility("PO", 7, 1)+JavaUtility.generateRandomNumber());
		WebElement dd = driver.findElement(By.xpath("//select[@name=\"postatus\"]"));
		wUtil.selectByIndex(dd, 1);
		
		driver.findElement(By.xpath("//textarea[@name=\"bill_street\"]")).sendKeys(eUtil.excelUtility("PO", 8, 1));
		driver.findElement(By.xpath("//textarea[@name=\"ship_street\"]")).sendKeys(eUtil.excelUtility("PO", 9, 1));
		driver.findElement(By.xpath("//img[@id=\"searchIcon1\"]")).click();
		
		//Switch to Child Window
		String partialWinTitle = "PurchaseOrder";
		wUtil.swichToWindow(driver, partialWinTitle);
		driver.findElement(By.xpath("//a[@href=\"javascript:window.close();\"]")).click();
		Thread.sleep(2000);
		
		//Switch to Parent Window
		String parentTitle = "PurchaseOrder";
		wUtil.swichToWindow(driver, parentTitle);
		driver.findElement(By.xpath("//input[@id=\"qty1\"]")).sendKeys(eUtil.excelUtility("PO", 22, 1)+JavaUtility.generateRandomNumber());
		
		driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
		Thread.sleep(3000);
		
		//SignOut
//		WebElement signout = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//		wUtil.mouseHover(driver, signout);
//		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		
		
	}
	

}
