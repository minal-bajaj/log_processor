package com.minal.logProcessor;

import java.io.InputStream;
import java.util.Properties;

public class AppPath {

	public static final String logsDirectory;
	
	static {
		
		Properties properties = new Properties();
		try {
			InputStream s = AppPath.class.getResourceAsStream("/app.path.properties");
			properties.load(s);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		logsDirectory = properties.getProperty("logs.directory");
	}
	
	public static String getAbsolutePath(String fileName) {
		return logsDirectory + fileName;
	}
}