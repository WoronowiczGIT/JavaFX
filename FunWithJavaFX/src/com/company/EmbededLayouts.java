package com.company;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.control.Button;

public class EmbededLayouts extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("window title");

        HBox topMenu = new HBox(10);
        Button buttonA = new Button("file");
        Button buttonB = new Button("view");
        Button buttonC = new Button("edit");

        topMenu.getChildren().addAll(buttonC,buttonB,buttonA);

        VBox leftMenu = new VBox(10);
        Button button1 = new Button("first field");
        Button button2 = new Button("second field");
        Button button3 = new Button("third field");

        leftMenu.getChildren().addAll(button1,button3,button2);


        BorderPane embededLayout = new BorderPane();
        embededLayout.setTop(topMenu);
        embededLayout.setLeft(leftMenu);
        // odleglosci pomiedzy panelami
        embededLayout.setMargin(topMenu,new Insets(10));


        Scene scene = new Scene(embededLayout,200,200);

        window.setScene(scene);
        window.show();


    }
}
