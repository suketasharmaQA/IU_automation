package randomTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.application.libraries.ExcelLib;

public class Test_code2 {
	@FindBy(xpath = "//input[@formcontrolname='phoneToCall']")
	private WebElement phoneToCall_input_box;

	public static void main(String[] arg) throws IOException, InterruptedException

	{
		ExcelLib excel = new ExcelLib();
		HashMap<String, String> hm = new HashMap<String, String>();
		// Get row count from excel
		int row_index = excel.getRowCount("Campaigns");

		// Map all first column values to the next column

		for (int i = 0; i <= row_index; i++) {
			hm.put(excel.readFileData("Campaigns", i, 0), excel.readFileData("Campaigns", i, 5));

		}
		System.out.println("------------" + hm.get("GoToWeb").substring(0, hm.get("GoToWeb").length() - 1)
				+ "  Phone number is set");
	}
}
