package sample.ParalelSequence;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

public class ParalelSequenceTrans extends Application {
    public static void main(String[] args) { launch(args); }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root,500,500);

        Rectangle rect = new Rectangle(150,150,100,250);
        rect.setFill(Color.BROWN);
        rect.setArcHeight(20);
        rect.setArcWidth(30);


        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2),rect);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.2);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3),rect);
        rotateTransition.setRate(2);
        rotateTransition.setAutoReverse(true);
        rotateTransition.setByAngle(180);
        rotateTransition.setCycleCount(5);

        ScaleTransition sc = new ScaleTransition(Duration.seconds(2),rect);
        sc.setCycleCount(2);
        sc.setAutoReverse(false);
        sc.setToX(2);
        sc.setToY(2);

// Do all together
//        ParallelTransition pt = new ParallelTransition(rect,fadeTransition,rotateTransition);
//        pt.play();
    // Do transitions in sequence
        SequentialTransition sq = new SequentialTransition(rect,sc,rotateTransition,fadeTransition);
        sq.play();
        root.getChildren().addAll(rect);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
