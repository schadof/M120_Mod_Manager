package sample;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by 11mmuellerde on 10.05.2017.
 */
public class ModScreen {

    private FlowPane flow;
    private GridPane grid;
    private Pane pane;
    private String mainFolder;
    private String gameName;
    private ScrollPane scroll;
    private CheckBox[] checkBox;

    public ModScreen(int windowLenght, int windowHight, String gameName){
        this.gameName = gameName;
        this.mainFolder = new String("C:/Users/"+ new com.sun.security.auth.module.NTSystem().getName()+"/Documents/mods");
        this.scroll = new ScrollPane();
        this.flow = new FlowPane(Orientation.HORIZONTAL, (windowLenght *0.8 ), windowHight);
        this.grid = new GridPane();
        this.pane = new Pane();


    }
     public void  createLayout(){

        File modFolder;
        File gameMoFolder ;
        File[] fileList;
        ArrayList<String> fileNames;

         modFolder = new File(mainFolder);

         if (modFolder.mkdir()) {

             System.out.println("Main Mod Folder has been created");
         }

         gameMoFolder = new File(mainFolder+"/"+gameName);

         if(gameMoFolder.mkdir()){
             System.out.println("Game Folder has been created");
         }

        if(gameMoFolder.list().length > 0) {

            fileList = gameMoFolder.listFiles();
            fileNames = new ArrayList<String>();

            for (File file : fileList) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                    System.out.println(file.getName());
                }
            }

            checkBox = new CheckBox[fileNames.size()];

            for (int i = 0; i < fileNames.size(); i++) {
                checkBox[i] = new CheckBox(fileNames.get(i));
                grid.add(checkBox[i], 1,i);

            }

        }
        flow.getChildren().addAll(grid,pane);
         scroll.setContent(flow);


    }

}
