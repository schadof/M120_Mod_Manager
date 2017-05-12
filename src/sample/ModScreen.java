package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
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
    private TextArea details;

    public ModScreen(int windowLength, int windowHeight, String gameName){
        this.gameName = gameName;
        this.mainFolder = System.getProperty("user.home")+"/Documents/mods";
        this.scroll = new ScrollPane();
        this.flow = new FlowPane();
        flow.setMaxWidth(200);
        flow.setMinWidth(200);
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

        details = new TextArea("Here is the Description of the last choosen mod");
         details.setMaxWidth(200);
         details.setMinHeight(260);
         details.setMaxHeight(260);
        flow.getChildren().add(details);
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


                    if(checkBox[i].isSelected()){

                        details.setText(checkBox[i].getText().toString()+" ");

                    }
                    else{
                        details.setText("Here is the Description of the last choosen mod");
                    }

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
