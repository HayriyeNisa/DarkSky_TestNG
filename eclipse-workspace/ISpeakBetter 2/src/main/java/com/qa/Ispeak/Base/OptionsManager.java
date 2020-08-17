package com.qa.Ispeak.Base;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	public ChromeOptions co  ; 
	public FirefoxOptions fo ;
	public Properties prop ; 
	
	
	public OptionsManager(Properties prop) {
		this.prop = prop ; 
	}
	
	public ChromeOptions getChromeOptions(){
		
		// Why we use ChromeOptions ?   --- 
	
		co = new ChromeOptions();
		
		if (prop.getProperty("incognito").equals("yes"))co.addArguments("--incognito") ;
			
		if (prop.getProperty("headless").equals("yes"))co.addArguments("--headless") ;
			
		return co;
		
		
	}
	
	
	public FirefoxOptions getFireFoxOptions() {
		
		fo = new FirefoxOptions();
		
		// incognito mode does not work in firefox
		
		if (prop.getProperty("headless").equals("yes"))fo.addArguments("--headless") ;
		
		return fo;
		
		
		
}
}
