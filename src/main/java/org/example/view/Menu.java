package org.example.view;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.App;

import java.io.IOException;

public class Menu {
    public void feltolt(ActionEvent actionEvent){
        Stage stg = new Stage();
        try{
            Scene sc = new Scene(App.loadFXML("primary"));

        }catch (IOException e){

        }
    }
}
