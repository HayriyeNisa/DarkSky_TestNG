package com.qa.Ispeak.tests;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Ispeak.Base.BasePage;
import com.qa.Ispeak.pages.HomePage;
import com.qa.Ispeak.utils.AppConstants;
import com.qa.Ispeak.utils.Credentials;
import com.qa.Ispeak.utils.ElementUtil;



public class HomePageTest {
	WebDriver driver;
	HomePage homePage;
	Properties prop;
	BasePage basePage;
	ElementUtil elementUtil;
    Credentials userCred;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.Init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(4000);
	}
	@Test(priority = 1,description = "verify page title",enabled = false)
	public void verifyPageTitleTest() {
	String title = 	homePage.getPageTitle();
		Assert.assertEquals(title,AppConstants.HOME_PAGE_TITLE);
	}
	
	
	
	@Test(priority = 2 ,description = "verify page header ",enabled = false)
	public void verifyPageHeadertest() {
		String expHeader= homePage.getPageHeader();
		Assert.assertEquals(expHeader, AppConstants.HOME_PAGE_HEADER);
		
	}
	@Test(priority = 3,description = "verify chat box header",enabled = false)
	public void verifyChatBoxHeader() {
	String header = homePage.getCheckBoxHeader();
		Assert.assertEquals(header,AppConstants.CHAT_BOX_HEADER );
	}
	@DataProvider
	public Object[][] getLoginInvalidData(){
	
		Object data[][]={{"abcdef@email.com","abcdef"},
				{"abcdef@email.com","baskanhayriye"},
				{"baskanhayriye@email.com","babcdef"}};
		return data;
	}
	
	@Test(priority=4 ,dataProvider = "getLoginInvalidData", enabled = true)
	public void loginInvalidTestcase(String username,String pswd){
		homePage.getInvalidLoginMessage(userCred);
		userCred.setAppUserName(username);
		userCred.setAppPassword(pswd);
		String errorText = homePage.getInvalidLoginMessage(userCred);
		Assert.assertEquals(errorText,"Wrong Username or password!");}
	
	@AfterTest
	public void tearDown() {
		driver.quit();

	
}
	
}
