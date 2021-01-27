package Kontroler;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Klasa Main do tworzenia okna mapy i panelu kontrolnego
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Baza baza = new Baza();
        Stage noweOkno = new Stage();
        Mapa mapa = new Mapa(noweOkno, baza);
        ControllerView controllerView = new ControllerView(primaryStage, baza, mapa);

    }


    public static void main(String[] args) {

        launch(args);
    }
}
