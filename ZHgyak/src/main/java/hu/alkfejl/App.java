package hu.alkfejl;

import hu.alkfejl.model.JegyzoKonyv;
import hu.alkfejl.view.JegyzoKonyvFelvitel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {
    public static List<JegyzoKonyv> jegyzoKonyvek = new ArrayList<>();
    public TableView<JegyzoKonyv> dataListing = new TableView<>();
    public static void setJegyzoKonyvek(JegyzoKonyv list) {
        jegyzoKonyvek.add(list);
    }

    public static ObservableList<JegyzoKonyv> getJegyzokonyvek(){
        return FXCollections.observableArrayList(jegyzoKonyvek);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Jegyzőkönyv");
        VBox root = new VBox();
        stage.setMinHeight(500);
        stage.setMinWidth(250);
        MenuBar menu = new MenuBar();
        Menu menupont = new Menu("Jegyzőkönyv");
        menu.getMenus().addAll(menupont);

        MenuItem felvitel = new MenuItem("Felvitel");
        MenuItem segitseg = new MenuItem("Segítség");
        menupont.getItems().addAll(felvitel, segitseg);

        Button refreshBTN = new Button("Frissit");

        TableColumn<JegyzoKonyv, String> cimColumn = new TableColumn<>("Cím: ");
        cimColumn.setCellValueFactory(new PropertyValueFactory<>("cim"));

        TableColumn<JegyzoKonyv, String> datumColumn = new TableColumn<>("Dátum: ");
        datumColumn.setCellValueFactory(new PropertyValueFactory<>("datum"));

        dataListing.getColumns().addAll(cimColumn, datumColumn);

        root.getChildren().addAll(menu, refreshBTN, dataListing);

        dataListing.setRowFactory( tv -> {
            var row = new TableRow<JegyzoKonyv>();
            row.setOnMouseClicked( click -> {
                var jegyzokonyv = row.getItem(); // elkérhető a sorban tárolt objektum
                Dialog<Void> dialog = new Dialog<>();
                dialog.setTitle("Cim: - " + jegyzokonyv.getCim());
                VBox dialogroot = new VBox(new Text("Részletesebb leiras: " + jegyzokonyv.getLeiras()));
                dialog.getDialogPane().setContent(dialogroot);
                dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                dialog.showAndWait();
            });
            return row;
        });

        felvitel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JegyzoKonyvFelvitel jkf = new JegyzoKonyvFelvitel();
            }
        });

        segitseg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Adattagok leirasa");
                alert.setHeaderText("Az adattagok és jelentésük:");
                alert.setContentText("Cim: a Jegyzokonyv cime" +
                        "\r" +
                        "Datum: a jegyzokonyv létrehozasanak datuma" +
                        "\r" +
                        "Jegyző: az adott jegyzokonyv szerzője" +
                        "\r" +
                        "Leírás: az adott jegyzokonyv leirasa"
                );

                alert.showAndWait();
            }
        });

        refreshBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                refresh();
            }
        });
        Scene sc = new Scene(root, 350, 90);
        stage.setScene(sc);
        stage.show();
    }

    public void refresh(){
        dataListing.setItems(getJegyzokonyvek());
    }

    public static void main(String[] args) {
        launch();
    }

}