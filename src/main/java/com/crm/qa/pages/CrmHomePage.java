package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CrmHomePage extends TestBase{
	
	@FindBy(xpath = "//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement goLoginPagebtn;
	
	public CrmHomePage(){
		PageFactory.initElements(driver, this);	
	}
	
	public LoginPage goLoginPage(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		goLoginPagebtn.click();
		
		return new LoginPage();
	}

}
