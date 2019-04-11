package com.bsuir.lab22;

import com.bsuir.lab22.product.*;;

public class Customer {
	private Product holdedProduct;
	private int money;
	
	public Customer(int money) {
		this.money = money;
	}
	
	public void holdProduct(Product product) {
		holdedProduct = product;
	}
		
	public Product getHolded() {
		return holdedProduct;
	}
	
	public int pay() {
		if(money >= 10) {
			money = money - 10;
			return 10;
		}
		return 0;
	}
}
