package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class SideButtonPane extends VBox{

    Image enableImg = new Image(getClass().getResourceAsStream("images/enable.png"));
    Image disableImg = new Image(getClass().getResourceAsStream("images/disable.png"));
    Image addImg = new Image(getClass().getResourceAsStream("images/add.png"));
    Image deleteImg = new Image(getClass().getResourceAsStream("images/delete.png"));
    Image optionsImg = new Image(getClass().getResourceAsStream("images/options.png"));

    Button enable = new Button();
    Button disable = new Button();
    Button add = new Button();
    Button delete = new Button();
    Button options = new Button();



    public SideButtonPane(){
        enable.setMaxWidth(Double.MAX_VALUE);
        disable.setMaxWidth(Double.MAX_VALUE);
        add.setMaxWidth(Double.MAX_VALUE);
        delete.setMaxWidth(Double.MAX_VALUE);
        options.setMaxWidth(Double.MAX_VALUE);

        enable.setGraphic(new ImageView(enableImg));
        disable.setGraphic(new ImageView(disableImg));
        add.setGraphic(new ImageView(addImg));
        delete.setGraphic(new ImageView(deleteImg));
        options.setGraphic(new ImageView(optionsImg));

        enable.setOnAction(e -> System.out.println("This would enable the selected mod."));

        disable.setOnAction(e -> System.out.println("This would disable the the selected mod."));

        add.setOnAction(e -> System.out.println("This would add and install the selected mod."));

        delete.setOnAction(e -> System.out.println("This would delete and uninstall the selected mod."));

        options.setOnAction(e -> System.out.println("This serves as a placeholder for options about the selected mod."));

        setVgrow(enable, Priority.ALWAYS);
        setVgrow(disable, Priority.ALWAYS);
        setVgrow(add, Priority.ALWAYS);
        setVgrow(delete, Priority.ALWAYS);
        setVgrow(options, Priority.ALWAYS);

        setSpacing(10);
        setPadding(new Insets(10));
        setStyle("-fx-background-color: #FFFFFF;");

        getChildren().addAll(enable, disable, add, delete, options);
    }
}
