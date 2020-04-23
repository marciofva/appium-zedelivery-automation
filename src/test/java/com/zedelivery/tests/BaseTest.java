package com.zedelivery.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.zedelivery.dataprovider.DataAddress;
import com.zedelivery.factory.DriverFactory;
import com.zedelivery.screens.OnboardingScreen;
import com.zedelivery.screens.ProductScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTest {
	
	public static AppiumDriver<MobileElement> driver;
	protected OnboardingScreen Onboarding;
	protected ProductScreen product;
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "platform", "deviceName" })
	public void setup(String platform, String deviceName) throws InterruptedException {

		driver = DriverFactory.getInstance(platform, deviceName);

		product = new OnboardingScreen(driver).onboarding(DataAddress.fullAddress().get("address"), 
														  DataAddress.fullAddress().get("complement"));
	}
	
	@AfterTest
	public void afterMethod() {
		driver.resetApp();
		driver.quit();
	}
}
