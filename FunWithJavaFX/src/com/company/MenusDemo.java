package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenusDemo extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        // New menu
        Menu fileMenu = new Menu("File");

//###############################################################

        // Menu Items
        // Plane adding empty dummy objects
        // '...' new window , 'Arrow ->' sub menu
        fileMenu.getItems().add(new MenuItem("New Projekt..."));
        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        // poziome kreski miedzy sekcjami
            fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Setting..."));
            fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit"));
        // Using lambdas to pin an action to a field
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e -> System.out.println("create new"));
        fileMenu.getItems().add(newFile);

//#############################################################

        //Edit menu ### '_' underline apply shortcuts
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("cut"));
        //ADD functionality to paste Item
        MenuItem paste = new MenuItem("Disabled paste");
        editMenu.getItems().add(paste);
        paste.setOnAction(e -> System.out.println("paste paste paste"));
        //Disable paste Item
        paste.setDisable(true);
        editMenu.getItems().add(new MenuItem("copy"));
        editMenu.getItems().add(new MenuItem("paste"));
        editMenu.getItems().add(new MenuItem("change"));

//################################################################
        // Help menu CheckBox on/of etc.
        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLines = new CheckMenuItem("show line numbers");
        // toggling on and off
        showLines.setOnAction(e->{
            if(showLines.isSelected()){
                System.out.println("line numbers displayed");
            }else{
                System.out.println("Line numbers hidden");
            }
        });
        //Auto toggling
        CheckMenuItem autoSave = new CheckMenuItem("Auto save");
        // toggling on and off
        autoSave.setSelected(true);
        autoSave.setOnAction(e->{
            if(autoSave.isSelected()){
                System.out.println("autosaving ON");
            }else{
                System.out.println("autosaving OFF");
            }
        });
//###########################################################

        //Radio menu Item smth/or smth/ or smth like difficulty lvl
        //Difficulty RadioMenuItems
        Menu difficultyMenu = new Menu("difficulty");

        //Creating Radio items
        RadioMenuItem easy = new RadioMenuItem("easy");
        RadioMenuItem medium = new RadioMenuItem("medium");
        RadioMenuItem hard = new RadioMenuItem("hard");
        //Gruping items in 1 toggle group
        ToggleGroup difficultyToggle = new ToggleGroup();
        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);
        // Need to add items separatly!!!
        difficultyMenu.getItems().addAll(easy,medium,hard);

//############################################################
        //Adding items
        helpMenu.getItems().add(showLines);
        helpMenu.getItems().add(autoSave);

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,editMenu,helpMenu,difficultyMenu);


//#############################################################

        BorderPane layout = new BorderPane();
        layout.getChildren().addAll();
        //set menu bar on top
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 300,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
