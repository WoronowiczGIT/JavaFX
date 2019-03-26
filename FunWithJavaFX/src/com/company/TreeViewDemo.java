package com.company;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class TreeViewDemo  extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Button button;
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Tree view demo");
        // last branch = leaf

        TreeView<String> myTree = new TreeView<>();
        GridPane.setConstraints(myTree, 0, 0);
        // declaring root
        TreeItem<String> root, tomek, kasia;
        root = new TreeItem<>();
        // ładuje wszystko rozwiniete
        root.setExpanded(true);

        //declaring branches
        // metode makeBranch musimy napisać sami
        // metoda pobiera title i parent
        tomek = makeBranch("Tomek", root);
        makeBranch("tanks", tomek);
        makeBranch("ships", tomek);
        makeBranch("planes", tomek);

        kasia = makeBranch("Kasia", root);
        makeBranch("dyskoteki", kasia);
        makeBranch("chlopaki", kasia);
        makeBranch("takie takie", kasia);

        //Tworzymy drzewo!!!!
        myTree = new TreeView<>(root);
        // chowa roota, wiec widoczne sa tylko rozwiniete galezie
        myTree.setShowRoot(false);

        //Dodajemy action Listenera
        myTree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldVal, newVal)->{
                    if(newVal!=null) System.out.println(newVal.getValue());
                });




        button = new Button("Submit");
        GridPane.setConstraints(button, 0, 1);
        button.setOnAction(e -> System.out.println("beep"));


        GridPane panel = new GridPane();
        panel.setPadding(new Insets(10));
        panel.setVgap(10);
        panel.setHgap(10);

        panel.getChildren().addAll(button, myTree);

        Scene scene = new Scene(panel, 300, 300);
        window.setScene(scene);
        window.show();

    }
// tworzenie branchy
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent){

        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

}