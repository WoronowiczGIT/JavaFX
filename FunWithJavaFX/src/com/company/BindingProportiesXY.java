package com.company;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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

public class BindingProportiesXY extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    // Dodajemy obiektowość do pól, dzieki czemu mozemy dodawać listenera do nich
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Tworzymy obiekty typu IntegerProperty
        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();
        // warunkujemy wzajemność
        y.bind(x.multiply(10));

        System.out.println("x: "+ x.getValue());
        System.out.println("y: "+ y.getValue());
        // po zmianie jednej wartości druga zmienia sie automatycznie
        x.setValue(5);

        System.out.println("x: "+ x.getValue());
        System.out.println("y: "+ y.getValue());

        Label label1 = new Label("podaj liczbe");
        GridPane.setConstraints(label1,0,0);
        Label label2 = new Label("twoja liczba");
        GridPane.setConstraints(label2,0,1);

        TextField passwordField = new TextField();
        passwordField.setEditable(false);
        GridPane.setConstraints(passwordField,1,1);

        TextField usetNameField = new TextField("user");
        GridPane.setConstraints(usetNameField,1,0);
        usetNameField.setOnAction(e-> {
            x.setValue(Integer.parseInt(usetNameField.getText()));
            passwordField.setText(usetNameField.getText());
        });


        Button button = new Button("submit");
        GridPane.setConstraints(button,0,2);
        button.setOnAction(e->{
            System.out.println(Integer.parseInt(usetNameField.getText()));
            System.out.println("x: "+ x.getValue());
            System.out.println("y: "+ y.getValue());
        });





        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10,10,10,10));
        layout.setVgap(20);
        layout.setHgap(20);
        layout.getChildren().addAll(usetNameField,passwordField,label1,label2,button);
        Scene scene = new Scene(layout,300,300);
        primaryStage.setTitle("Binding Proporties");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
