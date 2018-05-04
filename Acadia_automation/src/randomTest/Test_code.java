package randomTest;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.application.libraries.ExcelLib;

@SuppressWarnings("all")
public class Test_code 
{
	@FindBy(xpath="//input[@type='radio']")
	private List<WebElement> all_RadioButton;
	
	public static void main(String[] arg) throws IOException, InterruptedException
	
	{
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "E:\\suketas stuff\\Automation\\Acadia Framework\\browserdrivers\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();	
		//driver.get("https://bushtruckleasing.com");
		driver.get("http://52.14.164.233/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			
				
		
//		Select dropdown = new Select(driver.findElement(By.xpath("//*[@name='dropdown']//*[@name='jumpMenu']")));
//		List<WebElement> dd = dropdown.getOptions();
//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//		for(int i =1; i < dd.size() ;i++)
//		for(int i =1; i < 3 ;i++)
//		{
//			Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@name='dropdown']//*[@name='jumpMenu']")));
//			List<WebElement> dd1 = dropdown1.getOptions();
//			String company = dd1.get(i).getText();
//			System.out.println("dd1 :"+company);
//			dd1.get(i).click();
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			
//			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			Thread.sleep(1000);
//			String name = "E:\\suketas stuff\\Automation\\Acadia Framework\\Screenshots\\";
//			FileUtils.copyFile(scrFile, new File(name+company+"screenshot.png"));
//			
//			((JavascriptExecutor)driver).executeScript("window.open()");
//			
//			System.out.println(tabs.size());
//			driver.switchTo().window(tabs.get(0));
//			
//			driver.get("http://bushtruckleasing.com");
//			
//	  
//		}
//		
//		List<WebElement> linksize = driver.findElements(By.tagName("a")); 
//		int linksCount = linksize.size();
//		System.out.println("Total no of links Available: "+linksCount);
//		String[] links = new String[linksCount];
//		System.out.println("List of links Available: ");  
//		// print all the links from webpage 
//		for(int i=0;i<linksCount;i++)
//		{
//			links[i] = linksize.get(i).getAttribute("href");
//		
//			if(links[i] == null || links[i].isEmpty())
//			{
//				System.out.println("URL is either not configured for anchor tag or it is empty");
//			                continue;
//			}
//			 try {
//	                HttpURLConnection huc = (HttpURLConnection)(new URL(links[i]).openConnection());
//	                
//	                huc.setRequestMethod("HEAD");
//	                
//	                huc.connect();
//	                
//	                int respCode = huc.getResponseCode();
//	                
//	                if(respCode >= 400){
//	                    System.out.println(links[i]+" is a broken link");
//	                }
//	                else{
//	                   // System.out.println(links[i]+" is a valid link");
//	                }
//	                    
//	            } catch (MalformedURLException e) {
//	                // TODO Auto-generated catch block
//	                e.printStackTrace();
//	            } catch (IOException e) {
//	                // TODO Auto-generated catch block
//	                e.printStackTrace();
//	            }
//			// driver.quit();
//			
//		} 
//		System.out.println("LINK" +(links[50]));
//		// navigate to each Link on the webpage
//		for(int i=0;i<linksCount;i++)
//		{
//			((JavascriptExecutor)driver).executeScript("window.open()");
//			driver.switchTo().window(tabs.get(0));
//			driver.get("http://bushtruckleasing.cosdevx.com");
//			driver.navigate().to(links[i]);
//			
//			Thread.sleep(3000);
//		}
	}
//		driver.get("http://bushtruckleasing.cosdevx.com");
//		String url = driver.getCurrentUrl();
//		System.out.println(url);
//		System.out.println(excel.getRowCount("links"));
//		for(int i =0; i < 58;i++)
//		{
//			driver.get(url + excel.readFileData("links", i, i));
//			System.out.println(url);
//			
//			
//			//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//		}
		//

	
		
		
//		
////		String value = excel.readFileData("Campaigns", 2, 0);
////		System.out.println("value===="+value);
//		int row_index = excel.getRowCount("Audience Cluster");
//		System.out.println(row_index);
//		
////		HashMap<String,String> hm=new HashMap<String,String>();  
////		for (int i =1 ; i<=row_index; i++)
////		{
////		
////		hm.put(excel.readFileData("Audience Cluster", i, 0), excel.readFileData("Audience Cluster", i, 1));
////		System.out.println(hm.get("Name"));
////		
////		}
////		for(Map.Entry m:hm.entrySet())
////		{  
////			System.out.println("KEY--" + m.getKey()+ ", VALUE--" +m.getValue());
////
////		}
//		
//		// CAMPAIGN XL:
////		HashMap<String,String> hm=new HashMap<String,String>();  
////		for (int i =2 ; i<=row_index; i++)
////		{
////		
////		hm.put(excel.readFileData("Campaigns", i, 0), excel.readFileData("Audience Cluster", i, 1));
////		System.out.println(hm.get("Name"));
////		
////		}
////		
////		
////		for(Map.Entry m:hm.entrySet())
////		{  
////			System.out.println("KEY--" + m.getKey()+ ", VALUE--" +m.getValue());
////
////		}
////		
////		
//		
//		List<String> list = new ArrayList<String>();
//		list.add("united states, texas, dallas");
//		list.add("united states, texas, dallas, dallas county");
//		list.add("united states, texas");
//		list.add("united states, texas, dallas, dallas, 75001");
//		list.add("united states, frisco");
//		String some = "Texas";
//		for(String item: list)
//		{
//			System.out.println(item);
//			if (item.startsWith(some))
//			{
//				System.out.println("-------------" + true);
//			}
//			if (item.toLowerCase().contains(some.toLowerCase()))
//			{
//				System.out.println("-------------" + true);
//			}
//			else
//			{
//				System.out.println("-------------" + false);
//			}
//			
//		}
//		
//	
//	}
	
	
	

}
	
