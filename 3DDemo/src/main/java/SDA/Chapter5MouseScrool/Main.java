package SDA.Chapter5MouseScrool;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
public class Main extends Application {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);

    public static void main(String[] args) { launch(args); }

    public void initMouseControl(SmartGroup group, Scene scene, Stage stage){
        Rotate xRotate;
        Rotate yRotate;
        group.getTransforms().addAll(
                xRotate = new Rotate(0,Rotate.X_AXIS),
                yRotate = new Rotate(0,Rotate.Y_AXIS)
        );
        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);

        scene.setOnMousePressed(event ->{

            anchorX = event.getSceneX();
            anchorY = event.getSceneY();
            anchorAngleX = angleX.get();
            anchorAngleY = angleY.get();
        });

        scene.setOnMouseDragged(event -> {
            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
            angleY.set(anchorAngleY - (anchorX + event.getSceneX()));
        });

        scene.addEventHandler(ScrollEvent.SCROLL, event -> {
            // most scrolls have ony Y axis!!
            double delta = event.getDeltaY();

            group.translateZProperty().set(group.getTranslateZ()+delta);
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;

        Box box = new Box(100, 20, 75);
        Box box2 = new Box(100, 20, 75);
        box.translateXProperty().set(200);

        Camera camera = new PerspectiveCamera(true);
        camera.translateXProperty().set(0);
        camera.translateYProperty().set(0);
        camera.translateZProperty().set(-1500);

        camera.setNearClip(1);
        camera.setFarClip(2000);

        SmartGroup group = new SmartGroup();
        group.getChildren().add(box);
        group.getChildren().add(box2);

        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);

        //initialize mouse Control
        initMouseControl(group,scene,window);

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
}
