package com.application.pages;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.application.libraries.DateFunctions;
import com.application.libraries.ExcelLib;
import com.application.libraries.Javascriptlib;

public class AudienceCreationPage {

	WebDriver driver;
	ExcelLib excel = new ExcelLib();

	@FindBy(xpath = "//input[@formcontrolname='name']")
	private WebElement cluster_name;

	@FindBy(xpath = "//button[@form = 'audienceClusterModalForm'][@type='submit']")
	private WebElement cluster_submit;

	@FindBy(xpath = "//input[@formcontrolname='location']")
	private WebElement location_input_box;

	@FindBy(xpath = "//div[@role='listbox']/mat-option")
	private List<WebElement> location_match_result;

	@FindBy(xpath = "//input[@formcontrolname='installed_apps']")
	private WebElement installed_apps_input_box;

	@FindBy(xpath = "//div[@role='listbox']/mat-option")
	private List<WebElement> installed_apps_match_result;

	@FindBy(xpath = "//input[@formcontrolname='makers']")
	private WebElement makers_input_box;

	@FindBy(xpath = "//div[@role='listbox']/mat-option")
	private List<WebElement> makers_match_result;

	@FindBy(xpath = "//mat-select[@formcontrolname='operating_system']")
	private WebElement os_input;

	@FindBy(xpath = "//mat-option[contains(@id, 'mat-option')]")
	private List<WebElement> os_version;

	@FindBy(xpath = "//mat-select[@formcontrolname='wireless']")
	private WebElement wireless_input;

	@FindBy(xpath = "//mat-option[contains(@id, 'mat-option')]")
	private List<WebElement> wireless_options;

//	@FindBy(xpath="//*[span='Name']/parent::*/parent::*/parent::*/tbody/tr")
//	private List<WebElement> assert_cluster_list;

	HashMap<String, String> hm = new HashMap<String, String>();

	public AudienceCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//ALL Audience Cluster creation:	
	public String ALLaudience_creation() {
		System.out.println("Creating Audience as ALL");

		// Get row count from excel
		int row_index = excel.getRowCount("Audience Cluster");

		// Map all first column values to the next column

		for (int i = 1; i <= row_index; i++) {
			hm.put(excel.readFileData("Audience Cluster", i, 0), excel.readFileData("Audience Cluster", i, 1));

		}

		// Scrolling the page
		Javascriptlib.scroll_page_js_code(driver, cluster_name);

		// SEND input to cluster name:
		String cluster_created = hm.get("Name") + " " + DateFunctions.get_current_timestamp();
		cluster_name.sendKeys(cluster_created);
		try {

			WebDriverWait wait_for_cluster_to_apprear = new WebDriverWait(driver, 10);
			wait_for_cluster_to_apprear.until(ExpectedConditions.elementToBeClickable(cluster_submit));
			cluster_submit.click();
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("------------ [ " + cluster_created + " ] is created..");
		System.out.println("-----------------------------------------");
		return cluster_created;

	}

//	Field input Audience Cluster creation:
	public String all_fields_audience_cluster() throws InterruptedException {
		String cluster_created;
		System.out.println("Creating Audience with all fields");
		// Get row count from excel
		int row_index = excel.getRowCount("Audience Cluster");

		// Map all first column values to the next column
		HashMap<String, String> hm = new HashMap<String, String>();
		for (int i = 1; i <= row_index; i++) {
			hm.put(excel.readFileData("Audience Cluster", i, 0), excel.readFileData("Audience Cluster", i, 2));

		}

		// LOCATION SELECTION:
		// Sending input to search for cluster:
		String cluster_forced_input = hm.get("Location");
		location_input_box.sendKeys(cluster_forced_input);
		// getting all result as a text
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for (int i = 0; i < location_match_result.size(); i++) {
			WebElement item;
			item = location_match_result.get(i);
			if (item.getText().toLowerCase().contains(cluster_forced_input.toLowerCase())) {
				System.out.println("------------  Location selected as: [" + item.getText());
				item.click();

				break;
			} else {
//						
				// System.out.println("This is not matching");
			}
		}

		// Installed Applications SELECTION:
		String installedApp_forced_input = hm.get("Installed Applications");
		installed_apps_input_box.sendKeys(installedApp_forced_input);
		// getting all result as a text
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		for (int i = 0; i < installed_apps_match_result.size(); i++) {
			WebElement item;
			item = installed_apps_match_result.get(i);

			if (item.getText().toLowerCase().contains(installedApp_forced_input.toLowerCase())) {
				System.out.println("------------ Installed application selected as: " + item.getText());
				item.click();

				break;
			} else {
//						
				// System.out.println("This is not matching");
			}
		}

		// Device Manufacturer / Model SELECTION:
		String makers_forced_input = hm.get("Device Manufacturer / Model");
		makers_input_box.sendKeys(makers_forced_input);
		// getting all result as a text

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		for (int i = 0; i < makers_match_result.size(); i++) {
			WebElement item;
			item = makers_match_result.get(i);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElements(item));

			if (item.getText().toLowerCase().contains(makers_forced_input.toLowerCase())) {

				System.out.println("------------  Device selected as: " + item.getText());
				item.click();

				break;
			} else {
				// System.out.println("This is not matching");
			}
		}
		// OS Selection:
		os_input.click();
		WebDriverWait wait_for_element_to_apprear = new WebDriverWait(driver, 10);
		wait_for_element_to_apprear.until(ExpectedConditions.visibilityOfAllElements(os_version));

		String os_version_forced_input = hm.get("Os verison");
		for (int i = 0; i < os_version.size(); i++) {
			WebElement item;
			item = os_version.get(i);
			if (item.getText().toLowerCase().contains(os_version_forced_input.toLowerCase())) {
				System.out.println("------------  OS selected as: " + item.getText());
				item.click();

				break;
			} else {
				// System.out.println("This is not matching");
			}
		}

		// WIRELESS OPTION SELECTION
		wireless_input.click();

		String wireless_forced_input = hm.get("Wireless Operator");
		for (int i = 0; i < wireless_options.size(); i++) {
			WebElement item;
			item = wireless_options.get(i);
			if (item.getText().toLowerCase().contains(wireless_forced_input.toLowerCase())) {
				System.out.println("------------ Wireless selected as: " + item.getText());
				item.click();

				break;
			} else {
				// System.out.println("This is not matching");
			}
		}

		// SEND input to cluster name:
		String setting_cluster_name = hm.get("Name") + " " + DateFunctions.get_current_timestamp();
		cluster_name.sendKeys(setting_cluster_name);
		try {

			WebDriverWait wait_for_cluster_to_apprear = new WebDriverWait(driver, 10);
			wait_for_cluster_to_apprear.until(ExpectedConditions.elementToBeClickable(cluster_submit));
			cluster_submit.click();
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("------------ Audience cluster as [ " + setting_cluster_name + " ] is created..");
		System.out.println("-------------------------------");

		cluster_created = setting_cluster_name;
		return cluster_created;

	}

	public boolean assert_audience_cluster_list(String cluster_name) throws InterruptedException {
		// driver.navigate().refresh();
		List<WebElement> assert_cluster_list = driver
				.findElements(By.xpath("//*[span='Name']/parent::*/parent::*/parent::*/tbody/tr/td[1]"));
		boolean flag = false;
		// System.out.println("SIZE : " +assert_cluster_list.size());
		for (WebElement e : assert_cluster_list) {
			System.out.println("LIST E :" + e.getText().toLowerCase());
			if ((e.getText().toLowerCase()).equals(cluster_name.toLowerCase())) {
				flag = true;
				break;

			}

		}
		return flag;

	}

}
