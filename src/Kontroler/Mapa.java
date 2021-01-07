package Kontroler;
import Klasy.*;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

import javafx.util.Duration;

import java.util.List;

public class Mapa {


    private final Stage mapaSwiata;
    public Baza baza;

    public Group root = new Group();
    public Group samolotCywilnyGroup = new Group();
    public Group samolotWojskowyGroup = new Group();
    public Group statekCywilnyGroup = new Group();
    public Group lotniskowiecGroup = new Group();

    private ImageView imageViewMapy;
    private ImageView imageViewLotniskaCywilnego;
    private ImageView imageViewLotniskaWojskowego;
    public ImageView imageViewSamolotuCywilnego;
    public ImageView imageViewSamolotuWojskowego;
    public ImageView imageViewStatkuCywilnego;
    public ImageView imageViewLotniskowca;



    private Scene scene;

    public Mapa(Stage mapaSwiata, Baza baza) {
        this.mapaSwiata = mapaSwiata;
        this.baza = baza;
        tworzenieOkna();
    }

    public void tworzenieOkna(){
        tworzenieObrazu();
        StackPane stackPane = new StackPane();
        Scene drugaScena = new Scene(stackPane, 1425, 625);
        mapaSwiata.setTitle("Mapa Świata");
        mapaSwiata.show();
        mapaSwiata.setScene(drugaScena);
        stackPane.getChildren().add(root);
        root.getChildren().add(imageViewMapy);
        root.getChildren().add(samolotCywilnyGroup);
        root.getChildren().add(samolotWojskowyGroup);
        root.getChildren().add(statekCywilnyGroup);
        root.getChildren().add(lotniskowiecGroup);
        tworzenieObrazuLotniskaCywilnego();
        tworzenieObrazuLotniskaWojskowego();
        updatowanieObrazuSamolotuCywilnego();
        updatowanieObrazuSamolotuWojskowego();
        updatowanieObrazuStatkuCywilnego();
        updatowanieObrazuLotniskowca();
    }

    public void tworzenieObrazu(){
        Image obrazMapyImage = new Image("obrazMapy.jpg");
        imageViewMapy = new ImageView(obrazMapyImage);

    }

    public void tworzenieObrazuLotniskaCywilnego(){
        baza.dodajLotniskaCywilne();
        List <LotniskoCywilne> listaLotniskCywilnych = baza.getListaLotniskCywilnych();
        for(LotniskoCywilne lotniskoCywilne : listaLotniskCywilnych){
            Image obrazLotniskaCywilnegoImage = new Image("airport-building.png");
            imageViewLotniskaCywilnego = new ImageView(obrazLotniskaCywilnegoImage);
            int polozenieX = lotniskoCywilne.getPolozenieX();
            int polozenieY = lotniskoCywilne.getPolozenieY();
            imageViewLotniskaCywilnego.setX(polozenieX);
            imageViewLotniskaCywilnego.setY(polozenieY);
            imageViewLotniskaCywilnego.setFitHeight(30);
            imageViewLotniskaCywilnego.setFitWidth(30);
            root.getChildren().add(imageViewLotniskaCywilnego);
        }

    }

    public void tworzenieObrazuLotniskaWojskowego(){
        baza.dodajLotniskaWojskowe();
        List <LotniskoWojskowe> listaLotniskWojskowych = baza.getListaLotniskWojskowch();
        for(LotniskoWojskowe lotniskoWojskowe : listaLotniskWojskowych){
            Image obrazLotniskaWojskowegoImage = new Image("airForceBase.png");
            imageViewLotniskaWojskowego = new ImageView(obrazLotniskaWojskowegoImage);
            int polozenieX = lotniskoWojskowe.getPolozenieX();
            int polozenieY = lotniskoWojskowe.getPolozenieY();
            imageViewLotniskaWojskowego.setFitHeight(30);
            imageViewLotniskaWojskowego.setFitWidth(30);
            imageViewLotniskaWojskowego.setX(polozenieX);
            imageViewLotniskaWojskowego.setY(polozenieY);
            root.getChildren().add(imageViewLotniskaWojskowego);
        }
    }

    public void updatowanieObrazuSamolotuCywilnego(){
        List <SamolotPasazerski> listaSamolotowPaszerskich = baza.getListaSamolotowPasazerskich();
        for(SamolotPasazerski samolotPasazerski : listaSamolotowPaszerskich){
            Image obrazSamolotuCywilnegoImage = new Image("airpane.png");
            imageViewSamolotuCywilnego = new ImageView(obrazSamolotuCywilnegoImage);
            int polozenieX = samolotPasazerski.getAktualnePolozenieX();
            int polozenieY = samolotPasazerski.getAktualnePolozenieY();
            //int polozenieCeluX = samolotPasazerski.getDocelowePolozenieX();
            //int polozenieCeluY = samolotPasazerski.getDocelowePolozenieY();
            imageViewSamolotuCywilnego.setX(polozenieX);
            imageViewSamolotuCywilnego.setY(polozenieY);
            imageViewSamolotuCywilnego.setFitHeight(25);
            imageViewSamolotuCywilnego.setFitWidth(25);
            samolotCywilnyGroup.getChildren().add(imageViewSamolotuCywilnego);
            clickEventObiekt(imageViewSamolotuCywilnego);
            //przenoszenieObiektu(polozenieX, polozenieY, polozenieCeluX, polozenieCeluY, imageViewSamolotuCywilnego);
        }
    }

    public void updatowanieObrazuSamolotuWojskowego(){
        List <SamolotWojskowy> listaSamolotowWojskowych = baza.getListaSamolotowWojskowych();
        for(SamolotWojskowy samolotWojskowy : listaSamolotowWojskowych){
            Image obrazSamolotuWojskowegoImage = new Image("militaryAirplane.png");
            imageViewSamolotuWojskowego = new ImageView(obrazSamolotuWojskowegoImage);
            int polozenieX = samolotWojskowy.getAktualnePolozenieX();
            int polozenieY = samolotWojskowy.getAktualnePolozenieY();
            imageViewSamolotuWojskowego.setX(polozenieX);
            imageViewSamolotuWojskowego.setY(polozenieY);
            imageViewSamolotuWojskowego.setFitHeight(25);
            imageViewSamolotuWojskowego.setFitWidth(25);
            samolotWojskowyGroup.getChildren().add(imageViewSamolotuWojskowego);
            clickEventObiekt(imageViewSamolotuWojskowego);
        }
    }

    public void updatowanieObrazuStatkuCywilnego(){
        List <StatekCywilny> listaStatkowCywilnych = baza.getListaStatkowCywilnych();
        for(StatekCywilny statekCywilny : listaStatkowCywilnych){
            Image obrazStatkuCywilnego = new Image("cruiseShip.png");
            imageViewStatkuCywilnego = new ImageView(obrazStatkuCywilnego);
            int polozenieX = statekCywilny.getAktualnePolozenieX();
            int polozenieY = statekCywilny.getAktualnePolozenieY();
            imageViewStatkuCywilnego.setX(polozenieX);
            imageViewStatkuCywilnego.setY(polozenieY);
            imageViewStatkuCywilnego.setFitHeight(25);
            imageViewStatkuCywilnego.setFitWidth(25);
            statekCywilnyGroup.getChildren().add(imageViewStatkuCywilnego);
            clickEventObiekt(imageViewStatkuCywilnego);

        }
    }

    public void updatowanieObrazuLotniskowca(){
        List <Lotniskowiec> listaLotniskowcow = baza.getListaLotniskowcow();
        for(Lotniskowiec lotniskowiec : listaLotniskowcow){
            Image obrazLotniskowca = new Image("militaryShip.png");
            imageViewLotniskowca = new ImageView(obrazLotniskowca);
            int polozenieX = lotniskowiec.getAktualnePolozenieX();
            int polozenieY = lotniskowiec.getAktualnePolozenieY();
            imageViewLotniskowca.setX(polozenieX);
            imageViewLotniskowca.setY(polozenieY);
            imageViewLotniskowca.setFitHeight(25);
            imageViewLotniskowca.setFitWidth(25);
            lotniskowiecGroup.getChildren().add(imageViewLotniskowca);
            clickEventObiekt(imageViewLotniskowca);
        }
    }

    public void tworzenieObrazuSamolotuCywilnego(SamolotPasazerski samolotPasazerski){
        Image obrazSamolotuCywilnegoImage = new Image("airpane.png");
        imageViewSamolotuCywilnego = new ImageView(obrazSamolotuCywilnegoImage);
        int polozenieX = samolotPasazerski.getAktualnePolozenieX();
        int polozenieY = samolotPasazerski.getAktualnePolozenieY();
        imageViewSamolotuCywilnego.setX(polozenieX);
        imageViewSamolotuCywilnego.setY(polozenieY);
        imageViewSamolotuCywilnego.setFitHeight(25);
        imageViewSamolotuCywilnego.setFitWidth(25);
        samolotCywilnyGroup.getChildren().add(imageViewSamolotuCywilnego);
        clickEventObiekt(imageViewSamolotuCywilnego);

    }

    public void tworzenieObrazuSamolotuWojskowego(SamolotWojskowy samolotWojskowy){
        Image obrazSamolotuWojskowegoImage = new Image("militaryAirplane.png");
        imageViewSamolotuWojskowego = new ImageView(obrazSamolotuWojskowegoImage);
        int polozenieX = samolotWojskowy.getAktualnePolozenieX();
        int polozenieY = samolotWojskowy.getAktualnePolozenieY();
        imageViewSamolotuWojskowego.setX(polozenieX);
        imageViewSamolotuWojskowego.setY(polozenieY);
        imageViewSamolotuWojskowego.setFitHeight(25);
        imageViewSamolotuWojskowego.setFitWidth(25);
        samolotWojskowyGroup.getChildren().add(imageViewSamolotuWojskowego);
        clickEventObiekt(imageViewSamolotuWojskowego);

    }

    public void clearPasazerski(){
        samolotCywilnyGroup.getChildren().clear();
    }

    public void clearWojskowy(){
        samolotWojskowyGroup.getChildren().clear();
    }

    public void clearCywilny(){
        statekCywilnyGroup.getChildren().clear();
    }

    public void clearLotniskowiec(){
        lotniskowiecGroup.getChildren().clear();
    }

    public void clickEventObiekt(ImageView image){
        image.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            double polozenieX = image.getX();
            double polozenieY = image.getY();
            System.out.println("Aktualne położenie X " + polozenieX);
            System.out.println("Aktualne położenie Y " + polozenieY);
            event.consume();
        });
    }

    public void przenoszenieObiektu(int aktualneX, int aktualneY, int doceloweX, int doceloweY, ImageView imageView, double czasPodrozy){
        Path path = new Path();
        MoveTo moveTo = new MoveTo(aktualneX, aktualneY);
        CubicCurveTo cubicCurveTo = new CubicCurveTo(doceloweX, doceloweY, aktualneX, aktualneY, doceloweX, doceloweY);
        path.getElements().add(moveTo);
        path.getElements().add(cubicCurveTo);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(czasPodrozy));
        pathTransition.setNode(imageView);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);

        pathTransition.statusProperty().addListener(new ChangeListener<Animation.Status>() {
            @Override
            public void changed(ObservableValue<? extends Animation.Status> observableValue, Animation.Status status, Animation.Status newValue) {
                if(newValue== Animation.Status.STOPPED){
                    imageView.setImage(null);
                }
            }
        });
        pathTransition.play();

    }




}
