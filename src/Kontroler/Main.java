package Kontroler;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Baza baza = new Baza();
        ControllerView controllerView = new ControllerView(primaryStage, baza);


    }


    public static void main(String[] args) {

        launch(args);
    }
}
