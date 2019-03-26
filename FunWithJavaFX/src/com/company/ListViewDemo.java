package com.company;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class ListViewDemo  extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Button button;
    Stage window;
    ListView<String> listView = new ListView<>();
    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("List view demo");




        GridPane.setConstraints(listView, 0, 0);

        listView.getItems().addAll("matrix", "pirates", "green mile");
        // model selekcji - > wiele na raz
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        button = new Button("Submit");
        GridPane.setConstraints(button, 0, 1);
        button.setOnAction(e -> buttonClicked());


        GridPane panel = new GridPane();
        panel.setPadding(new Insets(10));
        panel.setVgap(10);
        panel.setHgap(10);

        panel.getChildren().addAll(button, listView);

        Scene scene = new Scene(panel, 300, 300);
        window.setScene(scene);
        window.show();

    }

    // Obsluga przyciska
    private void buttonClicked() {
      String msg ="";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();

        for (String m: movies
             ) {
            msg += m+" / ";
        }
        System.out.println(msg);

    }
}