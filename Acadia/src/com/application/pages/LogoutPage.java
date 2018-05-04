package com.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage
{
	WebDriver driver;
	public LogoutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@class='nav navbar-top-links navbar-right']//a[@rel='button']")
	private WebElement username_link;
	
	@FindBy(xpath="//span[contains(text(), 'Log out')]")
    private WebElement logout_link;
			
	
	public void logout_activity()
	{
		driver.navigate().refresh();
		System.out.println("Logging out the session");
		username_link.click();
		logout_link.click();
	}
	

	
}
