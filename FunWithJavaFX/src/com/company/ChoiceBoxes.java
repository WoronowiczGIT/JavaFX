package com.company;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ChoiceBoxes  extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    Button button;
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Choice box demo");


        // Choice boxy obsluguja tylko jeden typ danych naraz, np String, int etc
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        GridPane.setConstraints(choiceBox, 0, 0);

        choiceBox.getItems().add("bananans");
        choiceBox.getItems().addAll("beacon", "apples");
        // Default value musi byc rowne wartosci z listy
        choiceBox.setValue("apples");


        button = new Button("order!");
        GridPane.setConstraints(button, 0, 1);
        button.setOnAction(e -> getChoice(choiceBox));



        GridPane panel = new GridPane();
        panel.setPadding(new Insets(10));
        panel.setVgap(10);
        panel.setHgap(10);

        panel.getChildren().addAll(button,choiceBox);

        Scene scene = new Scene(panel, 300, 300);
        window.setScene(scene);
        window.show();

    }

    // Obsluga check drop down listy
    private void getChoice(ChoiceBox<String> choiceBox){
        String messege = "User order: "+choiceBox.getValue();
        System.out.println(messege);
    }

}

