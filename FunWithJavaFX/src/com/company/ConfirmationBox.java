package com.company;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import  javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class ConfirmationBox {
    static boolean answear;

    public static boolean display(String title, String message) {
        // nowa ramka do alert boxa
        Stage okienko = new Stage();

        // wymusza kontakt z tym okienkiem!
        okienko.initModality(Modality.APPLICATION_MODAL);
        okienko.setTitle(title);
        okienko.setMinWidth(250);

        Label opis = new Label();
        opis.setText(message);

        // tworzymy guziki TAK / NIE
        Button yesButton = new Button("TAK");
        Button noButton = new Button("NIE");
        // guzik modyfikuje answer i zamyka okno
        noButton.setOnAction(e ->
        {
            answear = false;
            okienko.close();
        });
        yesButton.setOnAction(e ->
        {
            answear = true;
            okienko.close();

        });


        // tworzymy layout
        VBox layout = new VBox(10);
        // dodajemy do niego obiekty i ich lokalizacje
        layout.getChildren().addAll(opis, yesButton,noButton);
        layout.setAlignment(Pos.CENTER);
        // tworzy scene na podstawie  layoutu
        Scene scene = new Scene(layout, 150, 150);
        // ładuje scene do okienka
        okienko.setScene(scene);
        // wymusza zamkniecie albo akcje przy pokazaniu
        okienko.showAndWait();

        return  answear;
    }
}
