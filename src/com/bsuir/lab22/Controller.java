package com.bsuir.lab22;


import com.bsuir.lab22.product.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Controller {
    private static Controller instance;      
    public static Controller getInstance() {
        if(instance == null)
        	instance = new Controller();
        else if (view == null)
        	return null;        
        return instance;
    }
    
    private static View view;
    
    public void setStage(Stage viewStage) {
    	view = new View(viewStage);
    }
    
    public void start() {
    	view.create();
    	view.show();
    }

    public ObservableList<Product> getProductsCollection(){
    	return FXCollections.observableArrayList(Model.getInstance().getProducts());
    }

    
    public void buyButtonPressed() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Покупка");
    	if(Model.getInstance().cartStored() != null) {
    		int price = Model.getInstance().shopAskForMoney();
    		if(price > 0)
    			alert.setHeaderText("Списано " + String.valueOf(price) + " рублей");
    		else
    			alert.setHeaderText(Strings.INFO_NO_MONEY);
    	}
    	else {
        	alert.setHeaderText(Strings.INFO_CARD_EMPTY);
    	}
        
        alert.showAndWait();
    }
    
    public void getButtonPressed() {
    	Product geted = view.getComboBoxes().get("Products").getValue();
    	if(geted != null)
    		Model.getInstance().customerHoldProduct(geted);
    }
    
    public void putButtonPressed() {
    	Model.getInstance().cartStoreProduct();
    	view.getLabels().get(Strings.LABEL_CARD_STORED).setText(Model.getInstance().getHolded().toString());
    }    
}
