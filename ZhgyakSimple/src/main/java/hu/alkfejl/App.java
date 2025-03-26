package hu.alkfejl;

import hu.alkfejl.view.UjUtazas;
import hu.alkfejl.view.UtazasKereses;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox();
        MenuBar menuBar = new MenuBar();
        Menu m1 = new Menu("Utazas");
        Menu m2 = new Menu("Latnivalok");
        menuBar.getMenus().addAll(m1, m2);

        MenuItem mi1 = new MenuItem("Új utazás");
        mi1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                UjUtazas uj = new UjUtazas();
            }
        });

        MenuItem mi2 = new MenuItem("Utazás keresése");
        mi2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                UtazasKereses uj = new UtazasKereses();
            }
        });
        m1.getItems().addAll(mi1, mi2);

        vbox.getChildren().add(menuBar);

        var scene = new Scene(vbox, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}