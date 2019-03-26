package com.company;
import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import  javafx.scene.control.Button;
import  javafx.scene.control.Label;

public class GridPaneLogIN extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Button button;
    Scene scena1;
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("ekran logowania");

        // GridPane.setConstraints(obiekt, adres kolumny, adres rzedu)
        //panel.setVgap(); -> podaje odleglosci miedzy obiektami w pikselach

        //button
        button = new Button("click");
        GridPane.setConstraints(button, 1, 2);
        button.setOnAction(e -> System.out.println("beep"));
        // labele
        Label nameLabel = new Label("User name: ");
        GridPane.setConstraints(nameLabel, 0, 0);

        Label pasLabel = new Label("Haslo:  ");
        GridPane.setConstraints(pasLabel, 0, 1);

        //pola tekstowe
        TextField userInput = new TextField("Login");
        GridPane.setConstraints(userInput, 1, 0);

        TextField pasInput = new TextField();
        // Ustawia szry tekst który nie jest przechowywany jako zmienna
        pasInput.setPromptText("password");
        GridPane.setConstraints(pasInput, 1, 1);

        GridPane panel = new GridPane();
        //Padding = marginesy, Pamietac ze ustalamy obiektami insets
        panel.setPadding(new Insets(15, 10, 100, 10));
        // odstepy pomiedzy obiektami
        panel.setVgap(10);
        panel.setHgap(25);

        panel.getChildren().addAll(button, nameLabel, pasLabel, userInput, pasInput);

        scena1 = new Scene(panel, 300, 300);
        window.setScene(scena1);
        window.show();

    }
}
