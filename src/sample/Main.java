package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.File;

public class Main extends Application {

    public static File path = new java.io.File("~/.steam/steam/steamapps/common/The Binding of Isaac Rebirth");

    @Override
    public void start(Stage primaryStage) throws Exception{
        FileManager fileManager = new FileManager();
        GridPane gridPane = new GridPane();
        Button button = new Button("BOI Folder");
        TextField textField = new TextField(String.valueOf(path));

        textField.setMinWidth(200);

        button.setOnAction(actionEvent -> {
            path = fileManager.filechooser();
            textField.setText(String.valueOf(path));
        });


        gridPane.add(textField,1,1);
        gridPane.add(button,2,1);

        primaryStage.setTitle("Mod Manager");
        primaryStage.setScene(new Scene(gridPane, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
