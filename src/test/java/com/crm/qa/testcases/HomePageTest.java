package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CrmHomePage;
import com.crm.qa.pages.DealPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



public class HomePageTest extends TestBase {
	CrmHomePage crmHomePage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealPage dealPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		crmHomePage = new CrmHomePage();
		loginPage = crmHomePage.goLoginPage();
		homePage = new HomePage();
	}
	
	@Test(priority = 2)
	public void urlTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(17, TimeUnit.SECONDS);
		String pageUrl = homePage.verifyPageUrl();
		Assert.assertEquals(pageUrl, "https://ui.freecrm.com/", "Homepage url is not right");
	}
	
	@Test(priority = 1)
	public void homePageUrlTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(17, TimeUnit.SECONDS);
		String pageUrl = homePage.verifyHomePageUrl();
		Assert.assertEquals(pageUrl, "https://ui.freecrm.com/home", "Homepage url is not right");
	}
	
	@Test(priority = 4)
	public void theContactsPage(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(17, TimeUnit.SECONDS);
		contactsPage = homePage.goToContactsPage();
		driver.manage().timeouts().pageLoadTimeout(17, TimeUnit.SECONDS);
	}
	
	@Test(priority = 3)
	public void theDealPage(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(17, TimeUnit.SECONDS);
		dealPage = homePage.goToDealsPage();
		driver.manage().timeouts().pageLoadTimeout(17, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
