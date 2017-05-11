package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class Add {
    private static File path = new java.io.File(System.getProperty("user.home"));
    public void add(){
        Stage stage = new Stage();
        Scene scene = new Scene(new VBox());
        GridPane gridPane = new GridPane();
        FileManager fileManager = new FileManager();
        Button button = new Button("Game Folder");
        TextField textField = new TextField(String.valueOf(path));

        button.setOnAction(actionEvent -> {
            fileManager.filechooser();
            stage.close();
        });

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(0, 10, 10, 0));
        gridPane.add(textField,1,1);
        gridPane.add(button,2,1);

        ((VBox) scene.getRoot()).getChildren().addAll(gridPane);
        scene.getRoot().setStyle("-fx-background-color: BLACK;");
        stage.setTitle("Mod Manager");
        stage.setScene(scene);
        stage.show();
    }
}
