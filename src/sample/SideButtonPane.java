package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * Created by Gian on 5/10/2017.
 */
public class SideButtonPane extends VBox{

    Image enableImg = new Image(getClass().getResourceAsStream("images/enable.png"));
    Image disableImg = new Image(getClass().getResourceAsStream("images/disable.png"));
    Image deleteImg = new Image(getClass().getResourceAsStream("images/delete.png"));
    Image optionsImg = new Image(getClass().getResourceAsStream("images/options.png"));

    Button enable = new Button();
    Button disable = new Button();
    Button delete = new Button();
    Button options = new Button();



    public SideButtonPane(int applicationHeight){
        enable.setMaxWidth(Double.MAX_VALUE);
        disable.setMaxWidth(Double.MAX_VALUE);
        delete.setMaxWidth(Double.MAX_VALUE);
        options.setMaxWidth(Double.MAX_VALUE);

        enable.setGraphic(new ImageView(enableImg));
        disable.setGraphic(new ImageView(disableImg));
        delete.setGraphic(new ImageView(deleteImg));
        options.setGraphic(new ImageView(optionsImg));

        this.setVgrow(enable, Priority.ALWAYS);
        this.setVgrow(disable, Priority.ALWAYS);
        this.setVgrow(delete, Priority.ALWAYS);
        this.setVgrow(options, Priority.ALWAYS);

        this.setSpacing(10);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setMinHeight(applicationHeight);
        this.setStyle("-fx-background-color: #FFFFFF;");

        this.getChildren().addAll(enable, disable, delete, options);
    }
}
