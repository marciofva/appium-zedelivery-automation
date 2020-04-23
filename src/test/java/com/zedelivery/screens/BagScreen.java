package com.zedelivery.screens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BagScreen extends BaseScreen {
	
	public static final String FINISH_BUTTON_LITERAL = "ENTRAR PARA CONTINUAR";

	public BagScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(accessibility = "search-input")
	private MobileElement searchInput;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc='product-card-title'])")
	private List<MobileElement> productNameListBag;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='default-product-card'])[1]")
	private MobileElement productCardBag;
	
	@AndroidFindBy(accessibility = "total-qty-products")
	private MobileElement summaryTotalProducts;
	
	@AndroidFindBy(accessibility = "button-finish-purchase")
	private MobileElement finishPurchaseBtn;
	
	
	public ArrayList<String> getProductListInBag() {
		ArrayList<String> bagProductList = new ArrayList<String>();
		
		for(MobileElement element : productNameListBag) {
			bagProductList.add(element.getText());
		}
		Collections.sort(bagProductList);
		return bagProductList;
	}
	
	public int getTotalUnitProducts() {
		scrollToElementForAndroid(FINISH_BUTTON_LITERAL);
		return Integer.parseInt(summaryTotalProducts.getText().split(" ")[0]);
	}
	
	public int getTotalOfProducts() {
		waitForElementVisibility(productCardBag);
		return productNameListBag.size();
	}
}
