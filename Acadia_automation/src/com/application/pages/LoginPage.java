package com.application.pages;

import java.util.HashMap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.application.libraries.ExcelLib;

public class LoginPage {
	WebDriver driver;
	ExcelLib excel = new ExcelLib();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameInputField;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordInputField;

	@FindBy(xpath = "//button")
	private WebElement LoginButton;

	@FindBy(xpath = "//select")
	private WebElement Organization_dropdown;

	@FindBy(xpath = "//button[contains(text(), 'Continue')]")
	private WebElement Continue_next_page;

	public void login_activity() {
		int row_index = excel.getRowCount("Login");
		HashMap<String, String> hm = new HashMap<String, String>();
		for (int i = 0; i <= row_index; i++) {
			hm.put(excel.readFileData("Login", i, 0), excel.readFileData("Login", i, 1));

		}
        String[] credentials = hm.get("admin").split("/");
		System.out.println("Logging into the System");
		usernameInputField.sendKeys(credentials[0]);
		passwordInputField.sendKeys(credentials[1]);
		LoginButton.click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// SELECT ORG : CLARO BR (hard coded)
		Select org_dropdown = new Select(Organization_dropdown);
		org_dropdown.selectByIndex(1);
		System.out.println(org_dropdown.getOptions().get(1).getText() + "  is selected for testing");
		Continue_next_page.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
}
