package Kontroler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Mapa {


    private final Stage mapaSwiata;
    public ControllerView controllerView;
    public Baza baza;

    private Group root = new Group();
    private ImageView imageViewMapy;
    private ImageView imageViewLotniskaCywilnego;
    private ImageView imageViewLotniskaWojskowego;

    private Scene scene;

    public Mapa(Stage mapaSwiata, ControllerView controllerView, Baza baza) {
        this.mapaSwiata = mapaSwiata;
        this.controllerView = controllerView;
        this.baza = baza;
        tworzenieOkna();
    }

    public void tworzenieOkna(){
        tworzenieObrazu();
        tworzenieObrazuLotniskaCywilnego();
        tworzenieObrazuLotniskaWojskowego();
        StackPane stackPane = new StackPane();
        Scene drugaScena = new Scene(stackPane, 1425, 625);
        mapaSwiata.setTitle("Mapa Świata");
        mapaSwiata.show();
        mapaSwiata.setScene(drugaScena);
        stackPane.getChildren().add(root);
        root.getChildren().add(imageViewMapy);
        root.getChildren().add(imageViewLotniskaCywilnego);
        root.getChildren().add(imageViewLotniskaWojskowego);
    }

    public void tworzenieObrazu(){
        Image obrazMapyImage = new Image("obrazMapy.jpg");
        imageViewMapy = new ImageView(obrazMapyImage);

    }

    public void tworzenieObrazuLotniskaCywilnego(){
        Image obrazLotniskaCywilnegoImage = new Image("airport-building.png");
        imageViewLotniskaCywilnego = new ImageView(obrazLotniskaCywilnegoImage);
        imageViewLotniskaCywilnego.setFitHeight(30);
        imageViewLotniskaCywilnego.setFitWidth(30);
        imageViewLotniskaCywilnego.setX(1200);
        imageViewLotniskaCywilnego.setY(500);
    }

    public void tworzenieObrazuLotniskaWojskowego(){
        Image obrazLotniskaWojskowegoImage = new Image("airForceBase.png");
        imageViewLotniskaWojskowego = new ImageView(obrazLotniskaWojskowegoImage);
        imageViewLotniskaWojskowego.setFitHeight(30);
        imageViewLotniskaWojskowego.setFitWidth(30);
        imageViewLotniskaWojskowego.setX(300);
        imageViewLotniskaWojskowego.setY(500);
    }



}
