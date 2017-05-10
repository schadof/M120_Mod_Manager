package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Settings {
    public void settings(){
        Stage stage = new Stage();
        Scene scene = new Scene(new VBox());
        GridPane gridPane = new GridPane();
        Label label = new Label("Change Background color:");
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll(
                "White",
                "Black",
                "Blue",
                "Red"

        );
        Button button = new Button("Set");

        button.setOnAction(actionEvent -> {

            stage.close();

        });

        comboBox.setPrefWidth(175);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(0, 10, 10, 0));
        gridPane.add(label,1,1);
        gridPane.add(comboBox,1,2);
        gridPane.add(button,2,2);

        ((VBox) scene.getRoot()).getChildren().addAll(gridPane);
        scene.getRoot().setStyle("-fx-background-color: BLACK;");
        stage.setTitle("Mod Manager");
        stage.setScene(scene);
        stage.show();
    }

}
