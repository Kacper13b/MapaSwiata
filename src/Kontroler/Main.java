package Kontroler;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Baza baza = new Baza();
        ControllerView controllerView = new ControllerView(primaryStage, baza);
        Stage noweOkno = new Stage();
        Mapa mapa = new Mapa(noweOkno, controllerView, baza);
        //noweOkno.initOwner(primaryStage);
        //noweOkno.show();



    }


    public static void main(String[] args) {

        launch(args);
    }
}
