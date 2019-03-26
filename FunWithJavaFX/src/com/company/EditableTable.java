package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

//TL:DR
// ->Make class with proporties
// ->Throw to ObservableList / or use DataBase
// ->Make TableColumn objects using list (remember to use same name as field in class!!!)/ case insensitive
// ->Make table using those columns
// ->Profit!

public class EditableTable extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Stage window;
    TableView<ProductDataBase> table;

    //Definiowanie wejsc
    TextField nameInput, priceInput, quantityInput;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Table View");


        TableColumn<ProductDataBase, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<ProductDataBase, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<ProductDataBase, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("Quantity"));

        //Tworzenie wejsc
        nameInput = new TextField();
        nameInput.setPromptText("name here");
        nameInput.setMinWidth(100);

        priceInput = new TextField();
        priceInput.setPromptText("price here");
        priceInput.setMinWidth(100);

        quantityInput = new TextField();
        quantityInput.setPromptText("quantity here");
        quantityInput.setMinWidth(100);
        // creating an interactive interface
            //Buttons
            Button addButton = new Button("Add");
            Button delButton = new Button("delete");
                //Add functionality to buttons
                addButton.setOnAction(e -> addClicked());
                delButton.setOnAction(e -> delClicked());
            //Layout
            HBox hbox = new HBox();
                hbox.setPadding(new Insets(10, 10, 10, 10));
                hbox.setSpacing(10);
                hbox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, delButton);

        table = new TableView<>();
            table.setItems(getProduct());
            table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);


        // Remember to embed Hbox in Vbox!!!!
        VBox vbox = new VBox();
            vbox.getChildren().addAll(table, hbox);
        Scene scene = new Scene(vbox);
            window.setScene(scene);
            window.show();
    }

    // Adding items
    public void addClicked() {
        ProductDataBase product = new ProductDataBase();
        //Parsowanie danych
            product.setName(nameInput.getText());
            product.setPrice(Double.parseDouble(priceInput.getText()));
            product.setQuantity(Integer.parseInt(quantityInput.getText()));
        // didawabue di tabeli
            table.getItems().add(product);
        // czyszczenie pol, tu akurat ma sens
            nameInput.clear();
            priceInput.clear();
            quantityInput.clear();
    }

    //Deleting Items
    public void delClicked() {
        //Tworzymy dwie obserwowane Listy, produkty zaznaczone i wszystkie produkty
        ObservableList<ProductDataBase> productSelected, allProducts;
        // przypisujemy do Listy produkty z bazy danych
        allProducts = table.getItems();
        //przypisujemy do listy zaznaczone produkty
        productSelected = table.getSelectionModel().getSelectedItems();
        // usuwamy za pomocą uproszczonego for eacha, można też tradycyjnie
//        for(ProductDataBase zabawka: productSelected){
//            table.getItems().remove(zabawka);
//                    }
        productSelected.forEach(allProducts::remove);
    }





// Data must follow getter/setter naming convention whitch is getName/setName etc..
    //Get All Products dummy Data Base
    public ObservableList<ProductDataBase> getProduct() {
        ObservableList<ProductDataBase> produkty = FXCollections.observableArrayList();
        produkty.add(new ProductDataBase("Laptop", 1899.99, 20));
        produkty.add(new ProductDataBase("Toilet", 599.99, 50));
        produkty.add(new ProductDataBase("Ball", 2.99, 200));
        produkty.add(new ProductDataBase("Porn", 9.99, 120));

        return produkty;
    }


}
