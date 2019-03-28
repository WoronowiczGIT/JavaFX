package sample.ScaleFillStroke;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ScaleFillStroke extends Application {
    public static void main(String[] args) { launch(args); }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root,500,500);

        Circle circ = new Circle();
        circ.setRadius(50);
        circ.setFill(Color.RED);
        circ.relocate(100,100);
        circ.setStroke(Color.YELLOW);
        circ.setStrokeWidth(5);

        // Linear Movement
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(4));
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setToX(300);
        transition.setToY(300);
        transition.setNode(circ);
        transition.play();
        //Changing ScaleFillStroke
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(3),circ);
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        // set Scaling according to axis
        scaleTransition.setToX(2);
        scaleTransition.setToY(2);
        scaleTransition.play();
        // Changing Color
        FillTransition fillTransition = new FillTransition(Duration.seconds(2),circ,Color.BLACK,Color.DARKGREEN);
        fillTransition.setCycleCount(Animation.INDEFINITE);
        fillTransition.setAutoReverse(true);
        fillTransition.play();
        root.getChildren().add(circ);
        //Stroke Change Object Boarder
        StrokeTransition strokeTransition = new StrokeTransition(Duration.seconds(2),circ,Color.CORAL,Color.BLUE);
        strokeTransition.setCycleCount(Animation.INDEFINITE);
        strokeTransition.setAutoReverse(true);
        strokeTransition.play();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Transition");
        primaryStage.show();
    }
}
