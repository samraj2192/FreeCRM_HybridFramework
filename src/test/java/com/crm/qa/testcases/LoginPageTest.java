package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CrmHomePage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	CrmHomePage crmHomePage;
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();//calls the parent class constructor
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		crmHomePage = new CrmHomePage();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void goLoginPage(){
		loginPage = crmHomePage.goLoginPage();
	}
	
	@Test(priority=2)
	public void loginPageUrlTest(){
		loginPage = crmHomePage.goLoginPage();
		String url = loginPage.validateLoginPage();
		Assert.assertEquals(url, "https://ui.freecrm.com/");
	}
	
	@Test(priority=3)
	public void loginTest(){
		loginPage = crmHomePage.goLoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
