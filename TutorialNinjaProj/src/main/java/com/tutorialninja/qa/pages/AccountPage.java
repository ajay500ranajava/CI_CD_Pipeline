package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;
	
	@FindBy(linkText="Change your password")
	private WebElement editYourAccountInformation;

	public AccountPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean validateEditYourAccountInfoIsDisplayed(){
	boolean displayStatus=editYourAccountInformation.isDisplayed();
	return displayStatus;
	}
}
