package com.zedelivery.factory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.zedelivery.properties.LoadProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class DriverFactory {
	
	private static AppiumDriver<MobileElement> driver;
	private static boolean isAndroid;
	
	public static AppiumDriver<MobileElement> getInstance(String platform, String deviceName) {

			isAndroid = "android".equalsIgnoreCase(platform);

			DesiredCapabilities capabilities = new DesiredCapabilities();

			if (isAndroid) {
				capabilities.setCapability(MobileCapabilityType.APP,  new File(LoadProperties.getPathApp("android")));
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
				capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
				capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
				capabilities.setCapability("appPackage", "com.cerveceriamodelo.modelonow");
				capabilities.setCapability("appActivity", ".MainActivity");
				capabilities.setCapability("autoGrantPermissions", true);
				capabilities.setCapability("resetKeyboard", true);
				capabilities.setCapability("gpsEnabled", true);
				try {
					setDriver(new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities));
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
			}
		return driver;
	}

	
	private static void setDriver(AppiumDriver<MobileElement> driver) {
		DriverFactory.driver = driver;
	}
}
