package hu.alkfejl;

import hu.alkfejl.view.JegyzoKonyvFelvitel;
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
        stage.setTitle("Jegyzőkönyv");
        VBox root = new VBox();
        MenuBar menu = new MenuBar();
        Menu menupont = new Menu("Jegyzőkönyv");
        menu.getMenus().addAll(menupont);

        MenuItem felvitel = new MenuItem("Felvitel");
        MenuItem segitseg = new MenuItem("Segítség");
        menupont.getItems().addAll(felvitel, segitseg);

        root.getChildren().addAll(menu);

        felvitel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JegyzoKonyvFelvitel jkf = new JegyzoKonyvFelvitel();
            }
        });
        Scene sc = new Scene(root, 350, 90);
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}