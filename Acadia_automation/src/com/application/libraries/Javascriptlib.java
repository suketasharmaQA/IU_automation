package com.application.libraries;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Javascriptlib {

	public static void scroll_page_js_code(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void remove_readonlyattribute(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", element);
	}
}
