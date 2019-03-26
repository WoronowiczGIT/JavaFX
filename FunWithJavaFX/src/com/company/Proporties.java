package com.company;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Proporties extends Application{
    public static void main(String[] args) {
        launch(args);
    }
// Dodajemy obiektowość do pól, dzieki czemu mozemy dodawać listenera do nich
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Dzieki zdefiniowaniu Name zamiast Stringa, jako StringProperty
        // mozemy korzystać z tego pola jak z obiektu
        // (tj, dodac akcje,zamontowac event handlera etc )
        Person bucky = new Person();
        bucky.firstNameProperty().addListener((v,oldVal,newVal) ->{
            System.out.println("name changed to "+ newVal);
            System.out.println("firstNameProperty(): "+ bucky.firstNameProperty());
            System.out.println("getFirstName(); " + bucky.getFirstName());
            System.out.println("name changed from "+ oldVal);


        });



        Label label1 = new Label("user name");
        GridPane.setConstraints(label1,0,0);
        Label label2 = new Label("password");
        GridPane.setConstraints(label2,0,1);

        TextField usetNameField = new TextField("user");
        GridPane.setConstraints(usetNameField,1,0);
        usetNameField.setOnAction(e-> bucky.setFirstName(usetNameField.getText()));

        TextField passwordField = new TextField("pass");
        GridPane.setConstraints(passwordField,1,1);

        Button button = new Button("submit");
        GridPane.setConstraints(button,0,2);
        button.setOnAction(e-> bucky.setFirstName("porky"));





        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10,10,10,10));
        layout.setVgap(20);
        layout.setHgap(20);
        layout.getChildren().addAll(usetNameField,passwordField,label1,label2,button);
        Scene scene = new Scene(layout,300,300);
        primaryStage.setTitle("Proporties");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
