package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane borderPane = new BorderPane();
        Settings settings = new Settings();
        Add add = new Add();
        int appHeight = 300;
        int appWidth = 500;
        Scene scene = new Scene(new VBox(), appWidth, appHeight);
        SideButtonPane sideButtonPane = new SideButtonPane(appHeight);

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

        borderPane.setLeft(sideButtonPane);

        ModScreen modScreen = new ModScreen(appWidth,appHeight,"skyrim");
        modScreen.createLayout();

        borderPane.setCenter(modScreen.getScroll());
        borderPane.setRight(modScreen.getFlow());

        ((VBox) scene.getRoot()).getChildren().addAll(menuBar, borderPane);
        scene.getRoot().setStyle("-fx-background-color: BLACK;");
        primaryStage.setTitle("Mod Manager");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
