package com.uni.mapintegration;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class is used to manipulate string and do various string operations.
 * */
public class StringUtils {

	/**
	 * This method is used to convert input stream to string.
	 * 
	 * @param inputStream
	 *            Input stream to be converted to String.
	 * */
	public static String convertStreamToString(InputStream inputStream) {
		if (inputStream == null)
			return null;
		String line = "";
		StringBuilder total = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(
				inputStream));
		try {
			while ((line = rd.readLine()) != null) {
				total.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return total.toString();
	}

	/**
	 * This method is used to convert minutes in integer format to String in
	 * ÔHH:MMÕ. format
	 * 
	 * @param minutes
	 *            Minutes to be converted to String HH:MM format.
	 * */
	public static String convertMinutesToHhMmFormattedString(int minutes) {
		String hHMMFormattedString = null;
		int hour = 0;
		String hourString, minuteString;
		hour = minutes / 60;
		minutes = minutes - (hour * 60);
		if (hour > 9)
			hourString = "" + hour;
		else
			hourString = "0" + hour;
		if (minutes > 9)
			minuteString = "" + minutes;
		else
			minuteString = "0" + minutes;
		hHMMFormattedString = hourString + ":" + minuteString;
		return hHMMFormattedString;
	}
}
