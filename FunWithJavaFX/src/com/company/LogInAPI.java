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

public class LogInAPI extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    Button button;
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("ekran logowania");

        TextField pasInput = new TextField();
        pasInput.setPromptText("type age");
        GridPane.setConstraints(pasInput, 0, 0);

        button = new Button("print age");
        GridPane.setConstraints(button, 0, 1);

        //Get data by click
        button.setOnAction(e -> checkForInt(pasInput.getText(), pasInput));
        //Validate data



        GridPane panel = new GridPane();
        panel.setPadding(new Insets(10));
        panel.setVgap(10);
        panel.setHgap(10);

        panel.getChildren().addAll(button, pasInput);

        Scene scene = new Scene(panel, 300, 300);
        window.setScene(scene);
        window.show();

    }
    // przkazujemy tekst i wartość
    private  boolean checkForInt(String givenTekst, TextField input){
        try{
            // obie metody poprawne
            int age = Integer.parseInt(givenTekst);
                age = Integer.parseInt(input.getText());
            System.out.println("user is: " + age);
            return true;
        }catch(NumberFormatException e){
            System.out.println("error: "+ givenTekst+" is NAN");
            return  false;
        }

    }
}

