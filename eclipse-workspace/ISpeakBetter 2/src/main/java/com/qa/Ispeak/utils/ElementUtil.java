package com.qa.Ispeak.utils;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Ispeak.Base.BasePage;



public class ElementUtil extends BasePage {
	WebDriverWait wait;
	WebDriver driver ;
	JavaScriptUtil javaScriptUtil;
	Properties properties ; 
	/**
	 * 
	 * @author hayriyebaskan
	 * gettitle method
	 * 
	 * 
	 * */
	


	 public ElementUtil(WebDriver driver) {
		this.driver=driver;
		 wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIME);
		 javaScriptUtil = new JavaScriptUtil(driver);
	}
	 /**
	  * 
	  *title wait method
	  * 
	  * */
	 public boolean  waitForTilePresent(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		
		return true ; 
	}
	 public boolean waitForelementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		return true;
		 
		 
	}
	 
	 public boolean  waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		return true ; 
	}
		
	public String doGetPagetitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting the title");
		}
		return null;
	}
	/**
	 *Get element
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		
		try {
			element = driver.findElement(locator);
			if (highlightElements) {
				javaScriptUtil.flash(element, driver);
			}
		} catch (Exception e) {
			System.out.println("some exception occured while creating web element");
		}
		return element;
	}
	public void doClick(By locator) {
		try{
		getElement(locator).click();
		
		}
		catch (Exception e) {
			System.out.println("some exception occured while clicking web element");
		}
	}
	
	/**
	 *Send   Keys method 
	 * 
	 * 
	 * */
	
	
	public void doSendKeys(By locator,String value) {
		
		try {
			WebElement element = getElement(locator);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			
		}
		
		
	}
	public boolean doisDisplayed(By locator) {
		
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("some exception occured with isDisplayed");
		}
		return false;
	}
public boolean doisEnabled(By locator) {
		
		try {
			return getElement(locator).isEnabled();
		} catch (Exception e) {
			System.out.println("some exception occured with isEnabled");
		}
		return false;
	}

public boolean doisSelected(By locator) {
	
	try {
		return getElement(locator).isSelected();
	} catch (Exception e) {
		System.out.println("some exception occured with isSelected");
	}
	return false;
}
public String doGettext(By locator) {
	try {
		
		return getElement(locator).getText();
		
		
	} catch (Exception e) {
		System.out.println("some exception occured while getting text");
	}
	return null;
}


public void  doSelectbyValue(By locator,String value) {
	WebElement element = driver.findElement(locator);
	Select select = new Select(element);
	select.selectByValue(value);
	
	
}
public void hoverOverAccount(By locator) {
	Actions action = new Actions(driver);
	WebElement accountElement = driver.findElement(locator);
    action.moveToElement(accountElement).build().perform();
	
	}	
	
}












