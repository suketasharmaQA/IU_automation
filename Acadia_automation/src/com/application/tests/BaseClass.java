package com.application.tests;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import com.application.libraries.ExcelLib;

public class BaseClass 
{


	public static WebDriver driver;
	public static String url;
	ExcelLib excel = new ExcelLib();
			
	@BeforeSuite
	public void setup () 
	{	
		
		//FireFox CODE:
			//FirefoxBinary firefoxBinary = new FirefoxBinary();
			//firefoxBinary.addCommandLineOptions("--headless");
			System.setProperty("webdriver.gecko.driver", "E:\\suketas stuff\\Automation\\Acadia Framework\\browserdrivers\\geckodriver-v0.20.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			//FirefoxOptions firefoxOptions = new FirefoxOptions();
			//firefoxOptions.setBinary(firefoxBinary);
			//driver = new FirefoxDriver(firefoxOptions);
		
		//CHROME CODE:
//			System.setProperty("webdriver.chrome.driver", "E:\\suketas stuff\\Automation\\Acadia Framework\\browserdrivers\\chromedriver_win32\\chromedriver.exe");
//			driver=new ChromeDriver();
		
			driver.manage().window().maximize();			
			//driver.manage().window().maximize();
			int row_index = excel.getRowCount("Environment");
			HashMap<String,String> hm = new HashMap<String,String>();
			for (int i =0 ; i<=row_index; i++)
			{		
				hm.put(excel.readFileData("Environment", i, 0), excel.readFileData("Environment", i, 1));
			
			}
			url = hm.get("Dev").toString();
			driver.get(url);
			System.out.println("__________________________________________");
			System.out.println("Launching webaddress :"+url);

	}
	
//	@AfterTest
//	public void quit()
//	{
////		LogoutTest logout = new LogoutTest();
////		logout.logout_to_portal(driver);
//
//		System.out.println("Quiting the driver");
//		driver.quit();
//	}


}
