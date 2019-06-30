package com.application.pages;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.application.libraries.DateFunctions;
import com.application.libraries.ExcelLib;
import com.application.libraries.Javascriptlib;

public class CreateCampaignPage {
	WebDriver driver;
	ExcelLib excel = new ExcelLib();
	String url;

	public CreateCampaignPage(WebDriver driver, String url) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.url = url;

	}

	@FindBy(xpath = "//input[@type='radio'][@name='campaign-objective-selection']")
	private List<WebElement> all_RadioButton;

	@FindBy(xpath = "//input[@type='radio'][@name='campaign-objective-selection']/parent::label")
	private List<WebElement> radiobutton_text;

	@FindBy(xpath = "//button[contains(text(), 'Continue')]")
	private WebElement objective_continue_button;

	@FindBy(xpath = "//input[@formcontrolname='campaign']")
	private WebElement campaign_name_input;

	@FindBy(xpath = "//select[@formcontrolname='category']")
	private WebElement category_dropdown;

	@FindBy(xpath = "//input[@formcontrolname='cluster']")
	private WebElement cluster_input_box;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	private List<WebElement> matching_cluster_result;

	@FindBy(xpath = "//input[@formcontrolname='content']")
	private WebElement content_input_box;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	private List<WebElement> matching_content_result;

	@FindBy(xpath = "//input[@formcontrolname='video_content']")
	private WebElement video_input_box;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	private List<WebElement> matching_video_result;

	// First Obj : go to web
	@FindBy(xpath = "//input[@formcontrolname='goToWeb']")
	private WebElement go_to_web_input_box;

	// Second Obj: go to playstore
	@FindBy(xpath = "//input[@formcontrolname='packageNameToInstallApp']")
	private WebElement packageNameToInstallApp_input_box;

	// Forth Obj: open App
	@FindBy(xpath = "//input[@formcontrolname='packageNameToOpenApp']")
	private WebElement open_app_input_box;

	// Fifth Obj: Call number
	@FindBy(xpath = "//input[@formcontrolname='phoneToCall']")
	private WebElement phoneToCall_input_box;

	@FindBy(xpath = "//input[@formcontrolname='notification_subject']")
	private WebElement notifcation_subject;

	@FindBy(xpath = "//input[@formcontrolname='notification_text']")
	private WebElement notifcation_text;

	@FindBy(xpath = "//input[@id='start_date']")
	private WebElement start_date_input;

	@FindBy(xpath = "//*[contains(@class,'owl-calendar-selected owl-day-today')]/a")
	private WebElement start_date;

	@FindBy(xpath = "//*[@formcontrolname='distribution_end_date']//td[contains(@class,'owl-day-today')]/a")
	private WebElement end_date;

	@FindBy(xpath = "//input[@id='end_date']")
	private WebElement end_date_input;

	@FindBy(xpath = "//select[@formcontrolname='goal_type']")
	private WebElement goal_type;

	@FindBy(xpath = "//button[contains(text(), 'SUBMIT')]")
	private WebElement submit_campaign;

	@FindBy(xpath = "//input[@formcontrolname='goal_price']")
	private WebElement goal_price;

	@FindBy(xpath = "//a[contains(text(),'+ Create custom Audience Cluster')]")
	private WebElement new_audience_cluster_link;

//	@FindBy(xpath="//div[@class='alertify-logs bottom right']/div")
//	private WebElement success_campaign_submit;

	@FindBy(xpath = "//input[@formcontrolname='goal_budget_flag']")
	private WebElement max_budget_flag;

	@FindBy(xpath = "//input[@formcontrolname='goal_budget']")
	private WebElement max_budget;

	@FindBy(xpath = "//input[@formcontrolname='goal_metric_flag']")
	private WebElement max_metric_flag;

	@FindBy(xpath = "//input[@formcontrolname='goal_metric']")
	private WebElement max_metric;

	public void create_campaign() throws InterruptedException {
		// LOOP for all Objectives:
		HashMap<String, String> hm = new HashMap<String, String>();
		// objective_num is a counter on objectives
		int number_of_objectives = all_RadioButton.size();
		System.out.println("number_of_objectives:" + number_of_objectives);
		for (int objective_num = 0; objective_num <= number_of_objectives - 1; objective_num++) {
			// Temporary code for objective of upload apk file
			if (objective_num == 2) {
				continue;
			}
			// Get row count from excel
			int row_index = excel.getRowCount("Campaigns");

			// Map all first column values to the next column

			for (int i = 0; i <= row_index; i++) {
				hm.put(excel.readFileData("Campaigns", i, 0), excel.readFileData("Campaigns", i, objective_num + 1));

			}

			System.out.println("Testing:  " + hm.get("Titles"));
			// Select OBJECTIVE
			String Current_Objective_text = radiobutton_text.get(objective_num).getText();
			all_RadioButton.get(objective_num).click();
			System.out.println("------------[" + Current_Objective_text + " ] objective is selected");
			if (objective_continue_button.isEnabled()) {
				objective_continue_button.click();

			} else {
				System.out.println("------------Objective button is NOT enabled OR objective NOT found"
						+ objective_continue_button.isEnabled());
			}

			// CAMPAIGN NAME get campaign name and send to input box
			String set_campaign_name = hm.get("Name of the campaign")
					+ DateFunctions.get_current_timestamp();
			System.out.println("------------" + set_campaign_name);
			campaign_name_input.sendKeys(set_campaign_name);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			// CATEGORY get drop-down value
			Select category_dropdown_selected_value = new Select(category_dropdown);
			category_dropdown_selected_value.selectByVisibleText(hm.get("Select Category"));
			System.out.println("------------[" + hm.get("Select Category") + "] as category selected");

			// CLUSTER SELECTION:
			// Sending input to search for cluster:
			cluster_input_box.sendKeys(hm.get("Audience Cluster"));
			// getting all result as a text
			String cluster_forced_input = hm.get("Audience Cluster");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (matching_cluster_result.size() == 0) {
				System.out.println("Matching Cluster not found");
				driver.close();
				driver.quit();
			}
			for (int i = 0; i < matching_cluster_result.size(); i++) {
				WebElement item;
				item = matching_cluster_result.get(i);
				if (item.getText().toLowerCase().contains(cluster_forced_input.toLowerCase())) {
					System.out.println("------------[" + item.getText() + " ] as a Audience cluster is selected");
					item.click();

					break;
				} else {
					System.out.println("This is not matching");
				}
			}

			Javascriptlib.scroll_page_js_code(driver,
					driver.findElement(By.xpath("//span[contains(text(), content)]")));

			// SELECT CONTENT
			// Sending input to search for content:
			content_input_box.sendKeys(hm.get("Content"));
			// getting all result as a text
			int j = 0;
			String content_forced_input = hm.get("Content");

			WebDriverWait wait_for_content_to_apprear = new WebDriverWait(driver, 10);
			wait_for_content_to_apprear.until(ExpectedConditions.visibilityOfAllElements(matching_content_result));

			for (WebElement item : matching_content_result) {
				item = matching_content_result.get(j);

				if (item.getText().toLowerCase().contains(content_forced_input.toLowerCase())) {
					System.out.println("------------[" + item.getText() + " ] as a Content is selected");
					item.click();

					break;

				} else {
					System.out.println(" some issue in selecting content");
					// will write to create Audience cluster
				}
				j++;
			}

			// Scrolling the page
			Javascriptlib.scroll_page_js_code(driver, video_input_box);

			// SELECT VIDEO
			video_input_box.sendKeys(hm.get("Video"));

			// getting all result as a text
			int k = 0;
			String video_forced_input = hm.get("Video");

			WebDriverWait wait_for_video_to_apprear = new WebDriverWait(driver, 20);
			wait_for_video_to_apprear.until(ExpectedConditions.visibilityOfAllElements(matching_video_result));

			for (WebElement item : matching_video_result) {
				item = matching_video_result.get(k);

				if (item.getText().toLowerCase().contains(video_forced_input.toLowerCase())) {
					System.out.println("------------[" + item.getText() + "]  as a Video is selected");
					item.click();

					break;

				} else {
					System.out.println(" some issue in selecting Video");
					// will write to create Video cluster
				}
				k++;
			}

			// Choose input on the basis of Objective
			if (Current_Objective_text.equalsIgnoreCase("Send people to your website")) {
				// Add go to Web link:
				go_to_web_input_box.sendKeys(hm.get("GoToWeb"));
				System.out.println("------------[" + hm.get("GoToWeb") + " ] Web link selected");

			} else if (Current_Objective_text
					.equalsIgnoreCase("Get installs of your application through Google Play")) {
				packageNameToInstallApp_input_box.sendKeys(hm.get("GoToWeb"));
				System.out.println("------------[" + hm.get("GoToWeb") + "]  PlayStore link selected");
			} else if (Current_Objective_text
					.equalsIgnoreCase("Ask people to open an existing application on their device")) {
				open_app_input_box.sendKeys(hm.get("GoToWeb"));
				System.out.println("------------[" + hm.get("GoToWeb") + " ] Package is set");
			} else if (Current_Objective_text.equals("Ask people to call a Phone number")) {
				String phone_number = hm.get("GoToWeb").substring(0, hm.get("GoToWeb").length() - 1);
				phoneToCall_input_box.sendKeys(phone_number);
				System.out.println("------------[" + phone_number + "]  Phone number is set");
			}

			// Add to Notification Subject
			notifcation_subject.sendKeys(hm.get("Notification Subject"));
			System.out.println("------------[" + hm.get("Notification Subject")
					+ " ] Notification Subject is selected");

			// Add to Notification Text
			notifcation_text.sendKeys(hm.get("Notification Text"));
			System.out.println(
					"------------[" + hm.get("Notification Text") + "]  Notification Text is selected");

			// Send start date input
			start_date_input.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			start_date.click();

			// Send end date
			end_date_input.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			end_date.click();

			// Scrolling the page
			Javascriptlib.scroll_page_js_code(driver, goal_type);

			// Set Goal Type:
			Select select_value = new Select(goal_type);
			select_value.selectByValue(hm.get("Goal Type"));
			System.out.println("------------[" + hm.get("Goal Type") + "]  Goal Type is selected");
			goal_price.sendKeys(hm.get("Goal Price"));
			System.out.println("------------[" + hm.get("Goal Price") + " ] Goal Price is selected");

			// Set Maximum budget
			max_budget_flag.click();
			max_budget.sendKeys(hm.get("Max budget"));

			// Set Maximum metric
			max_metric_flag.click();
			max_metric.sendKeys(hm.get("Max metric"));
			// Submit the campaign
			try {
				submit_campaign.click();

			} catch (Exception EE) {
				System.out.println("Campaign Submit button is not enabled");
				driver.quit();
			}

			System.out.println("------------Campaign Form submitted");

			System.out.println("------------[" + set_campaign_name + "] is created");
			System.out.println("__________________________________");
			Thread.sleep(5000);
			driver.get(url + "/campaign/manage");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			if (objective_num != number_of_objectives) {
				CampaignManagePage campaign_manage_page = new CampaignManagePage(driver);
				campaign_manage_page.go_to_create_campaign_page();
			}

		}

	}

}
