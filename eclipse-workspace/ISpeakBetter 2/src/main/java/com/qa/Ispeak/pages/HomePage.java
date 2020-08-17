package com.qa.Ispeak.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.Ispeak.utils.Credentials;
import com.qa.Ispeak.utils.ElementUtil;
import com.qa.Ispeak.utils.JavaScriptUtil;

import com.sun.corba.se.spi.orbutil.fsm.Action;

public class HomePage {

	WebDriver driver ; 
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	Credentials userCred;
  public HomePage(WebDriver driver) {
	this.driver = driver;
	elementUtil = new ElementUtil(driver);
	javaScriptUtil = new JavaScriptUtil(driver);
}
	By pageHeader = By.xpath("//h1[contains(text(),'Speak English Better Wherever You Are')]");
	By icon = By.id("zsiq_agtpic");
	By iconHeader = By.id("attname");
	By email = By.id("_email");
	By password = By.id("_password");
	By loginBtn = By.id("cmdSignin");
	By errorText = By.id("crendentialsError");
	By loginLink = By.id("cmdSiginLink");
	
	public String getPageHeader() {
		return elementUtil.doGettext(pageHeader);
	}
	public String getPageTitle() {
		
		return elementUtil.doGetPagetitle();
		
	}
	public String getCheckBoxHeader() {
		driver.switchTo().frame(driver.findElement(By.id("siqiframe")));
		elementUtil.doClick(icon);
		return elementUtil.doGettext(iconHeader);
	}
	
public String getInvalidLoginMessage(Credentials userCred) {
	
     elementUtil.doClick(loginLink);
     elementUtil.waitForelementPresent(email);
	elementUtil.doSendKeys(email,userCred.getAppUserName());
	elementUtil.waitForelementPresent(password);
	elementUtil.doSendKeys(password,userCred.getAppPassword());
	elementUtil.waitForelementPresent(loginBtn);
	elementUtil.doClick(loginBtn);
	return elementUtil.doGettext(errorText);
	
	}

}
