package sample.Rotate;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

public class Rotate extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 600);

        Rectangle rec1 = new Rectangle(0, 0, 600, 1);
        rec1.setFill(Color.OLIVE);
        Rectangle rec2 = new Rectangle(0, 599, 600, 1);
        rec1.setFill(Color.BROWN);

        ScaleTransition rec1Trans = new ScaleTransition(Duration.seconds(1), rec1);
        rec1Trans.setToY(600);
        rec1Trans.setCycleCount(1);
        rec1Trans.play();

        ScaleTransition rec2Trans = new ScaleTransition(Duration.seconds(1),rec2);
        rec2Trans.setToY(-600);
        rec2Trans.setCycleCount(1);
        rec2Trans.play();

        Button btn = new Button("Rotating");
        btn.setLayoutX(-70);
        btn.setLayoutY(300);

        TranslateTransition btnTrans = new TranslateTransition(Duration.seconds(3),btn);
        btnTrans.setToX(335);
        btnTrans.setCycleCount(1);
        btnTrans.play();

        RotateTransition btnRotate = new RotateTransition(Duration.seconds(2),btn);
        btnRotate.setByAngle(360);
        // total rotation time - > neglected when rate*cycle count is greater
        btnRotate.setDelay(Duration.seconds(1));
        // velocity
        btnRotate.setRate(3);
        // number of spins
        btnRotate.setCycleCount(10);
        btnRotate.play();

        root.getChildren().addAll(rec1, rec2,btn);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Transition");
        primaryStage.show();
    }
}
