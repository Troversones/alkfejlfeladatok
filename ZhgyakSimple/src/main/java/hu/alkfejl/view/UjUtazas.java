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

public class UjUtazas extends Stage {
    public UjUtazas() {
        GridPane pane = new GridPane();
        pane.setVgap(10);
        pane.setHgap(30);
        pane.setPadding(new Insets(10,10,10,10));

        //<editor-fold desc="First Column">
        Text name = new Text("Név: ");
        Text uticel = new Text("Úticél: ");
        Text felpanzio = new Text("Félpanzio: ");
        Text vendegek = new Text("Vendégek száma: ");
        Text ejszaka = new Text("Ejszakák száma: ");
        Text leiras = new Text("Leiras: ");

        pane.addColumn(0, name, uticel, felpanzio, vendegek, ejszaka, leiras);
        //</editor-fold>

        //<editor-fold desc="Second Column">
        TextField nameField = new TextField();
        ObservableList<String> celok = FXCollections.observableArrayList("Budapest", "Párizs", "London");

        ComboBox<String> uticelCombo = new ComboBox<>();
        uticelCombo.setItems(celok);

        CheckBox felp = new CheckBox();

        Spinner<Integer> vendegek_spinner = new Spinner<Integer>(1,12,2);
        vendegek_spinner.setEditable(true);

        Spinner<Integer> ejszaka_spinner = new Spinner<Integer>(2,30,2);
        ejszaka_spinner.setEditable(true);

        TextArea ta = new TextArea();

        Button save = new Button("Save");

        pane.addColumn(1, nameField, uticelCombo, felp, vendegek_spinner, ejszaka_spinner, ta, save);
        //</editor-fold>

        //<editor-fold desc="Button function">
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (nameField.getText().isEmpty() || ta.getText().isEmpty() || uticelCombo.getValue() == null) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Hiányzó adatok");
                    alert.setHeaderText("Hiányzó adatok");
                    alert.setContentText("Hiányzó adatok");

                    alert.showAndWait();
                }else{
                    Utazas uj = new Utazas(nameField.getText(), uticel.getText(), felp.isSelected(), vendegek_spinner.getValue(), ejszaka_spinner.getValue(), ta.getText());

                    UtazasController.getInstance().add(uj);
                }
            }
        });
        //</editor-fold>

        Scene scene = new Scene(pane);
        this.setScene(scene);
        show();
    }
}
