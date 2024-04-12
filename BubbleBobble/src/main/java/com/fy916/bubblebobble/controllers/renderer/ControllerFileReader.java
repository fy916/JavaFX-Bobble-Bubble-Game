package com.fy916.bubblebobble.controllers.renderer;

import com.fy916.bubblebobble.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Control;

import java.io.IOException;

/**
 * The ControllerFileReader facilitates the fetch of FXML and css File.<br/>
 * Demonstrates the FACADE and FACTORY Design Pattern. 
 * @author fy916
 * @version 1.0
 */
public class ControllerFileReader {

    /**
     * Load the FXML file from "UI_files" folder
     * @param loader The FXML loader provided
     * @param fileName The name of the file to be fetched, in {@link String} format
     * @return the Parent that loads the fxml file
     * @author fy916
     */
    public static Parent loadFXML(FXMLLoader loader, String fileName) throws IOException {
        Parent root = loader.load(Main.class.getResource("UI_files/"+fileName+".fxml").openStream());
        return root;
    }

    /**
     * Load the CSS file from "UI_files" folder
     * @param control The {@link Control} of javaFX {@link javafx.scene.Scene} that to be loaded
     * @param fileName The name of the file to be fetched, in {@link String} format
     * @author fy916
     */
     public static void loadCSS (Control control, String fileName){
        control.getStylesheets().add(Main.class.getResource("UI_files/"+fileName+".css").toExternalForm());
    }
}
