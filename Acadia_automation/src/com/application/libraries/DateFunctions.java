package com.application.libraries;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFunctions

{

	public static String get_current_date() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String get_current_timestamp() {
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
