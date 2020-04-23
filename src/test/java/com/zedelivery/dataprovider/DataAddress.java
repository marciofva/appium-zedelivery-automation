package com.zedelivery.dataprovider;

import java.util.HashMap;

public class DataAddress {
	
	public static HashMap<String, String> fullAddress() {
		HashMap<String, String> map = new HashMap<String, String>();
		 map.put("address", "Avenida Paulista, 1000");
		 map.put("complement", "apto: 98");
		return map;
	}
}
