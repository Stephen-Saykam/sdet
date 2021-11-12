package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericLib.WebDriverUtility;

public class HomeClass {
	
	WebDriver driver;
	public HomeClass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations") private WebElement orgLink;
	@FindBy(xpath="//img[@src=\\\"themes/softed/images/user.PNG") private WebElement admImg;
	@FindBy(linkText="Sign Out") private WebElement signOutBtn;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getAdmImg() {
		return admImg;
	}
	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
	//Business Logic for clicking on Organization
	public void clickOnOrganization()
	{
		orgLink.click();
	}
	
	public void signOutFromApp() throws InterruptedException
	{
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.mouseHover(driver, admImg);
		Thread.sleep(3000);
		signOutBtn.click();
	}
	

}
