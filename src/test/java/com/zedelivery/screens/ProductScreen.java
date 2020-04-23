package com.zedelivery.screens;

import java.util.List;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductScreen extends BaseScreen {

	public ProductScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(accessibility = "submit-button")
	private MobileElement submitModal;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"open-search\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	private MobileElement openSearchInput;
	
	@AndroidFindBy(accessibility = "search-input")
	private MobileElement searchInput;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc='product-card-title'])")
	private List<MobileElement> ProductsList;
	
	@AndroidFindBy(accessibility = "bag-on-press")
	private MobileElement bagOnPressBtn;
	
	private void checkModal() {
		if (isVisible(submitModal)) {
			clickOn(submitModal);
		}
	}
	
	public ProductScreen searchForProduct(String productSearch, String productName, int qtd) {
		checkModal();
		clickOn(openSearchInput);
		sendValue(searchInput, productSearch);
		scrollProductList(productName);
		return new ProductDetailScreen(driver).addProductToCart(qtd);
	}
	
	private void scrollProductList(String productName) {
		scrollToElementForAndroid(productName);
		
		for(MobileElement element : ProductsList) {
			if(element.getText().equalsIgnoreCase(productName)) {
				clickOn(element);
				break;
			}
		}
	}
	
	public BagScreen openBag() {
		clickOn(bagOnPressBtn);
		return new BagScreen(driver);
	}
}
