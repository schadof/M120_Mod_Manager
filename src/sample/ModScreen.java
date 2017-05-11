package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.io.File;
import java.util.ArrayList;

public class ModScreen {

    private FlowPane flow;
    private GridPane grid;
    private String mainFolder;
    private String gameName;
    private ScrollPane scroll;
    private CheckBox[] checkBox;
    private Text details;

    public ModScreen(int windowLenght, int windowHight, String gameName){
        this.gameName = gameName;
        this.mainFolder = System.getProperty("user.home")+"/Documents/mods";
        this.scroll = new ScrollPane();
        scroll.setMinWidth( windowLenght *0.5);
        scroll.setMaxWidth( windowLenght *0.5);
        this.flow = new FlowPane();
        flow.setMinWidth( windowLenght *0.36);
        flow.setMaxWidth( windowLenght *0.36);
        this.grid = new GridPane();

    }
     public void createLayout(){

        File modFolder;
        File gameMoFolder ;
        File[] fileList;
        ArrayList<String> fileNames;

         modFolder = new File(mainFolder);

         if (modFolder.mkdir()) {

             System.out.println("Main Mod Folder has been created url: "+ mainFolder);
         }

         gameMoFolder = new File(mainFolder+"/"+gameName);

         if(gameMoFolder.mkdir()){
             System.out.println("Game Folder has been created url; "+mainFolder+"/"+gameName);
         }

        if(gameMoFolder.list().length > 0) {
            fileList = gameMoFolder.listFiles();
            fileNames = new ArrayList<>();

            for (File file : fileList) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                    System.out.println(file.getName());
                }
            }

            checkBox = new CheckBox[fileNames.size()];

            for (int i = 0; i < fileNames.size(); i++) {

                checkBox[i] = new CheckBox(fileNames.get(i));
                checkBox[i].addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
                grid.add(checkBox[i], 1,i);

            }

        }

        details = new Text("Leer");
        flow.getChildren().add(details);
        flow.setVgap(10);
        flow.setStyle("-fx-background-color: #ccc;");
        scroll.setContent(grid);

    }
    private class MyEventHandler implements EventHandler<Event> {
        @Override
        public void handle(Event evt) {

            boolean run = true;
            int i = 0;

            while(run){
                if(checkBox[i].getSkin().equals(((Control) evt.getSource()).getSkin())){

                    System.out.println(((Control) evt.getSource()).getSkin());
                    System.out.println(checkBox[i].getSkin());

                    flow.getChildren().remove(details);

                    if(checkBox[i].isSelected()){

                        details = new Text (checkBox[i].getText().toString()+" ");

                    }
                    else{
                        details = new Text("Leer");
                    }

                    flow.getChildren().add(details);
                    run = false;
                }
                i++;
            }

        }
    }

    public FlowPane getFlow() {
        return flow;
    }

    public ScrollPane getScroll() {
        return scroll;
    }
}
