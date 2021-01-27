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
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

import javafx.util.Duration;

import java.util.List;

/**
 * Klasa sceny mapy wraz z metodami obsługującymi imageview wszystkich obiektów
 */
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


    public Mapa(Stage mapaSwiata, Baza baza) {
        this.mapaSwiata = mapaSwiata;
        this.baza = baza;
        tworzenieOkna();
    }

    /**
     * Metoda tworzenia okna
     */
    private void tworzenieOkna(){
        tworzenieObrazu();
        baza.dodajTrasyMorskie();
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



    }

    /**
     * Metoda tworzeni obrazu Mapy
     */
    private void tworzenieObrazu(){
        Image obrazMapyImage = new Image("obrazMapy.jpg");
        imageViewMapy = new ImageView(obrazMapyImage);

    }

    /**
     * Metody tworzące obraz danego obiektu
     */

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

    }

    public void tworzenieObrazuStatkuCywilnego(StatekCywilny statekCywilny){
        Image obrazStatkuCywilnego = new Image("cruiseShip.png");
        imageViewStatkuCywilnego = new ImageView(obrazStatkuCywilnego);
        int polozenieX = statekCywilny.getAktualnePolozenieX();
        int polozenieY = statekCywilny.getAktualnePolozenieY();
        imageViewStatkuCywilnego.setX(polozenieX);
        imageViewStatkuCywilnego.setY(polozenieY);
        imageViewStatkuCywilnego.setFitHeight(25);
        imageViewStatkuCywilnego.setFitWidth(25);
        statekCywilnyGroup.getChildren().add(imageViewStatkuCywilnego);

    }

    public void tworzenieObrazuLotniskowca(Lotniskowiec lotniskowiec){
        Image obrazLotniskowca = new Image("militaryShip.png");
        imageViewLotniskowca = new ImageView(obrazLotniskowca);
        int polozenieX = lotniskowiec.getAktualnePolozenieX();
        int polozenieY = lotniskowiec.getAktualnePolozenieY();
        imageViewLotniskowca.setX(polozenieX);
        imageViewLotniskowca.setY(polozenieY);
        imageViewLotniskowca.setFitHeight(25);
        imageViewLotniskowca.setFitWidth(25);
        lotniskowiecGroup.getChildren().add(imageViewLotniskowca);

    }


    /**
     * Metoda odpowiadająca za animacje poruszania się samolotu pasażerskiego
     * @param aktualneX - współrzędna x lotniska startowego
     * @param aktualneY - współrzędna y lotniska startowego
     * @param doceloweX - współrzędna x lotniska docelowego
     * @param doceloweY - współrzędna y lotniska docelowego
     * @param imageView - imageview obiektu
     * @param czasPodrozy - za pomocą podanej prędkości obiektu obliczany jest czas podróży, długość animacji
     * @param samolotPasazerski - obiekt
     * @param doceloweLotnisko - obiekt lotniska do którego leci, w celu zwiększenia zapełnienia
     */

    public void przenoszenieObiektuPasazerski(int aktualneX, int aktualneY, int doceloweX, int doceloweY, ImageView imageView, double czasPodrozy, SamolotPasazerski samolotPasazerski, LotniskoCywilne doceloweLotnisko){
        Path path = new Path();
        MoveTo moveTo = new MoveTo(aktualneX, aktualneY);
        LineTo lineTo = new LineTo(doceloweX, doceloweY);
        path.getElements().addAll(moveTo, lineTo);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(czasPodrozy));
        pathTransition.setNode(imageView);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition.setAutoReverse(false);
        pathTransition.setCycleCount(1);

        pathTransition.statusProperty().addListener(new ChangeListener<Animation.Status>() {
            @Override
            public void changed(ObservableValue<? extends Animation.Status> observableValue, Animation.Status status, Animation.Status newValue) {
                if(newValue== Animation.Status.STOPPED){
                    imageView.setImage(null);
                    baza.wyswietlInfoPasazerski(aktualneX, aktualneY, samolotPasazerski);
                    int aktualnePaliwo = samolotPasazerski.getAktualnePaliwo();
                    samolotPasazerski.setAktualnePaliwo(samolotPasazerski.tankuj(aktualnePaliwo));
                    doceloweLotnisko.setZapelnienie(doceloweLotnisko.getZapelnienie() + 1);
                    samolotPasazerski.setAktualnePolozenieX(doceloweX);
                    samolotPasazerski.setAktualnePolozenieY(doceloweY);
                }
            }
        });
        pathTransition.play();
    }

    /**
     * Metoda odpowiadająca za animacje poruszania się samolotu wojskowego
     * @param aktualneX - współrzędna x lotniska startowego
     * @param aktualneY - współrzędna y lotniska startowego
     * @param doceloweX - współrzędna x lotniska docelowego
     * @param doceloweY - współrzędna y lotniska docelowego
     * @param imageView - imageview obiektu
     * @param czasPodrozy - za pomocą podanej prędkości obiektu obliczany jest czas podróży, długość animacji
     * @param samolotWojskowy - obiekt
     * @param doceloweLotnisko - obiekt lotniska do którego leci, w celu zwiększenia zapełnienia
     */

    public void przenoszenieObiektuWojskowy(int aktualneX, int aktualneY, int doceloweX, int doceloweY, ImageView imageView, double czasPodrozy, SamolotWojskowy samolotWojskowy, LotniskoWojskowe doceloweLotnisko){
        Path path = new Path();
        MoveTo moveTo = new MoveTo(aktualneX, aktualneY);
        LineTo lineTo = new LineTo(doceloweX, doceloweY);
        path.getElements().addAll(moveTo, lineTo);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(czasPodrozy));
        pathTransition.setNode(imageView);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);

        pathTransition.statusProperty().addListener(new ChangeListener<Animation.Status>() {
            @Override
            public void changed(ObservableValue<? extends Animation.Status> observableValue, Animation.Status status, Animation.Status newValue) {
                if(newValue== Animation.Status.STOPPED){
                    imageView.setImage(null);
                    baza.wyswietlInfoWojskowy(aktualneX, aktualneY, samolotWojskowy);
                    int aktualnePaliwo = samolotWojskowy.getAktualnePaliwo();
                    samolotWojskowy.setAktualnePaliwo(samolotWojskowy.tankuj(aktualnePaliwo));
                    doceloweLotnisko.setZapelnienie(doceloweLotnisko.getZapelnienie() + 1);
                    samolotWojskowy.setAktualnePolozenieX(doceloweX);
                    samolotWojskowy.setAktualnePolozenieY(doceloweY);

                }
            }
        });
        pathTransition.play();

    }

    /**
     * Metoda odpowiadająca za animacje poruszania się statku wycieczkowego i lotniskowca po trasie morskiej
     */
    public void przenoszenieStatku(ImageView imageView, double czasPodrozy){
        Path path = new Path();
        MoveTo moveTo = new MoveTo(baza.listaPunktowTrasMorskich.get(0).get(0), baza.listaPunktowTrasMorskich.get(0).get(1));
        path.getElements().add(moveTo);
        for(int i=1; i < baza.listaPunktowTrasMorskich.size(); i++){
            LineTo lineTo = new LineTo(baza.listaPunktowTrasMorskich.get(i).get(0), baza.listaPunktowTrasMorskich.get(i).get(1));
            path.getElements().add(lineTo);
        }
        LineTo lineTo = new LineTo(baza.listaPunktowTrasMorskich.get(0).get(0), baza.listaPunktowTrasMorskich.get(0).get(1));
        path.getElements().add(lineTo);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(czasPodrozy));
        pathTransition.setNode(imageView);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setAutoReverse(false);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.play();

    }

    public void przenoszenielotniskowca(ImageView imageView, double czasPodrozy, Lotniskowiec lotniskowiec){
        Path path = new Path();
        MoveTo moveTo = new MoveTo(baza.listaPunktowTrasMorskich.get(0).get(0), baza.listaPunktowTrasMorskich.get(0).get(1));
        path.getElements().add(moveTo);
        for(int i=1; i < baza.listaPunktowTrasMorskich.size(); i++){
            LineTo lineTo = new LineTo(baza.listaPunktowTrasMorskich.get(i).get(0), baza.listaPunktowTrasMorskich.get(i).get(1));
            path.getElements().add(lineTo);

        }
        LineTo lineTo = new LineTo(baza.listaPunktowTrasMorskich.get(0).get(0), baza.listaPunktowTrasMorskich.get(0).get(1));
        path.getElements().add(lineTo);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(czasPodrozy));
        pathTransition.setNode(imageView);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setAutoReverse(false);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        //pathTransition.play();

        pathTransition.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration t1) {
                double x = imageView.getTranslateX();
                double y = imageView.getTranslateY();
                lotniskowiec.setAktualnePolozenieX((int) x + 13);
                lotniskowiec.setAktualnePolozenieY((int) y + 13);
            }
        });
        pathTransition.play();

    }



}
