package com.application.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.application.pages.LoginPage;
import com.application.pages.LogoutPage;

public class LogoutTest {

	@Test(priority = 4)
	public void logout_to_portal() {

		LogoutPage logoutPge = new LogoutPage(BaseClass.driver);
		logoutPge.logout_activity();
		BaseClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Asserting logout");
		Assert.assertEquals("http://52.14.164.233/login", BaseClass.driver.getCurrentUrl());
	}

}
