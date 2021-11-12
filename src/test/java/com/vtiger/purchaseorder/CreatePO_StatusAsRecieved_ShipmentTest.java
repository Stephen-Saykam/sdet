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

public class CreatePO_StatusAsRecieved_ShipmentTest extends BaseClass {
	
	@Test
	public void createPO_StatusAsRevieved_ShipmentTest() throws Throwable
	{
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
		wUtil.selectByIndex(dd, 4);
		
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
		
	}

}
