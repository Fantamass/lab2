package com.bsuir.lab22;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.bsuir.lab22.product.*;

public class View {
	private Stage primaryStage;
	private GridPane gridPane; 
	private Map<String, Label> labels  = new HashMap<String, Label>();
	private Map<String, ComboBox<Product>> comboBoxes  = new HashMap<String, ComboBox<Product>>();
	
	public Map<String, Label> getLabels(){
		return labels;
	}	
	
	public Map<String, ComboBox<Product>> getComboBoxes(){
		return comboBoxes;
	}
	
	public View(Stage viewStage) {
			primaryStage = viewStage;
			gridPane = new GridPane();
	        gridPane.setPadding(new Insets(5));
	        gridPane.setVgap(10); 
	        gridPane.setHgap(10); 
	        ColumnConstraints col1 = new ColumnConstraints();
	        col1.setPercentWidth(33);
	        ColumnConstraints col2 = new ColumnConstraints();
	        col2.setPercentWidth(33);
	        ColumnConstraints col3 = new ColumnConstraints();
	        col3.setPercentWidth(33);
	        gridPane.getColumnConstraints().addAll(col1,col2,col3);
	        viewStage.setTitle(Strings.SHOP_NAME);
	}
	
	private Button addButton(String title, int positionX, int positionY) {
		Button newButton = new Button(title);
        gridPane.add(newButton, positionY, positionX);
        newButton.setMaxWidth(Double.MAX_VALUE);
        newButton.setMaxHeight(Double.MAX_VALUE);
        GridPane.setHgrow(newButton, Priority.ALWAYS);
        GridPane.setVgrow(newButton, Priority.ALWAYS);
        return newButton;
	}
	
	private void addLabel(String title, int positionX, int positionY) {
		Label newLabel = new Label(title);
        gridPane.add(newLabel, positionY, positionX);
        newLabel.setMaxWidth(Double.MAX_VALUE);
        newLabel.setMaxHeight(Double.MAX_VALUE);
        GridPane.setHgrow(newLabel, Priority.ALWAYS);
        GridPane.setVgrow(newLabel, Priority.ALWAYS);
        newLabel.setFont(new Font("Arial", 20));
        labels. put(title, newLabel);
	}
	
	public void insertButtons() {
		addButton(Strings.BUTTON_BUY, 0, 2).setOnMouseClicked( (MouseEvent event) -> {Controller.getInstance().buyButtonPressed();} );		
		addButton(Strings.BUTTON_GET, 1, 1).setOnMouseClicked((MouseEvent event) -> {Controller.getInstance().getButtonPressed();} );	
		addButton(Strings.BUTTON_PUT, 1, 2).setOnMouseClicked((MouseEvent event) -> {Controller.getInstance().putButtonPressed();} );	
	}
	
	public void insertLabels() {
		addLabel(Strings.LABEL_CARD_STORED, 0, 1);
		labels.get(Strings.LABEL_CARD_STORED).setText("");
		addLabel(Strings.LABEL_SHOPPING_CARD, 0, 0);
	}
	
	public void insertComboBox() {
        ComboBox<Product> products = new ComboBox<Product>(Controller.getInstance().getProductsCollection());
        gridPane.add(products, 0, 1);
        products.setMaxWidth(Double.MAX_VALUE);
        products.setMaxHeight(Double.MAX_VALUE);
        GridPane.setHgrow(products, Priority.ALWAYS);
        GridPane.setVgrow(products, Priority.ALWAYS);
        comboBoxes.put("Products", products);
	}
	
	public void insertElements() {
		insertButtons();
		insertLabels();
		insertComboBox();
	}

	public void create() {
		insertElements();
		Scene scene = new Scene(gridPane,300,100);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
	}
	
	public void show() {
		primaryStage.show();
	}
}
