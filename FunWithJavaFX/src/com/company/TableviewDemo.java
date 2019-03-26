package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

//TL:DR
// ->Make class with proporties
// ->Throw to ObservableList / or use DataBase
// ->Make TableColumn objects using list (remember to use same name as field in class!!!)/ case insensitive
// ->Make table using those columns
// ->Profit!

public class TableviewDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    Stage window;
    // Table view musi miec co najmniej 1 kolumne
    TableView<ProductDataBase> table;
    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Table View");

                //Name column
                TableColumn<ProductDataBase, String> nameColumn = new TableColumn<>("Name");
                nameColumn.setMinWidth(200);
                //!!!!! use name property of object
                nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

                //Price column
                TableColumn<ProductDataBase, Double> priceColumn = new TableColumn<>("Price");
                priceColumn.setMinWidth(100);
                //!!!!! use price property of object <- must be adequate to field name
                priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

                //Quantity column
                TableColumn<ProductDataBase, Integer> quantityColumn = new TableColumn<>("Quantity");
                quantityColumn.setMinWidth(100);
                //!!!!! use name property of object
                quantityColumn.setCellValueFactory(new PropertyValueFactory<>("Quantity"));

                //Make Table, set items from DB, add columns
        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);




        VBox vbox = new VBox();
        vbox.getChildren().addAll(table);
        Scene scene = new Scene(vbox,400,400);
        window.setScene(scene);
        window.show();
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
