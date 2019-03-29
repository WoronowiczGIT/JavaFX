package sample.Collisions;

import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MouseEvents extends Application {
    public static void main(String[] args) { launch(args); }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root,600,600);


        Circle c = new Circle(100);
            c.setCenterX(200);
            c.setCenterY(200);
            c.setFill(Color.RED);

        Circle c2 = new Circle(100);
        c2.setCenterX(300);
        c2.setCenterY(200);
        c2.setFill(Color.BLACK);

          //  c.setOnMouseEntered(event -> c.setFill(Color.GREEN));
          //  c.setOnMouseExited(event -> c.setFill(Color.RED));

        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                c.addEventHandler(MouseEvent.ANY,event -> mouseHandler(c,event) );
            }
        };
        animation.start();

        c2.setOnMouseDragged( event -> {
            c2.setTranslateX(event.getSceneX()-c2.getCenterX());
            c2.setTranslateY(event.getSceneY()-c2.getCenterY());
            System.out.println(event.getSceneX()+" "+c2.getCenterX());
        });

        root.getChildren().addAll(c,c2);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mouseHandler(Shape obj,Event event){

        //System.out.println(event.getEventType().getName());

        if(event.getEventType().equals(MouseEvent.MOUSE_EXITED)){
            obj.setFill(Color.YELLOW);
        }
        if(event.getEventType()==(MouseEvent.MOUSE_ENTERED)){
            System.out.println("exit");
            obj.setFill(Color.BLUE);
        }
        if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
            System.out.println(obj.getTranslateX());
            TranslateTransition tt = new TranslateTransition(Duration.seconds(2),obj);
            double x = obj.getTranslateX();
            tt.setToX(x+100);
            tt.play();
        }


        }

    }
