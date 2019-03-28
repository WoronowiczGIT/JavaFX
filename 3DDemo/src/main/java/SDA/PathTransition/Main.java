package SDA.PathTransition;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Main extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage myWindow = primaryStage;



        Sphere sphere = new Sphere(50);




        Group group = new Group();
            group.getChildren().add(sphere);

        Scene scene = new Scene(group,500,500);
            scene.setOnMouseMoved(event -> {
                int x = MouseInfo.getPointerInfo().getLocation().x;
                int y = MouseInfo.getPointerInfo().getLocation().y;
                String text = "x "+x+" y "+y;
                myWindow.setTitle(text);
            });
        myWindow.setScene(scene);
        myWindow.show();





    }

}
