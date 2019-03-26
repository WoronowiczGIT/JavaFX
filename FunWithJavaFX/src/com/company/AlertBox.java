package com.company;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import  javafx.scene.control.Button;
import  javafx.scene.control.Label;

public class AlertBox {

    public static void display(String title, String message) {
        // nowa ramka do alert boxa
        Stage okienko = new Stage();

        // wymusza kontakt z tym okienkiem!
        okienko.initModality(Modality.APPLICATION_MODAL);
        okienko.setTitle(title);
        okienko.setMinWidth(250);

        Label opis = new Label();
        opis.setText(message);

        // tworzymy guzik
        Button zamykacz = new Button("close this window");
        // akcja zamyka całe okno
        zamykacz.setOnAction(e -> okienko.close());

        // tworzymy layout
        VBox layout = new VBox(10);
            // dodajemy do niego obiekty i ich lokalizacje
            layout.getChildren().addAll(opis, zamykacz);
            layout.setAlignment(Pos.CENTER);

        // tworzy scene na podstawie  layoutu
        Scene scene = new Scene(layout, 150, 150);
        // ładuje scene do okienka
        okienko.setScene(scene);
        // wymusza zamkniecie albo akcje przy pokazaniu
        okienko.showAndWait();
    }
}
