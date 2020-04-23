package com.zedelivery.dataprovider;

import java.util.HashMap;
import org.testng.annotations.DataProvider;

public class DataProduct {
	
	public static HashMap<String, String> productSearch() {
		HashMap<String, String> map = new HashMap<String, String>();
		 map.put("searchForVodka", "Vodka");
		return map;
	}
	
	
	/***
	 * "Key": Product Name
	 * "Value": Quantity of units
	 */
	@DataProvider(name = "addToCartVodka")
	public Object[][] addToCartVodka() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		 map.put("Vodka Ciroc 750ml", 2);
		 map.put("Vodka Orloff 1L", 5);
		 map.put("Vodka Absolut Original 750ml", 1);
		 return new Object[][] { { map } };
	}
}
