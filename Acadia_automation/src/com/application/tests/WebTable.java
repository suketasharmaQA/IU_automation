package com.application.tests;

import com.application.libraries.ExcelLib;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WebTable {


    public static WebDriver driver;
    public static String url;
    ExcelLib excel = new ExcelLib();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "G:\\Automation\\IU_automation\\browserdrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("C:\\Users\\Suketa\\Downloads\\dropdown.html");
        System.out.println("__________________________________________");
        List<WebElement> row_list = driver.findElements(By.xpath("//table//tr"));
      //  WebElement first_row = driver.findElement(By.xpath("/table//tr"));
        List<WebElement> col_list = null;
        System.out.println(row_list.size());
        WebElement checkbox = null;
        int row_counter;
       for(int i=0; i<row_list.size(); i++)
       {
          System.out.println(row_list.get(i).getText());
           row_counter = i+1;
          col_list = driver.findElements(By.xpath("//table//tr["+row_counter+"]/td"));

          for(WebElement cell : col_list)
            {
                System.out.println(cell.getText().toString());
                String cell_val = cell.getText().toString();
                if( cell_val.equalsIgnoreCase("CTS"))
                {
                    checkbox = driver.findElement(By.xpath("//table//tr["+row_counter+"]/td[5]/input"));
                    checkbox.click();
                }
            }
        }
        List<WebElement> all_links = null;
        all_links = driver.findElements(By.xpath("//table//tr[3]/td[4]//a"));
        int size = all_links.size();
        for(WebElement link: all_links)
        {
            //keys for openning a new tab
           String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
           link.sendKeys(selectLinkOpeninNewTab);
        }

    }
}
