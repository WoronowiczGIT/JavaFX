package sample.Transition;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Transition extends Application {
    public static void main(String[] args) { launch(args); }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root,500,500);

        Circle circ = new Circle();
            circ.setRadius(50);
            circ.setFill(Color.RED);
            circ.relocate(100,100);

        TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.seconds(3));
            transition.setToX(300);
            transition.setToY(300);
            transition.setNode(circ);
            transition.play();

        root.getChildren().add(circ);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Transition");
        primaryStage.show();
    }
}
