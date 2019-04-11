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
    private Card card = new Card();
    
    public Set<Product> getProducts() {
    	return shop.getProducts();
    }
    
    public void customerHoldProduct(Product product) {
    	customer.holdProduct(product);
    }   
    
    public Product getHolded() {
    	return customer.getHolded();
    }  
    
    public void cardStoreProduct() {
    	card.storeProduct(customer.getHolded());
    }
    
    public Product cardStored() {
    	return card.getStored();
    }  
    
    public int shopAskForMoney() {
    	return shop.askForMoney(customer);
    }
}
