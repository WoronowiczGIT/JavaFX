package sample.PathTransition;

import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransitionDemo extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root,500,500);

        Circle circ = new Circle(50, Color.RED);
        circ.setCenterX(300);
        circ.setCenterY(300);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.seconds(5));
        pt.setCycleCount(6);
        pt.setRate(1);
        pt.setAutoReverse(false);
        pt.setNode(circ);
        pt.setPath(circ);
        pt.play();

        root.getChildren().addAll(circ);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
