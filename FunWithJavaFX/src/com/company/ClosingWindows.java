package com.company;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import  javafx.scene.control.Button;

import javafx.event.ActionEvent;

public class ClosingWindows extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    Button button = new Button("save and quit");

    Stage myWindow;

    @Override
    public void start(Stage primaryStage) throws Exception {
        myWindow = primaryStage;


        // zapis nawet po wcisnieciu krzyzyka
        myWindow.setOnCloseRequest(e -> {
            // konsumuje event, przerywa close request i pozwala nam dokonczyc
            e.consume();
            //odpala metode closing
            closing();}
            );

        StackPane layout = new StackPane();
        // guzik zapisze i zamknie
        button.setOnAction(e -> closing());

        //odpalanie okna
        layout.getChildren().add(button);
        Scene scene1 = new Scene(layout,200,200);
        myWindow.setScene(scene1);
        myWindow.show();
    }
    // metoda odpowiedzialna za zamykanie
    public void closing() {
        Boolean answer = ConfirmationBox.display("tajtel", "want to exit?");
        if (answer) {
            System.out.println("saving");
            myWindow.close();
        }
    }
}
