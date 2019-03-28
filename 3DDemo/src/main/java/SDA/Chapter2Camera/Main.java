package SDA.Chapter2Camera;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;



public class Main extends Application {

    private  static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static void main(String[] args) { launch(args);}
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;

        Sphere sp = new Sphere(75);
        Sphere sp2 = new Sphere(200);
            sp2.translateXProperty().set(300);
            sp2.translateYProperty().set(300);
            sp2.translateZProperty().set(300);

        //fixed eye setes initial coordinates at 0,0,0
        Camera camera = new PerspectiveCamera(true);
            //camera by default is directed onward Z axis
            camera.translateXProperty().set(0);
            camera.translateYProperty().set(0);
            camera.translateZProperty().set(-1500);

        //setting camera clips declares displayed range
            camera.setNearClip(1);
            camera.setFarClip(2000);

        Group group = new Group();
            group.getChildren().add(sp);
            group.getChildren().add(sp2);

        Scene scene = new Scene(group, WIDTH, HEIGHT);
            scene.setFill(Color.SILVER);
            scene.setCamera(camera);

            window.addEventHandler(KeyEvent.KEY_PRESSED, event ->{
                switch (event.getCode()){
                    case W:
                        sp.translateZProperty().set(sp.getTranslateZ()+50);
                        break;
                    case S:
                        sp.translateZProperty().set(sp.getTranslateZ()-50);
                        break;
                }

            });
        window.setScene(scene);
            window.show();

    }

}
