package hu.alkfejl.view;

import hu.alkfejl.model.Utazas;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class UtazasLista extends Stage {
    public UtazasLista(List<Utazas> lista){
        TableView<Utazas> root = new TableView<>();

        TableColumn<Utazas, String> nameColumn = new TableColumn<>("Név");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nev"));

        TableColumn<Utazas, String> uticelColumn = new TableColumn<>("Uticél");
        uticelColumn.setCellValueFactory(new PropertyValueFactory<>("uticel"));

        TableColumn<Utazas, Boolean> felpanzColumn = new TableColumn<>("Félpanzió");
        felpanzColumn.setCellFactory( CheckBoxTableCell.forTableColumn(felpanzColumn) );
        felpanzColumn.setCellValueFactory(cellData -> {
            Utazas item = cellData.getValue();
            return new SimpleBooleanProperty(item.getFelpanzio());
        });

        TableColumn<Utazas, Integer> ejszakakszamaColumn = new TableColumn<>("Éjszakák");
        ejszakakszamaColumn.setCellValueFactory(new PropertyValueFactory<>("ejszaka"));

        root.setRowFactory( tv -> {
            var row = new TableRow<Utazas>();
            row.setOnMouseClicked( click -> {
                var utazas = row.getItem();
                Dialog<Void> dialog = new Dialog<>();
                dialog.setTitle("Leírás - " + utazas.getNev());
                VBox root2 = new VBox(new Text(utazas.getLeiras()));
                dialog.getDialogPane().setContent(root2);
                dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                dialog.showAndWait();
            });
            return row;
        });

        root.getColumns().addAll(nameColumn, uticelColumn, felpanzColumn, ejszakakszamaColumn);

        root.setItems(FXCollections.observableArrayList(lista));

        Scene scene = new Scene(root);
        setScene(scene);
        show();
    }
}
