package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop = new Properties();
	public static String browser;
	// Static block to load properties only once
	static {
		try (FileInputStream ip = new FileInputStream("./src/test/resources/Config.properties")) {
			prop.load(ip);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties: " + e.getMessage(), e);
		}
	}
	// Retrieve a property value
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

	public static void setProperty(String key, String value) {
		prop.setProperty(key, value);
	}
	// Retrieve browser property (handles commented-out values)
	public static String getBrowser() {
		String browser = prop.getProperty("browser");
		return (browser != null && !browser.isEmpty()) ? browser.trim() : "chrome"; // Default to Chrome
	}

	public static void setBrowser(String browserValue) {
		browser = browserValue;
	}

	}