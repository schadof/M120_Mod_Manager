package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    Image addImg = new Image(getClass().getResourceAsStream("images/add.png"));
    Image deleteImg = new Image(getClass().getResourceAsStream("images/delete.png"));
    Image optionsImg = new Image(getClass().getResourceAsStream("images/options.png"));

    Button enable = new Button();
    Button disable = new Button();
    Button add = new Button();
    Button delete = new Button();
    Button options = new Button();



    public SideButtonPane(int applicationHeight){
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

        enable.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("This would enable the selected mod.");
            }
        });

        disable.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("This would disable the the selected mod.");
            }
        });

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("This would add and install the selected mod.");
            }
        });

        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("This would delete and uninstall the selected mod.");
            }
        });

        options.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("This serves as a placeholder for options about the selected mod.");
            }
        });

        this.setVgrow(enable, Priority.ALWAYS);
        this.setVgrow(disable, Priority.ALWAYS);
        this.setVgrow(add, Priority.ALWAYS);
        this.setVgrow(delete, Priority.ALWAYS);
        this.setVgrow(options, Priority.ALWAYS);

        this.setSpacing(10);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setMinHeight(applicationHeight);
        this.setStyle("-fx-background-color: #FFFFFF;");

        this.getChildren().addAll(enable, disable, add, delete, options);
    }
}
