package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	//every method read the value and return the value
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		System.out.println(url);
		return url;
	}
	
	public String getUsername()
	{
	String username=pro.getProperty("username");
	System.out.println(username);
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	System.out.println(password);
	return password;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}

}
