package Kontroler;
import Klasy.*;
import com.sun.prism.Image;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.*;
public class Mapa {


    private final Stage mapaSwiata;
    public ControllerView controllerView;
    public Baza baza;

    private BorderPane borderPane;
    private Scene scene;

    public Mapa(Stage mapaSwiata, ControllerView controllerView, Baza baza) {
        this.mapaSwiata = mapaSwiata;
        this.controllerView = controllerView;
        this.baza = baza;
        tworzenieOkna();
    }

    public void tworzenieOkna(){
        BorderPane borderPane = new BorderPane();
        Scene drugaScena = new Scene(borderPane, 900, 600);
        mapaSwiata.setTitle("Mapa Świata");
        mapaSwiata.show();
        mapaSwiata.setScene(drugaScena);
    }



}
