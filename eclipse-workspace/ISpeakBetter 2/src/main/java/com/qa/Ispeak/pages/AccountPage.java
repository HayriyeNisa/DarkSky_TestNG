package com.qa.Ispeak.pages;

import org.openqa.selenium.WebDriver;

import com.qa.Ispeak.utils.ElementUtil;
import com.qa.Ispeak.utils.JavaScriptUtil;

public class AccountPage {

	WebDriver driver ; 
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	public String getAccountPageTitle() {
		
		return elementUtil.doGetPagetitle();
	
	}
	
}
