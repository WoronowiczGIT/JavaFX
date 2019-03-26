package com.company;
import javafx.application.Application;
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

public class ThemesSwitchingCSS extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label1 = new Label("user name");
        GridPane.setConstraints(label1,0,0);
        Label label2 = new Label("password");
        GridPane.setConstraints(label2,0,1);

        TextField usetNameField = new TextField("user");
        GridPane.setConstraints(usetNameField,1,0);
        TextField passwordField = new TextField("pass");
        GridPane.setConstraints(passwordField,1,1);
//############################################# Do magic
        Button button = new Button("Modena");
        GridPane.setConstraints(button,0,2);
        button.setOnAction(e-> {
            //Zmienia StyleSheet na modena <sa tylko 2 defaultowe(?)>
            setUserAgentStylesheet(STYLESHEET_MODENA);
            System.out.println("beep");
        });
        Button button2 = new Button("Caspian");
        GridPane.setConstraints(button2,1,2);
        button2.setOnAction(e-> {
            setUserAgentStylesheet(STYLESHEET_CASPIAN);
            System.out.println("beep");
        });
//#############################################
        // need to make custom CSS File
        // Bieda wersja nie supportuje CSS -_-''''



        GridPane layout = new GridPane();

     layout.setPadding(new Insets(10,10,10,10));
     layout.setVgap(20);
     layout.setHgap(20);

        layout.getChildren().addAll(usetNameField,passwordField,label1,label2,button,button2);
     Scene scene = new Scene(layout,300,300);
     // Gdyby css działał to był by tutaj implementowany
     scene.getStylesheets().add("Theme.css");
     primaryStage.setTitle("Layout switcher");
     primaryStage.setScene(scene);
     primaryStage.show();

    }
}
