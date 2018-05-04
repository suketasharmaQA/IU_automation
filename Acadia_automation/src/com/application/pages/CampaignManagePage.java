package com.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignManagePage 
{
	WebDriver driver;
	public CampaignManagePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(xpath="//a[contains(text(), 'Create Campaign')]")
	WebElement create_campaign_link;
	
	public void go_to_create_campaign_page()
	{
		create_campaign_link.click();
	}
	
	
	
	
}

