package sample;

import javafx.scene.control.Button;

public class Controller {

    public Button button;
    public void handleButtonClick(){
        System.out.println("beep bep beep");
        button.setText("stop pushin me");
    }
}
