package com.netsky.farmfresh.tools.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

public class ToolBox {

	//Method 1: Get the current date to insert in the DB
	public static java.sql.Date GetCurrentDate() {
		
		//Create a calendar object and get the current date
		Calendar currCal = Calendar.getInstance();
		java.sql.Date currdate = new java.sql.Date(currCal.getTime().getTime());
		
		return currdate;
	}
	
	//Method 2: Calculate MD5 encryption for password
	//Reference source: https://www.avajava.com/tutorials/lessons/how-do-i-generate-an-md5-digest-for-a-string.html
	public static String GetMD5(String arg) throws NoSuchAlgorithmException {
		
		MessageDigest mdObject = MessageDigest.getInstance("MD5");
		mdObject.update(arg.getBytes());
		byte[] digest = mdObject.digest();
		StringBuffer buffer = new StringBuffer();
		
		for (byte b : digest) {
			buffer.append(String.format("%02x", b & 0xff));
		}

		return buffer.toString();
	}
	
	
}
