package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;

public class Main extends Application {

    public static File path = new java.io.File("~/.steam/steam/steamapps/common/The Binding of Isaac Rebirth");

    @Override
    public void start(Stage primaryStage) throws Exception{
        FileManager fileManager = new FileManager();
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(new VBox(), 400, 350);
        Button button = new Button("Game Folder");
        TextField textField = new TextField(String.valueOf(path));

        MenuBar menuBar = new MenuBar();
        Menu menuGame = new Menu("Game");
        MenuItem add = new MenuItem("Add");
        MenuItem remove = new MenuItem("Remove");
        MenuItem select = new MenuItem("Select");
        add.setOnAction(t -> {});
        remove.setOnAction(t -> {});
        select.setOnAction(t -> {});

        menuGame.getItems().addAll(add,remove, select);
        Menu menuSettings = new Menu("Settings");

        menuBar.getMenus().addAll(menuGame, menuSettings);

        textField.setMinWidth(200);

        button.setOnAction(actionEvent -> {
            path = fileManager.filechooser();
            textField.setText(String.valueOf(path));
        });


        gridPane.add(textField,1,1);
        gridPane.add(button,2,1);

        ((VBox) scene.getRoot()).getChildren().addAll(menuBar, gridPane);
        scene.getRoot().setStyle("-fx-background-color: BLACK;");
        primaryStage.setTitle("Mod Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
