package SDA.Chapter3ObjectRotation;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class Main extends Application {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);
    }
    public class SmartGroup extends Group{
        Rotate r;
        Transform t = new Rotate();

        void rotateByX(int ang){
            r = new Rotate(ang,Rotate.X_AXIS);
            // get current rotation and apply ang
            t = t.createConcatenation(r);
            // clear whatever current transform is
            this.getTransforms().clear();
            // add new transform (old one + applied one)
            this.getTransforms().addAll(t);
        }
        void rotateByY(int ang){
            r = new Rotate(ang,Rotate.Y_AXIS);
            // get current rotation and concatenate angle
            t = t.createConcatenation(r);
            // clear whatever current transform is
            this.getTransforms().clear();
            // add new transform (old one + applied one)
            this.getTransforms().addAll(t);
        }

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;

        Box box = new Box(100, 20, 75);
//        // transform defines the nature of movement, angle and the pivot point
//        Transform transform = new Rotate(65,new Point3D(1,0,0));
//            box.getTransforms().add(transform);


        Camera camera = new PerspectiveCamera(true);
            camera.translateXProperty().set(0);
            camera.translateYProperty().set(0);
            camera.translateZProperty().set(-1500);

            camera.setNearClip(1);
            camera.setFarClip(2000);
            // VERY important, we group our objects in a group that gives us access
            // to all necessary rotations
        SmartGroup group = new SmartGroup();
            group.getChildren().add(box);

        Scene scene = new Scene(group, WIDTH, HEIGHT);
            scene.setFill(Color.SILVER);
            scene.setCamera(camera);

        window.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case W:
                    group.translateZProperty().set(group.getTranslateZ() + 50);
                    break;
                case S:
                    group.translateZProperty().set(group.getTranslateZ() - 50);
                    break;
                case Q:
                    group.rotateByX(10);
                    break;
                case E:
                    group.rotateByX(-10);
                    break;
                case A:
                    group.rotateByY(10);
                    break;
                case Z:
                    group.rotateByY(-10);
                    break;
            }

        });

        window.setScene(scene);
        window.show();

    }
}
