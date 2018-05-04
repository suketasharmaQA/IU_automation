package com.application.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.application.libraries.DateFunctions;
import com.application.pages.AudienceClusterManagementPage;
import com.application.pages.CampaignManagePage;
import com.application.pages.CreateCampaignPage;


public class CampaignManageTest
{
	
	@Test(priority=1, description ="Campaign Creation : First Objective")
	public void CampaignManage_create_campaign() throws InterruptedException
	{
		CampaignManagePage campaign_manage_page = new CampaignManagePage(BaseClass.driver);
		campaign_manage_page.go_to_create_campaign_page();
		
		CreateCampaignPage create_campaign = new CreateCampaignPage(BaseClass.driver, BaseClass.url);
		create_campaign.create_campaign();
	}
	
	//login > campaign management > audience > audience management > create audience
	@Test (priority=2, description ="Audience Creation for All audience")
	public void CampaignManage_create_audience_ALL() throws InterruptedException
	{
		AudienceClusterManagementPage audience_cluster_mangement = new AudienceClusterManagementPage(BaseClass.driver);
		audience_cluster_mangement.go_to_new_audience_cluster_from_campaignmanagement();
		audience_cluster_mangement.create_ALL_audience();
		
				
	}
	
	@Test (priority=3 , description ="Audience Creation selecting all fields audience")
	public void CampaignManage_create_audience_all_fields() throws InterruptedException
	{
		AudienceClusterManagementPage audience_cluster_mangement = new AudienceClusterManagementPage(BaseClass.driver);
		audience_cluster_mangement.go_to_new_audience_cluster_from_campaignmanagement();
		audience_cluster_mangement.input_all_fields_audience_creation();
		
	}
	
		
	
	
	
//	@AfterMethod
//	public void writeResult(ITestResult result)
//	{
//	    try
//	    {
//	        if(result.getStatus() == ITestResult.SUCCESS)
//	        {
//
//	            //Do your excel writing stuff here
//	        }
//	        else if(result.getStatus() == ITestResult.FAILURE)
//	        {
//	            takeScreenshot(DateFunctions.get_current_timestamp(), driver, Thread.currentThread());
//	            System.out.println("Log Message:: @AfterMethod: Method-"+Thread.currentThread()+"- has Failed");
//	            //Do your excel writing stuff here
//
//	        }
//	        else if(result.getStatus() == ITestResult.SKIP)
//	        {
//	            System.out.println("Log Message::@AfterMethod: Method-"+Thread.currentThread()+"- has Skipped");
//
//	        }
//	    }
//	    catch(Exception e)
//	    {
//	        System.out.println("\nLog Message::@AfterMethod: Exception caught");
//	        e.printStackTrace();
//	    }
//
//	}
	
}
