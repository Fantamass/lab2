package com.bsuir.lab22;

import java.util.Set;

import com.bsuir.lab22.product.*;

public class Model {
    private static Model instance;      
    public static Model getInstance() {
        if(instance == null) {
        	instance = new Model();       
        } 
        return instance;
    }
    
    private Shop shop = new Shop();
    private Customer customer  = new Customer(50);
    private Cart cart = new Cart();
    
    public Set<Product> getProducts() {
    	return shop.getProducts();
    }
    
    public void customerHoldProduct(Product product) {
    	customer.holdProduct(product);
    }   
    
    public Product getHolded() {
    	return customer.getHolded();
    }  
    
    public void cartStoreProduct() {
    	customer.putIntoCart(cart);
    }
    
    public Product cartStored() {
    	return cart.getStored();
    }  
    
    public int shopAskForMoney() {
    	return shop.askForMoney(customer);
    }
}
