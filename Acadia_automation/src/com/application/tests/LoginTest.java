package com.application.tests;

import org.testng.annotations.Test;
import com.application.pages.LoginPage;

public class LoginTest extends BaseClass
{
	@Test
	public void login_to_portal()
	{
		LoginPage loginPge = new LoginPage(driver);
		loginPge.login_activity();
	}
	
}
