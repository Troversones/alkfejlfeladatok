package hu.alkfejl;

import hu.alkfejl.model.JegyzoKonyv;
import hu.alkfejl.view.JegyzoKonyvFelvitel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {
    public static List<JegyzoKonyv> jegyzoKonyvek;

    public static void setJegyzoKonyvek(JegyzoKonyv list) {
        jegyzoKonyvek.add(list);
    }

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

        TableView<JegyzoKonyv> dataListing = new TableView<>();

        TableColumn<JegyzoKonyv, String> cimColumn = new TableColumn<>("Cím: ");
        cimColumn.setCellValueFactory(new PropertyValueFactory<>("cim"));

        TableColumn<JegyzoKonyv, String> datumColumn = new TableColumn<>("Dátum: ");
        datumColumn.setCellValueFactory(new PropertyValueFactory<>("datum"));

        dataListing.getColumns().addAll(cimColumn, datumColumn);
        root.getChildren().addAll(menu, dataListing);

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