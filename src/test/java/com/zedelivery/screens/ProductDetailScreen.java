package com.zedelivery.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductDetailScreen extends BaseScreen {

	public ProductDetailScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(accessibility = "add-to-checkout")
	private MobileElement addToCheckoutBtn;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='minus-button']/android.widget.TextView")
	private MobileElement decreaseBtn;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='plus-button']/android.widget.TextView")
	private MobileElement increaseBtn;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='continue-buying']/android.widget.TextView")
	private MobileElement continuePurchaseLink;
	
	public ProductScreen addProductToCart(int qtd) {
		for(int i=1; i < qtd; i++) {
			clickOn(increaseBtn);
		}
		clickOn(addToCheckoutBtn);
		clickOn(continuePurchaseLink);
		return new ProductScreen(driver);
	}
}
