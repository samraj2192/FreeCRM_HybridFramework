package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//span[contains(text(),'Samraj Bhowmik')]")
	WebElement user;
	
	@FindBy(xpath = "//div[contains(@class,'content card-header')]/a[@name='settings']/i")
	WebElement contactsActivityStream;
	
	@FindBy(xpath = "//a[@href='/home']//span[contains(text(),'Home')]")
	WebElement home;
	
	@FindBy(xpath = "//a[@href='/contacts']//span[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath = "//a[@href='/deals']//span[contains(text(),'Deals')]")
	WebElement deals;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageUrl(){
		return driver.getCurrentUrl();
	}
	
	public String verifyHomePageUrl(){
		home.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyUser(){
		return user.getText();
	}
	
	public void clickContactsActivityStreamSettings(){
		contactsActivityStream.click();
	}
	
	public ContactsPage goToContactsPage(){
		contacts.click();
		return new ContactsPage();
	}
	
	public DealPage goToDealsPage(){
		deals.click();
		return new DealPage();
	}
}
