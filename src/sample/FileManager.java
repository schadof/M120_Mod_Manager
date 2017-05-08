package sample;

import javax.swing.*;
import java.io.File;

public class FileManager {

    public static File path = new java.io.File("~/.steam/steam/steamapps/common/The Binding of Isaac Rebirth");

    public File filechooser(){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(path);
        chooser.setDialogTitle("Choose Folder");
        chooser.setFileHidingEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        } else {
            System.out.println("No Selection ");
        }
        return path;
    }
}
