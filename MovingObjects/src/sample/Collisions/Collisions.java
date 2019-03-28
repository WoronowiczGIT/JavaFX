package sample.Collisions;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Collisions extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private Rectangle rect1 = new Rectangle(150, 150, 100, 100);
    private Rectangle rect2 = new Rectangle(150, 350, 100, 200);


    private void detectColision(){

        if(rect1.getBoundsInLocal().intersects(rect2.getBoundsInLocal())){
            rect1.setFill(Color.RED);
        }else rect1.setFill(Color.GREEN);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 500);


        rect1.setFill(Color.GREEN);
        rect2.setFill(Color.BLUE);
        // coordinate implies the rec position 0,0 is its left top corner
        System.out.println(rect1.getY()+" "+rect1.getX());

        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case W:
                    rect1.setY(rect1.getY() - 10);
                    System.out.println(rect1.getY()+" "+rect1.getX());
                    detectColision();
                    break;
                case S:
                    rect1.setY(rect1.getY() + 10);
                    System.out.println(rect1.getY()+" "+rect1.getX());
                    detectColision();
                    break;
                case A:
                    rect1.setX(rect1.getX() - 10);
                    System.out.println(rect1.getY()+" "+rect1.getX());
                    detectColision();
                    break;
                case D:
                    rect1.setX(rect1.getX() + 10);
                    System.out.println(rect1.getY()+" "+rect1.getX());
                    detectColision();
                    break;
            }
        });

        Label textField = new Label();
        textField.setLayoutX(50);
        textField.setLayoutY(50);
        textField.setText("tekst");
        root.getChildren().addAll(rect1,rect2);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
