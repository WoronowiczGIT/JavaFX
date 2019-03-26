package com.company;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import  javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;



public class PopUpWindows extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Stage window;
    Scene scena1;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        // odwolanie do klasy AlertBox metoda, display
        Button butOne = new Button("odpal errora");
        butOne.setOnAction(e -> AlertBox.display("title of", "wow error"));

        // odwolanie do klasy ConfirmBox metoda, display
        Button butTwo = new Button("Tak czy Nie");
        butTwo.setOnAction(e -> {
            ConfirmationBox.display("yes or no", "do you?");
            System.out.println(ConfirmationBox.answear);
         });

        // Tworz layout
       VBox layout = new VBox(25);
        layout.getChildren().addAll(butOne,butTwo);
        layout.setAlignment(Pos.CENTER);


        // Tworzymy Scene wedle zadanych layoutow i parametrow
        scena1 = new Scene(layout, 300, 300);

        //Scena domyślna
        window.setScene(scena1);
        window.setTitle("wywolaj error");
        // inicjalizacja
        window.show();

    }
}
