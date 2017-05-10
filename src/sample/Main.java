package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane gridPane = new GridPane();
        Settings settings = new Settings();
        Add add = new Add();
        Scene scene = new Scene(new VBox(), 400, 350);

        MenuBar menuBar = new MenuBar();
        Menu menuGame = new Menu("Game");
        MenuItem add1 = new MenuItem("Add");
        MenuItem remove1 = new MenuItem("Remove");
        MenuItem select1 = new MenuItem("Select");
        add1.setOnAction(t -> {
            add.add();
        });
        remove1.setOnAction(t -> {});
        select1.setOnAction(t -> {});
        menuGame.getItems().addAll(add1,remove1, select1);

        Menu menuSettings = new Menu("Settings");
        MenuItem settings1 = new MenuItem("Settings");
        settings1.setOnAction(t -> {
            settings.settings();
        });
        menuSettings.getItems().addAll(settings1);

        menuBar.getMenus().addAll(menuGame, menuSettings);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(0, 10, 10, 0));

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
