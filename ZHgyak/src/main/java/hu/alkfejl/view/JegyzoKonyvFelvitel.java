package hu.alkfejl.view;

import hu.alkfejl.controller.JegyzoKonyvController;
import hu.alkfejl.model.JegyzoKonyv;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class JegyzoKonyvFelvitel extends Stage {
    public JegyzoKonyvFelvitel(){
        GridPane pane = new GridPane();
        pane.setVgap(10);
        pane.setHgap(30);
        pane.setPadding(new Insets(10,10,10,10));

        Text cim = new Text("Cim: ");
        Text jegyzo = new Text("Jegyző: ");
        Text datum = new Text("Dátum: ");
        Text leiras = new Text("Leírás: ");

        pane.addColumn(0, cim, leiras, datum, jegyzo);

        TextField cimBevitel = new TextField();
        TextField jegyzoBevitel = new TextField();
        TextField datumBevitel = new TextField();
        TextArea leirasBevitel = new TextArea();

        Button felvitel = new Button("Felvitel");

        felvitel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(cimBevitel.getText().isEmpty() || jegyzoBevitel.getText().isEmpty() || datumBevitel.getText().isEmpty() || leirasBevitel.getText().isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Hiányzó adatok");
                    alert.setHeaderText("Hiányzó adatok");
                    alert.setContentText("Hiányzó adatok");

                    alert.showAndWait();
                }else{
                    JegyzoKonyv ujJK = new JegyzoKonyv();
                    ujJK.setCim(cimBevitel.getText());
                    ujJK.setJegyzo(jegyzoBevitel.getText());
                    ujJK.setDatum(datumBevitel.getText());
                    ujJK.setLeiras(leirasBevitel.getText());

                    JegyzoKonyvController.getInstance().add(ujJK);
                }
            }
        });

        TableView<JegyzoKonyv> asd = new TableView<>();

        pane.addColumn(1,cimBevitel, jegyzoBevitel, datumBevitel, leirasBevitel, felvitel, asd);
        Scene sc = new Scene(pane);
        this.setScene(sc);
        show();
    }
}
