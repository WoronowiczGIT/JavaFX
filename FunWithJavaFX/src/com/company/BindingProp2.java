package com.company;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BindingProp2 extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    // Dodajemy obiektowość do pól, dzieki czemu mozemy dodawać listenera do nich
    @Override
    public void start(Stage primaryStage) throws Exception {



        TextField usetInput = new TextField("user");
        GridPane.setConstraints(usetInput,1,0);
        usetInput.setMaxWidth(100);

        Label label1 = new Label("welcome to the site");
        GridPane.setConstraints(label1,1,1);
        Label label2 = new Label();
        GridPane.setConstraints(label2,2,1);

        // Binding label values
        label2.textProperty().bind(usetInput.textProperty());





        Button button = new Button("submit");
        GridPane.setConstraints(button,1,3);

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10,10,10,10));
        layout.setVgap(20);
        layout.setHgap(20);
        layout.getChildren().addAll(usetInput,label1,label2,button);
        Scene scene = new Scene(layout,300,300);
        primaryStage.setTitle("Binding Proporties");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
