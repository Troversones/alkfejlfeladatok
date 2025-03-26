package hu.alkfejl.view;

import hu.alkfejl.controller.UtazasController;
import hu.alkfejl.model.Utazas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class UtazasKereses extends Stage {
    public UtazasKereses() {
        GridPane pane = new GridPane();
        pane.setVgap(10);
        pane.setHgap(30);
        pane.setPadding(new Insets(10,10,10,10));

        //<editor-fold desc="First Column">
        Text uticel = new Text("Úticél: ");
        Text vendegek = new Text("Vendégek száma: ");
        Text ejszaka = new Text("Ejszakák száma: ");

        pane.addColumn(0, uticel , vendegek, ejszaka);
        //</editor-fold>

        //<editor-fold desc="Second Column">
        ObservableList<String> celok = FXCollections.observableArrayList("Budapest", "Párizs", "London");

        ComboBox<String> uticelCombo = new ComboBox<>();
        uticelCombo.setItems(celok);

        Spinner<Integer> vendegek_spinner = new Spinner<Integer>(0,12,0);
        vendegek_spinner.setEditable(true);

        Spinner<Integer> ejszaka_spinner = new Spinner<Integer>(0,30,0);
        ejszaka_spinner.setEditable(true);

        Button save = new Button("Keres");

        pane.addColumn(1, uticelCombo, vendegek_spinner, ejszaka_spinner, save);
        //</editor-fold>

        //<editor-fold desc="Button function">
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Utazas u = new Utazas();
                u.setUticel(uticelCombo.getValue());
                u.setEjszaka(vendegek_spinner.getValue());
                u.setEjszaka(ejszaka_spinner.getValue());

                List<Utazas> listaxd = UtazasController.getInstance().find(u);
                System.out.println(listaxd.size());
                UtazasLista ul = new UtazasLista(listaxd);
            }
        });
        //</editor-fold>

        Scene scene = new Scene(pane);
        this.setScene(scene);
        show();
    }
}
