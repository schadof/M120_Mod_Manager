package sample;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by 11mmuellerde on 10.05.2017.
 */
public class ModScreen {

    private FlowPane flow;
    private GridPane grid;
    private Pane pane;
    static private String folderPath;

    private ScrollPane scroll;
    static private CheckBox[] checkBox;

    public ModScreen(String game, int lenght, int hight, String modFolder){

        this.folderPath = new String(modFolder+"/" +game);
        this.scroll = new ScrollPane();
        this.flow = new FlowPane(Orientation.HORIZONTAL, (lenght *0.8 ), hight);
        this.grid = new GridPane();
        this.pane = new Pane();


    }
     public static void  createLayout(){

        File folder = new File(folderPath);
        File[] fileList = folder.listFiles();
        ArrayList<String> fileNames = new ArrayList<String>();

        for (File file : fileList) {
            if (file.isFile()) {
                fileNames.add(file.getName());
                System.out.println(file.getName());
            }
        }
        checkBox = new CheckBox[fileNames.size()];
        for(int i = 0; i < fileNames.size(); i++){

            checkBox[i] = new CheckBox();
            checkBox[i].setText(fileNames.get(i));
            System.out.print(fileNames.get(i));

        }


    }
    public static void main(String[] args) {
        folderPath = new String("C:/Users/11mmuellerde/Documents/DevC++");
        createLayout();
    }
}
