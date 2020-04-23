package com.zedelivery.screens;

import java.util.List;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OnboardingScreen extends BaseScreen{

	public OnboardingScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(accessibility = "already-have-an-account")
	private MobileElement haveAccountLink;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='create-account-later']/android.widget.TextView")
	private MobileElement createAccountLaterLink;
	
	@AndroidFindBy(accessibility = "button-yes")
	private MobileElement yesBtn;
	
	@AndroidFindBy(accessibility = "create-account-later")
	private MobileElement createAccountLaterBtn;
	
	@AndroidFindBy(accessibility = "address input")
	private MobileElement addressInput;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='address-card-auto-complete'])")
	private List<MobileElement> addressesList;
	
	@AndroidFindBy(accessibility = "complement-input")
	private MobileElement complementInput;
	
	@AndroidFindBy(accessibility = "continue")
	private MobileElement continueBtn;
	
	@AndroidFindBy(accessibility = "see-products")
	private MobileElement seeProductsBtn;
	
	public ProductScreen onboarding(String address, String complement) throws InterruptedException {
		waitForElementVisibility(createAccountLaterLink);
		clickOn(createAccountLaterLink);
		clickOn(createAccountLaterBtn);
		clickOn(yesBtn);
		submitAddress(address, complement);
		Thread.sleep(6000);
		clickOn(seeProductsBtn);
		return new ProductScreen(driver);
	}

	private void submitAddress(String address, String complement) {
		sendValue(addressInput, address);
		waitForElementVisibility(addressesList.get(0));
		clickOn(addressesList.get(0));
		sendValue(complementInput, complement);
		clickOn(continueBtn);
	}
}