package com.application.tests;

import org.testng.annotations.Test;

import com.application.pages.CreateCampaignPage;

public class CreateCampaignTest extends BaseClass {

	@Test
	public void campaign_creation() throws InterruptedException {
		CreateCampaignPage create_camp_page = new CreateCampaignPage(driver, url);
		create_camp_page.create_campaign();
	}

}
