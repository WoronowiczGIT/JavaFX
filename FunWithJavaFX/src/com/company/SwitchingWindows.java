package com.company;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import  javafx.scene.control.Button;
import  javafx.scene.control.Label;

public class SwitchingWindows extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    // definujemy okienko i sceny
    Stage window;
    Scene scena1, scena2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // od teraz okienko to okienko
        window = primaryStage;
        // Tworzymy opisy
        // wymaga javafx.scen.control.Label
        Label label1 = new Label(" metka pierwsza ");
        Label label2 = new Label(" metka druga ");
        // Tworzymy guziki i przypisujemy im akcje lambdami
        // wymaga javafx.scen.control.Button
        Button butOne = new Button("go to window2");
        butOne.setOnAction(e -> window.setScene(scena2));

        Button butTwo = new Button("go to first window");
        butTwo.setOnAction(e -> window.setScene(scena1));

        Button butTree = new Button("any window");
        butTree.setOnAction(e -> window.setScene(scena2));

        // Tworzymy layouty dla poszczegolnych scen i dodajemy do nich obiekty
        VBox layout = new VBox(15);
        layout.getChildren().addAll(label1,butOne, label2, butTree);

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(butTwo);

        // Tworzymy Sceny wedle zadanych layoutow i parametrow
        scena1 = new Scene(layout, 200, 300);
        scena2 = new Scene(layout2, 200, 100);

        //Scena domyślna
        window.setScene(scena1);
        window.setTitle("tytul1");
        // inicjalizacja
        window.show();

    }
}
