package com.bsuir.lab22;

import com.bsuir.lab22.product.*;

public class Cart {
	private Product storedProduct;
	
	public void storeProduct(Product product) {
		storedProduct = product;
	}
	
	public Product getStored() {
		return storedProduct;
	}
}
