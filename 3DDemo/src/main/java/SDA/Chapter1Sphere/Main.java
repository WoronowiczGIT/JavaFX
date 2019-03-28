package SDA.Chapter1Sphere;

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
        sp.translateXProperty().set(WIDTH/2);
        sp.translateYProperty().set(WIDTH/2);

        Camera camera = new PerspectiveCamera();


        Group group = new Group();
        group.getChildren().add(sp);

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
