package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement Loginbtn;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot ')]")
	WebElement ForgotPwdbtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPage(){
		return driver.getCurrentUrl();
	}
	
	public HomePage login(String un, String pwd){
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		username.sendKeys(un);
		password.sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		Loginbtn.click();
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		
		return new HomePage();
	}

}
