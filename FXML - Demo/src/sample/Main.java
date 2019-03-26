package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // FXML - Html w javie, domyslnie controller i sample
    // sample od bukiego:
//
//    <?xml version="1.0" encoding="UTF-8"?>
//<?import javafx.scene.control.*?>
//<?import javafx.scene.layout.*?>
//
//<VBox prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/8" xmlns:fx="http://javafx.com/fxml"
//    fx:controller="sample.Controller">
//
//    <Label text="I love bacon"/>
//    <Button text="Submit"/>
//
//</VBox>


    @Override public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


}
