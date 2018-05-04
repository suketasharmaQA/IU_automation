package com.application.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AudienceClusterManagementPage 
{

	WebDriver driver;
	public AudienceClusterManagementPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(xpath="//a/span[contains(text(), 'AUDIENCE')]")
	private WebElement audience_nav_link;
	
	@FindBy(xpath="//a[contains(text(), 'Cluster Mgmt')]")
	private WebElement create_audience_link;
	
	@FindBy(xpath="//*[contains(text(), 'New Cluster')]")
	private WebElement new_audience_button;
	
	@FindBy(xpath="//h2[contains(text(), 'CLUSTER MANAGEMENT')]")
	private WebElement title_of_page;
	
	@FindBy(xpath="//*[contains(@class,'iu-userlist-table')]")
	private WebElement audience_cluster_table;
	
	public void go_to_new_audience_cluster_from_campaignmanagement()
	{
	
		// go to audience management page
		
		System.out.println("Clusters Creation started............");
		if (!(driver.getCurrentUrl()).contains("/cluster/manage"))
		{
			
			audience_nav_link.click();
			create_audience_link.click();
			WebDriverWait wait_toload_page = new WebDriverWait(driver, 10);
			wait_toload_page.until(ExpectedConditions.visibilityOf(title_of_page));
			new_audience_button.click();
		}
		else
		{
			driver.navigate().refresh();
			new_audience_button.click();
		}
	}
	
	public void create_ALL_audience() throws InterruptedException
	{
		AudienceCreationPage audience_creation = new AudienceCreationPage(driver);
		String cluster_name = audience_creation.ALLaudience_creation();
		System.out.println(cluster_name +" Asserting if this cluster is created");
		boolean flag = audience_creation.assert_audience_cluster_list(cluster_name);
		if (flag = false)
		{
			System.out.println("Audience Cluster created : FALSE");
		}
		else
		{
			System.out.println("Audience Cluster created : TRUE");
		}			
		System.out.println("__________________________________");
		
	}
	
	public void input_all_fields_audience_creation() throws InterruptedException
	{
		AudienceCreationPage audience_creation = new AudienceCreationPage(driver);
		String cluster_name = audience_creation.all_fields_audience_cluster();
		System.out.println(cluster_name +" Asserting if this cluster is created");
		boolean flag = audience_creation.assert_audience_cluster_list(cluster_name);
		if (flag = false)
		{
			System.out.println("Audience Cluster created : FALSE");
		}
		else
		{
			System.out.println("Audience Cluster created : TRUE");
		}			
		System.out.println("__________________________________");

	}

	
}
