package com.application.tests;


import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class MainClass 
{
	public static void main (String args[])
	{
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = new ArrayList<String>();
		suites.add("E:/suketas stuff/Automation/Acadia Framework/Acadia/testng.xml");//path to xml..
		//suites.add("c:/tests/testng2.xml");
		testng.setTestSuites(suites);
		testng.run();
		
		
	}
}
