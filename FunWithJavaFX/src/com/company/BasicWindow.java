package com.company;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import  javafx.scene.control.Button;

import javafx.event.ActionEvent;

public class BasicWindow extends Application implements EventHandler<ActionEvent> {

    // tutaj tylko odpalamy
    public static void main(String[] args) {
        launch(args);
    }
    // Tu tworzymy obiekty

    Button guzik1,guzik2;
    //Tu "montujemy" i odpalamy okna
    @Override
    public void start(Stage primaryStage) throws Exception {

        // guzik 1 sterowany  Interfejsem EventHandler, event jest w metodzie Handler
        guzik1 = new Button("elo guzik 2");
        guzik1.setOnAction(this);
        // guzik 2 wywolywany lambda

        guzik2 = new Button("jestem guzik2");
        guzik2.setOnAction(e -> System.out.println("test guzika lambda"));

        // Tworzymy Layout uzywajac wzoru VBox - StackPane obluguje tylko 1 obiekt na srodku okna
        VBox wzor = new VBox(25);
        wzor.getChildren().add(guzik1);
        wzor.getChildren().add(guzik2);

        //Tworzymy scene wedle ustalonego Layoutu
        Scene okno1 = new Scene(wzor, 200,200);

        //Odpalamy okno
        primaryStage.setTitle("tytul glownej scenu");
        primaryStage.setScene(okno1);
        primaryStage.show();
    }

    // Obsluga ActionEvent
    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==guzik1){
            System.out.println("test guzika z handlerem");
        }
    }
}
