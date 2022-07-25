package vtigerCucumber.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {

	public static String readDataFromPropertyFile(String key) throws Throwable {
		FileInputStream file=new FileInputStream(".\\propertyUti.properties");
		Properties properties = new Properties();
		properties.load(file);
		String value = properties.getProperty(key);
		return value;
	}

}
