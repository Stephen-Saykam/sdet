package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {
	
	//3.Execute all the elements & Initialise the elements PageFactory.initElements (Initialisation)
	public LoginClass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//1. Create a seperate java class for every page in a application
	//2.Identify all the elements using @findBy , @findBys & @findAll (Decleration)
	
	@FindBy(name="user_name") private WebElement userTxtFld;
	@FindBy(name="user_password") private WebElement psdTxtFld;
	@FindBy(id="submitButton") private WebElement loginBtn;
	
	//4. Declare all the elements as Private & provide Getter Method, Business Method for (Utilization)
	
	public WebElement getUserTxtFld() {
		return userTxtFld;
	}
	public WebElement getPsdTxtFld() {
		return psdTxtFld;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//5. Business Logic
	public void loginIntoApp(String username, String password)
	{
		userTxtFld.sendKeys(username);
		psdTxtFld.sendKeys(password);
		loginBtn.click();
		
	}
	
	
	
	
}
