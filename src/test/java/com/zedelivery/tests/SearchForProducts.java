package com.zedelivery.tests;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import org.testng.annotations.Test;
import com.zedelivery.dataprovider.DataProduct;
import com.zedelivery.screens.BagScreen;

public class SearchForProducts extends BaseTest {
		
	protected BagScreen bag;
	
	@Test(dataProviderClass = DataProduct.class, dataProvider = "addToCartVodka")
	public  void searchThroughMenu(HashMap<String, Integer> map) throws InterruptedException {
		
		int totalProducts = 0;
		ArrayList<String> searchList = new ArrayList<String>();
		
		for (Entry<String, Integer> entry : map.entrySet()) {			
			product.searchForProduct(DataProduct.productSearch().get("searchForVodka"), entry.getKey(), entry.getValue());
			totalProducts += entry.getValue();
			searchList.add(entry.getKey());
		}
		
		bag = product.openBag();
		
		//Check total of products in bag
		assertEquals(map.size(), bag.getTotalOfProducts());
		
		//Check all products in bag
		Collections.sort(searchList);
		assertEquals(bag.getProductListInBag(), searchList);
		
		//Check total of product units in bag
		assertEquals(totalProducts, bag.getTotalUnitProducts());		
	}
}
