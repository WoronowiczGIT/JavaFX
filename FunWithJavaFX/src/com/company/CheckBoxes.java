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
import javafx.scene.control.CheckBox;




    public class CheckBoxes  extends Application{
        public static void main(String[] args) {
            launch(args);
        }

        Button button;
        Stage window;

        @Override
        public void start(Stage primaryStage) throws Exception {

            window = primaryStage;
            window.setTitle("ekran logowania");

            TextField tekstInput = new TextField();
            tekstInput.setPromptText("type age");
            GridPane.setConstraints(tekstInput, 0, 0);



            //Checkboxes + kordynaty na gridzie
            CheckBox box1 = new CheckBox("tuna");
            GridPane.setConstraints(box1, 1, 0);

            CheckBox box2 = new CheckBox("bacon");
            GridPane.setConstraints(box2, 1, 1);

            CheckBox box3 = new CheckBox("eggs");
            GridPane.setConstraints(box3, 1, 2);


            button = new Button("order!");
            GridPane.setConstraints(button, 0, 1);
            button.setOnAction(e -> handleOptiobs(box1,box2));



            GridPane panel = new GridPane();
            panel.setPadding(new Insets(10));
            panel.setVgap(10);
            panel.setHgap(10);

            panel.getChildren().addAll(button, tekstInput,box1,box2,box3);

            Scene scene = new Scene(panel, 300, 300);
            window.setScene(scene);
            window.show();

        }

        // Obsluga check boxow
        private void handleOptiobs(CheckBox box1, CheckBox box2){
            String messege= "User order: ";
            if(box1.isSelected()){
                messege+=" tuna";
            }
            if(box2.isSelected()){
                messege+=" bacon";
            }
            System.out.println(messege);

        }

        }

