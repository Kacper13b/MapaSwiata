package Kontroler;
import Klasy.*;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


import java.util.*;

/**
 * Klasa odpowiadająca za stworzenie panelu kontrolnego, jak i operacje związane między mapą a panelem kontrolnym
 */

public class ControllerView{

    private final Stage controllerWindow;
    public Baza baza;
    public Mapa mapa;
    private BorderPane borderPane;
    private Scene scene;
    private VBox elementy;
    private HBox guzikiTworzenia;
    private VBox srodek;
    private VBox lewy;

    public ListView <SamolotPasazerski> listViewSamolotPasazerski;
    public ListView <SamolotWojskowy> listViewSamolotWojskowy;
    public ListView <StatekCywilny> listViewStatekCywilny;
    public ListView <Lotniskowiec> listViewLotniskowiec;

    private RadioButton radioButtonSamolotPasazerski;
    private RadioButton radioButtonSamolotWojskowy;
    private RadioButton radioButtonStatekPasazerski;
    private RadioButton radioButtonLotniskowiec;
    private RadioButton radioButtonInfo;
    private ToggleGroup grupaRadioButtonow;

    private Button dodajButton;
    private Button usunButton;
    private Button rozpocznijLotButton;

    private Font font = Font.font("Verdana", 14);
    private Text samolotPasazerskiText;
    private Text samolotWojskowyText;
    private Text statekPasazerskiText;
    private Text lotniskowiecText;
    private Text infoCywilne;
    private Text infoWojskowe;

    private TextField liczbaPasazerowTextField;
    private TextField maksymalnaPredkoscTextField;
    private TextField liczbaPersoneluTextField;
    private TextField aktualnePaliwoTextField;
    private TextField maksymalnePaliwoTextField;
    private TextField trasaTextField;
    private TextField miejsceLadowaniaTextField;
    private TextField idTextField;
    private TextField typUzbrojeniaTextField;
    private TextField maksymalnaPojemnoscTextField;
    private TextField firmaTextField;

    private int liczbaPasazerow;
    private int maksymalnaPredkosc;
    private int liczbaPersonelu;
    private int aktualnePaliwo;
    private int maksymalnePaliwo;
    private String trasa;
    private int aktualnePolozenieX;
    private int aktualnePolozenieY;
    private int docelowePolozenieX;
    private int docelowePolozenieY;
    private String miejsceLadowania;
    private int id;
    private String typUzbrojenia;
    private int maksymalnaPojemnosc;
    private String firma;

    public LotniskoCywilne aktualneLotniskoCywilne;
    public LotniskoCywilne doceloweLotniskoCywilne;
    public LotniskoWojskowe aktualneLotniskoWojskowe;
    public LotniskoWojskowe doceloweLotniskoWojskowe;



    public ControllerView(Stage controllerWindow, Baza baza, Mapa mapa) {
        this.controllerWindow = controllerWindow;
        this.baza = baza;
        this.mapa = mapa;
        tworzenieOkna();
    }

    /**
     * Tworzenie okna panelu kontrolnego typu borderPane
     */
    public void tworzenieOkna() {
        borderPane = new BorderPane();
        scene = new Scene(borderPane, 800, 550);
        controllerWindow.setTitle("Kontroler");
        tworzeniePrawego();
        tworzenieSrodkowego();
        tworzenieDolnego();
        tworzenieLewego();
        borderPane.setRight(elementy);
        borderPane.setBottom(guzikiTworzenia);
        borderPane.setCenter(srodek);
        borderPane.setLeft(lewy);
        controllerWindow.show();
        controllerWindow.setScene(scene);


    }

    /**
     * Tworzenie prawej strony okna składającej się z radiobuttonów do wyboru obiektu
     */
    public void tworzeniePrawego(){
        elementy = new VBox();
        radioButtonSamolotPasazerski = new RadioButton("Samolot Pasazerski");
        radioButtonSamolotWojskowy = new RadioButton("Samolot Wojskowy");
        radioButtonStatekPasazerski = new RadioButton("Statek Pasazerski");
        radioButtonLotniskowiec = new RadioButton("Lotniskowiec");
        radioButtonInfo = new RadioButton("DOSTĘPNE LOTNISKA");
        grupaRadioButtonow = new ToggleGroup();
        radioButtonSamolotPasazerski.setToggleGroup(grupaRadioButtonow);
        radioButtonSamolotWojskowy.setToggleGroup(grupaRadioButtonow);
        radioButtonStatekPasazerski.setToggleGroup(grupaRadioButtonow);
        radioButtonLotniskowiec.setToggleGroup(grupaRadioButtonow);
        radioButtonInfo.setToggleGroup(grupaRadioButtonow);
        elementy.setSpacing(25);
        elementy.setAlignment(Pos.CENTER);
        elementy.setPadding(new Insets(25));
        elementy.getChildren().addAll(radioButtonSamolotPasazerski, radioButtonSamolotWojskowy, radioButtonStatekPasazerski, radioButtonLotniskowiec, radioButtonInfo);

    }

    /**
     * Tworzenie środkowej części okna
     */
    public void tworzenieSrodkowego(){
        srodek = new VBox();
        srodek.setPadding(new Insets(25));
        srodek.setSpacing(10);
        srodek.setAlignment(Pos.CENTER);
        tworzenieTekstu();


    }

    /**
     * metoda tworzenieTekstu odpowiada za wyświetlanie okien do wpisywania danych dla danego obiektu
     */
    public void tworzenieTekstu(){
        grupaRadioButtonow.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> aktualnaWartosc, Toggle staraGrupa, Toggle nowaGrupa) {
                if (grupaRadioButtonow.getSelectedToggle() != null){
                    if(radioButtonSamolotPasazerski.isSelected()){
                        srodek.getChildren().clear();
                        samolotPasazerskiText = new Text("Samolot Pasażerski");
                        samolotPasazerskiText.setFont(Font.font("Verdana",20));
                        liczbaPasazerowTextField = new TextField();
                        liczbaPasazerowTextField.setPromptText("Aktualna liczba Pasażerów w samolocie: ");
                        maksymalnaPredkoscTextField = new TextField();
                        maksymalnaPredkoscTextField.setPromptText("Maksymalna prędkość samolotu: ");
                        liczbaPersoneluTextField = new TextField();
                        liczbaPersoneluTextField.setPromptText("Liczba personelu w samolocie: ");
                        aktualnePaliwoTextField = new TextField();
                        aktualnePaliwoTextField.setPromptText("Aktualna liczba paliwa w samolocie: ");
                        maksymalnePaliwoTextField = new TextField();
                        maksymalnePaliwoTextField.setPromptText("Maksymalna ilosc paliwa w samolocie: ");
                        trasaTextField = new TextField();
                        trasaTextField.setPromptText("Z jakiego lotniska zaczyna lot");
                        miejsceLadowaniaTextField = new TextField();
                        miejsceLadowaniaTextField.setPromptText("Miejsce lądowania samolotu");
                        idTextField = new TextField();
                        idTextField.setPromptText("ID Samolotu");

                        liczbaPasazerowTextField.setFont(font);
                        maksymalnaPredkoscTextField.setFont(font);
                        liczbaPersoneluTextField.setFont(font);
                        aktualnePaliwoTextField.setFont(font);
                        maksymalnePaliwoTextField.setFont(font);
                        trasaTextField.setFont(font);
                        miejsceLadowaniaTextField.setFont(font);
                        idTextField.setFont(font);

                        srodek.getChildren().addAll(samolotPasazerskiText, liczbaPasazerowTextField, maksymalnaPredkoscTextField, liczbaPersoneluTextField, aktualnePaliwoTextField, maksymalnePaliwoTextField, trasaTextField, miejsceLadowaniaTextField, idTextField);
                    }
                    else if(radioButtonSamolotWojskowy.isSelected()){
                        srodek.getChildren().clear();
                        samolotWojskowyText = new Text("Samolot Wojskowy");
                        samolotWojskowyText.setFont(Font.font("Verdana",20));
                        maksymalnaPredkoscTextField = new TextField();
                        maksymalnaPredkoscTextField.setPromptText("Maksymalna prędkość samolotu ");
                        aktualnePaliwoTextField = new TextField();
                        aktualnePaliwoTextField.setPromptText("Aktualna liczba paliwa w samolocie: ");
                        maksymalnePaliwoTextField = new TextField();
                        maksymalnePaliwoTextField.setPromptText("Maksymalna ilosc paliwa w samolocie: ");
                        miejsceLadowaniaTextField = new TextField();
                        miejsceLadowaniaTextField.setPromptText("Miejsce lądowania samolotu");
                        idTextField = new TextField();
                        idTextField.setPromptText("ID Samolotu");

                        maksymalnaPredkoscTextField.setFont(font);
                        aktualnePaliwoTextField.setFont(font);
                        maksymalnePaliwoTextField.setFont(font);
                        miejsceLadowaniaTextField.setFont(font);
                        idTextField.setFont(font);
                        srodek.getChildren().addAll(samolotWojskowyText, maksymalnaPredkoscTextField, aktualnePaliwoTextField, maksymalnePaliwoTextField, miejsceLadowaniaTextField, idTextField);

                    }
                    else if(radioButtonStatekPasazerski.isSelected()){
                        srodek.getChildren().clear();
                        statekPasazerskiText = new Text("Statek Pasażerski");
                        statekPasazerskiText.setFont(Font.font("Verdana",20));
                        liczbaPasazerowTextField = new TextField();
                        liczbaPasazerowTextField.setPromptText("Aktualna liczba Pasażerów na statku: ");
                        maksymalnaPojemnoscTextField = new TextField();
                        maksymalnaPojemnoscTextField.setPromptText("Maksymalna pojemność pasażerów na statku:");
                        maksymalnaPredkoscTextField = new TextField();
                        maksymalnaPredkoscTextField.setPromptText("Maksymalna prędkość statku ");
                        firmaTextField = new TextField();
                        firmaTextField.setPromptText("Firma statku");
                        idTextField = new TextField();
                        idTextField.setPromptText("ID statku");

                        liczbaPasazerowTextField.setFont(font);
                        maksymalnaPojemnoscTextField.setFont(font);
                        maksymalnaPredkoscTextField.setFont(font);
                        firmaTextField.setFont(font);
                        idTextField.setFont(font);


                        srodek.getChildren().addAll(statekPasazerskiText, liczbaPasazerowTextField, maksymalnaPojemnoscTextField, maksymalnaPredkoscTextField, firmaTextField, idTextField);

                    }
                    else if(radioButtonLotniskowiec.isSelected()){
                        srodek.getChildren().clear();
                        lotniskowiecText = new Text("Lotniskowiec");
                        lotniskowiecText.setFont(Font.font("Verdana",20));
                        maksymalnaPredkoscTextField = new TextField();
                        maksymalnaPredkoscTextField.setPromptText("Maksymalna prędkość statku ");
                        idTextField = new TextField();
                        idTextField.setPromptText("ID statku");
                        typUzbrojeniaTextField = new TextField();
                        typUzbrojeniaTextField.setPromptText("Typ uzbrojenia statku");

                        typUzbrojeniaTextField.setFont(font);
                        maksymalnaPredkoscTextField.setFont(font);
                        idTextField.setFont(font);
                        typUzbrojeniaTextField.setFont(font);

                        srodek.getChildren().addAll(lotniskowiecText, maksymalnaPredkoscTextField, idTextField, typUzbrojeniaTextField);
                    }
                    else if(radioButtonInfo.isSelected()){
                        srodek.getChildren().clear();
                        infoCywilne = new Text("Dostepne lotniska cywilne:\nWarszawa, pojemność - 3\nMelbourne, pojemność - 5\nToronto, pojemność - 2\nBuenos Aires, pojemność - 5\nAleksandria, pojemność - 4");
                        infoCywilne.setFont(Font.font("Verdana",16));
                        infoCywilne.setTextAlignment(TextAlignment.LEFT);
                        infoWojskowe = new Text("Dostępne lotniska wojskowe:\nChabarowsk pojemność - 5\nMoskwa pojemność - 3\nPekin pojemność - 2\nKapsztad pojemność - 3\nLos Angeles pojemność - 4");
                        infoWojskowe.setFont(Font.font("Verdana",16));
                        infoWojskowe.setTextAlignment(TextAlignment.LEFT);
                        srodek.getChildren().addAll(infoCywilne,infoWojskowe);
                    }
                }

            }
        });

    }

    /**
     * Metoda odpowiadająca za tworzenie guzików obsługi obiektów znajdujących się w dolnej części okna
     */

    public void tworzenieDolnego(){
        guzikiTworzenia = new HBox();
        guzikiTworzenia.setSpacing(25);
        guzikiTworzenia.setAlignment(Pos.CENTER);
        guzikiTworzenia.setPadding(new Insets(25));
        dodajButton = new Button("Dodaj element");
        usunButton = new Button("Usun element");
        rozpocznijLotButton = new Button("Rozpocznij lot");
        dzialanieGuzikaDodaj();
        dzialanieGuzikaRozpocznijLot();
        dzialanieGuzikaUsun();

        guzikiTworzenia.getChildren().addAll(dodajButton, usunButton, rozpocznijLotButton);

    }

    /**
     * Tworzenie lewej części okna - wyświetlanie listy obiektów
     */
    public void tworzenieLewego() {
        lewy = new VBox();
        lewy.setSpacing(25);
        lewy.setAlignment(Pos.CENTER);
        lewy.setPadding(new Insets(25));
        listViewSamolotPasazerski = new ListView<SamolotPasazerski>();
        listViewSamolotWojskowy = new ListView<SamolotWojskowy>();
        listViewStatekCywilny = new ListView<StatekCywilny>();
        listViewLotniskowiec = new ListView<Lotniskowiec>();


        lewy.getChildren().addAll(listViewSamolotPasazerski, listViewSamolotWojskowy, listViewStatekCywilny, listViewLotniskowiec);

    }


    /**
     * Przetwarzanie danych wpisanych przez użytkownika na dane do stworzenia obiektu
     */
    public void pobieranieDanychSamolotPasazerski(){
        liczbaPasazerow = Integer.parseInt(liczbaPasazerowTextField.getText());
        maksymalnaPredkosc = Integer.parseInt(maksymalnaPredkoscTextField.getText());
        liczbaPersonelu = Integer.parseInt(liczbaPersoneluTextField.getText());
        aktualnePaliwo = Integer.parseInt(aktualnePaliwoTextField.getText());
        maksymalnePaliwo = Integer.parseInt(maksymalnePaliwoTextField.getText());
        if (aktualnePaliwo > maksymalnePaliwo){
            maksymalnaPredkosc = 0;
            System.out.println("Błąd przy podawaniu paliwa - samlot nie poleci ;(");
        }
        id = Integer.parseInt(idTextField.getText());
        trasa = trasaTextField.getText();
        int index = baza.listaNazwLotniskCywilnych.indexOf(trasa);
        miejsceLadowania = miejsceLadowaniaTextField.getText();
        int index2 = baza.listaNazwLotniskCywilnych.indexOf(miejsceLadowania);
        for (int i = 0; i < baza.listaKoordynatowLotniskCywilnych.size(); i++){
            if(i==index){
                aktualneLotniskoCywilne = baza.getListaLotniskCywilnych().get(i);
                aktualnePolozenieX = baza.listaKoordynatowLotniskCywilnych.get(i).get(0);
                aktualnePolozenieY = baza.listaKoordynatowLotniskCywilnych.get(i).get(1);
            }
        }
        for (int j = 0; j < baza.listaKoordynatowLotniskCywilnych.size(); j++){
            if(j==index2){
                doceloweLotniskoCywilne = baza.getListaLotniskCywilnych().get(j);
                docelowePolozenieX = baza.listaKoordynatowLotniskCywilnych.get(j).get(0);
                docelowePolozenieY = baza.listaKoordynatowLotniskCywilnych.get(j).get(1);
            }
        }

    }

    public void pobieranieDanychSamolotWojskowy(){
        maksymalnaPredkosc = Integer.parseInt(maksymalnaPredkoscTextField.getText());
        aktualnePaliwo = Integer.parseInt(aktualnePaliwoTextField.getText());
        maksymalnePaliwo = Integer.parseInt(maksymalnePaliwoTextField.getText());
        if (aktualnePaliwo > maksymalnePaliwo){
            maksymalnaPredkosc = 0;
            System.out.println("Błąd przy podawaniu paliwa - samlot nie poleci ;(");
        }
        miejsceLadowania = miejsceLadowaniaTextField.getText();
        int index2 = baza.listaNazwLotniskWojskowych.indexOf(miejsceLadowania);
        for (int j = 0; j < baza.listaKoordynatowLotniskWojskowych.size(); j++){
            if(j==index2){
                doceloweLotniskoWojskowe = baza.getListaLotniskWojskowch().get(j);
                docelowePolozenieX = baza.listaKoordynatowLotniskWojskowych.get(j).get(0);
                docelowePolozenieY = baza.listaKoordynatowLotniskWojskowych.get(j).get(1);
            }
        }
        for (Lotniskowiec lotniskowiec : baza.getListaLotniskowcow()){
            if(aktualnePolozenieX == lotniskowiec.getAktualnePolozenieX() && aktualnePolozenieY == lotniskowiec.getAktualnePolozenieY()){
                typUzbrojenia = lotniskowiec.getTypUzbrojenia();
            }

        }
        id = Integer.parseInt(idTextField.getText());

    }

    public void pobieranieDanychStatekPasazerski(){
        liczbaPasazerow = Integer.parseInt(liczbaPasazerowTextField.getText());
        maksymalnaPojemnosc = Integer.parseInt(maksymalnaPojemnoscTextField.getText());
        maksymalnaPredkosc = Integer.parseInt(maksymalnaPredkoscTextField.getText());
        id = Integer.parseInt(idTextField.getText());
        firma = firmaTextField.getText();
        aktualnePolozenieX = baza.listaPunktowTrasMorskich.get(0).get(0);
        aktualnePolozenieY = baza.listaPunktowTrasMorskich.get(0).get(1);

    }

    public void pobieranieDanychLotniskowiec(){
        maksymalnaPredkosc = Integer.parseInt(maksymalnaPredkoscTextField.getText());
        id = Integer.parseInt(idTextField.getText());
        typUzbrojenia = typUzbrojeniaTextField.getText();

    }

    /**
     * Opisuje działanie guzika rozpocznij lot
     * Przy wybraniu danego obiektu pobiera potrzebne dane ze stworzonego obiektu i sprawdza czy obiekt spełnia wszystkie wymagania, aby rozpocząc lot
     * Metoda implementująca lot w klasie Mapa
     */
    public void dzialanieGuzikaRozpocznijLot(){
        rozpocznijLotButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (radioButtonSamolotPasazerski.isSelected()){
                    final int index = listViewSamolotPasazerski.getSelectionModel().getSelectedIndex();
                    if (index != -1) {
                        SamolotPasazerski samolotPasazerski = listViewSamolotPasazerski.getSelectionModel().getSelectedItem();
                        int polozenieX = samolotPasazerski.getAktualnePolozenieX();
                        int polozenieY = samolotPasazerski.getAktualnePolozenieY();
                        int polozenieCeluX = samolotPasazerski.getDocelowePolozenieX();
                        int polozenieCeluY = samolotPasazerski.getDocelowePolozenieY();
                        int maksymalnaPredkosc = samolotPasazerski.getMaksymalnaPredkosc();

                        int dlugoscTrasy = baza.obliczanieDlugosciTrasy(polozenieX, polozenieY, polozenieCeluX, polozenieCeluY);
                        int potrzebnePaliwo = dlugoscTrasy/10;
                        samolotPasazerski.setAktualnePaliwo(samolotPasazerski.getAktualnePaliwo() - potrzebnePaliwo);
                        double czasPodrozy = dlugoscTrasy * 1000 / maksymalnaPredkosc;

                        if(samolotPasazerski.getAktualnePaliwo() < 0){
                            System.out.println("Za mało paliwa samolot nie doleci\nWymagana ilość paliwa: "+ potrzebnePaliwo);

                        }
                        else if(doceloweLotniskoCywilne.getZapelnienie() >= doceloweLotniskoCywilne.getPojemnosc()){
                            System.out.println("Docelowe Lotnisko zapełnione, poczekaj na zwolnienia miejsca");
                            samolotPasazerski.setAktualnePaliwo(samolotPasazerski.getMaksymalnePaliwo());
                        }
                        else {
                            mapa.tworzenieObrazuSamolotuCywilnego(samolotPasazerski);
                            aktualneLotniskoCywilne.setZapelnienie(aktualneLotniskoCywilne.getZapelnienie() - 1);
                            mapa.przenoszenieObiektuPasazerski(polozenieX, polozenieY, polozenieCeluX, polozenieCeluY, mapa.imageViewSamolotuCywilnego, czasPodrozy, samolotPasazerski, doceloweLotniskoCywilne);
                            clickEventObiektPasazerski(mapa.imageViewSamolotuCywilnego, samolotPasazerski);
                        }

                    }
                }
                else if(radioButtonSamolotWojskowy.isSelected()){
                    final int index = listViewSamolotWojskowy.getSelectionModel().getSelectedIndex();
                    if (index != -1) {
                        SamolotWojskowy samolotWojskowy = listViewSamolotWojskowy.getSelectionModel().getSelectedItem();
                        for(Lotniskowiec lotniskowiec : baza.getListaLotniskowcow()){
                            samolotWojskowy.setAktualnePolozenieX(lotniskowiec.getAktualnePolozenieX());
                            samolotWojskowy.setAktualnePolozenieY(lotniskowiec.getAktualnePolozenieY());
                        }
                        int polozenieCeluX = samolotWojskowy.getDocelowePolozenieX();
                        int polozenieCeluY = samolotWojskowy.getDocelowePolozenieY();
                        int maksymalnaPredkosc = samolotWojskowy.getMaksymalnaPredkosc();

                        int dlugoscTrasy = baza.obliczanieDlugosciTrasy(samolotWojskowy.getAktualnePolozenieX(), samolotWojskowy.getAktualnePolozenieY(), polozenieCeluX, polozenieCeluY);
                        double czasPodrozy = dlugoscTrasy * 1000 / maksymalnaPredkosc;
                        int potrzebnePaliwo = dlugoscTrasy/10;
                        samolotWojskowy.setAktualnePaliwo(samolotWojskowy.getAktualnePaliwo() - potrzebnePaliwo);
                        if(samolotWojskowy.getAktualnePaliwo() < 0){
                            System.out.println("Za mało paliwa samolot nie doleci\nWymagana ilość paliwa: "+ potrzebnePaliwo);

                        }
                        else if(doceloweLotniskoWojskowe.getZapelnienie() >= doceloweLotniskoWojskowe.getPojemnosc()){
                            System.out.println("Docelowe Lotnisko zapełnione, poczekaj na zwolnienia miejsca");
                            samolotWojskowy.setAktualnePaliwo(samolotWojskowy.getMaksymalnePaliwo());
                        }
                        else {
                            mapa.tworzenieObrazuSamolotuWojskowego(samolotWojskowy);
                            mapa.przenoszenieObiektuWojskowy(samolotWojskowy.getAktualnePolozenieX(), samolotWojskowy.getAktualnePolozenieY(), polozenieCeluX, polozenieCeluY, mapa.imageViewSamolotuWojskowego, czasPodrozy, samolotWojskowy, doceloweLotniskoWojskowe);
                            clickEventObiektWojskowy(mapa.imageViewSamolotuWojskowego, samolotWojskowy);
                        }
                    }
                }
                else if(radioButtonStatekPasazerski.isSelected()){
                    final int index = listViewStatekCywilny.getSelectionModel().getSelectedIndex();
                    if(index != -1){
                        StatekCywilny statekCywilny = listViewStatekCywilny.getSelectionModel().getSelectedItem();
                        mapa.tworzenieObrazuStatkuCywilnego(statekCywilny);
                        int predkoscStatku = statekCywilny.getMaksymalnaPredkosc();
                        double czasPodrozy = 1000000 / predkoscStatku;
                        mapa.przenoszenieStatku(mapa.imageViewStatkuCywilnego, czasPodrozy);
                    }
                }
                else if(radioButtonLotniskowiec.isSelected()){
                    final int index = listViewLotniskowiec.getSelectionModel().getSelectedIndex();
                    if(index != -1){
                        Lotniskowiec lotniskowiec = listViewLotniskowiec.getSelectionModel().getSelectedItem();
                        mapa.tworzenieObrazuLotniskowca(lotniskowiec);
                        int predkoscStatku = lotniskowiec.getMaksymalnaPredkosc();
                        double czasPodrozy = 1000000 / predkoscStatku;
                        mapa.przenoszenielotniskowca(mapa.imageViewLotniskowca, czasPodrozy, lotniskowiec);
                    }
                }
            }
        });
    }

    /**
     * Opisuje działanie guzika usuń element
     * Przy wybranym radiobuttonie danego obiektu wybieramy z listview obiekt danej klasy. Z bazy w danej liście usuwany jest obiekt o indeksie obiektu z listview, tak samo z imageview.
     * Po usunięciu z listview wybrany autoamtycznie zostaje następny obiekt aby móc szybko usuwać kolejne obiekty
     * guzik usuń zwalnia także miejsce z lotnisk w momencie usuwania
     */
    public void dzialanieGuzikaUsun(){
        List <SamolotPasazerski> listaSamolotowPasazerskich = baza.getListaSamolotowPasazerskich();
        List <SamolotWojskowy> listaSamolotowWojskowych = baza.getListaSamolotowWojskowych();
        List <StatekCywilny> listaStatkowCywilnych = baza.getListaStatkowCywilnych();
        List <Lotniskowiec> listaLotniskowcow = baza.getListaLotniskowcow();
        usunButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (radioButtonSamolotPasazerski.isSelected()){
                    final int index = listViewSamolotPasazerski.getSelectionModel().getSelectedIndex();
                    if (index != -1){


                        final int nowyIndex = (index == listViewSamolotPasazerski.getItems().size() - 1)
                                ? index - 1
                                : index;

                        listViewSamolotPasazerski.getItems().remove(index);
                        listViewSamolotPasazerski.getSelectionModel().select(nowyIndex);
                        SamolotPasazerski s = listaSamolotowPasazerskich.remove(index);
                        if (s.getAktualnePolozenieX() == s.getDocelowePolozenieX() && s.getAktualnePolozenieY() == s.getDocelowePolozenieY()){
                            doceloweLotniskoCywilne.setZapelnienie(doceloweLotniskoCywilne.getZapelnienie() - 1);
                        }
                        else {
                            aktualneLotniskoCywilne.setZapelnienie(aktualneLotniskoCywilne.getZapelnienie() - 1);
                        }
                        int Id = s.getIdSamolotu();
                        baza.setListaSamolotowPasazerskich(listaSamolotowPasazerskich);
                        try{
                            mapa.samolotCywilnyGroup.getChildren().remove(index);
                        }
                        catch (IndexOutOfBoundsException exception){

                            System.out.println("Usunięto samolot pasażerski o numerze ID - " + Id);
                        }

                    }
                }
                else if(radioButtonSamolotWojskowy.isSelected()){
                    final int index = listViewSamolotWojskowy.getSelectionModel().getSelectedIndex();
                    if (index != -1){
                        final int nowyIndex = (index == listViewSamolotWojskowy.getItems().size() - 1)
                                ? index - 1
                                : index;

                        listViewSamolotWojskowy.getItems().remove(index);
                        listViewSamolotWojskowy.getSelectionModel().select(nowyIndex);
                        SamolotWojskowy s = listaSamolotowWojskowych.remove(index);
                        if (s.getAktualnePolozenieX() == s.getDocelowePolozenieX() && s.getAktualnePolozenieY() == s.getDocelowePolozenieY()){
                            doceloweLotniskoWojskowe.setZapelnienie(doceloweLotniskoWojskowe.getZapelnienie() - 1);
                        }
                        else {
                            aktualneLotniskoWojskowe.setZapelnienie(aktualneLotniskoWojskowe.getZapelnienie() - 1);
                        }

                        int Id = s.getIdSamolotu();
                        baza.setListaSamolotowWojskowych(listaSamolotowWojskowych);
                        try{
                            mapa.samolotWojskowyGroup.getChildren().remove(index);
                        }
                        catch (IndexOutOfBoundsException exception){

                            System.out.println("Usunięto samolot wojskowy o numerze ID - " + Id);
                        }

                    }
                }
                else if(radioButtonStatekPasazerski.isSelected()){
                    final int index = listViewStatekCywilny.getSelectionModel().getSelectedIndex();
                    if (index != -1){

                        final int nowyIndex = (index == listViewStatekCywilny.getItems().size() - 1)
                                ? index - 1
                                : index;

                        listViewStatekCywilny.getItems().remove(index);
                        listViewStatekCywilny.getSelectionModel().select(nowyIndex);
                        StatekCywilny s = listaStatkowCywilnych.remove(index);
                        int Id = s.getId2();
                        baza.setListaStatkowCywilnych(listaStatkowCywilnych);
                        try{
                            mapa.statekCywilnyGroup.getChildren().remove(index);
                        }
                        catch (IndexOutOfBoundsException exception){

                            System.out.println("Usunięto statek pasażerski o numerze ID - " + Id);
                        }
                    }
                }
                else if(radioButtonLotniskowiec.isSelected()){
                    final int index = listViewLotniskowiec.getSelectionModel().getSelectedIndex();
                    if (index != -1){
                        final int nowyIndex = (index == listViewLotniskowiec.getItems().size() - 1)
                                ? index - 1
                                : index;

                        listViewLotniskowiec.getItems().remove(index);
                        listViewLotniskowiec.getSelectionModel().select(nowyIndex);
                        Lotniskowiec s = listaLotniskowcow.remove(index);
                        int Id = s.getId2();
                        baza.setListaLotniskowcow(listaLotniskowcow);
                        try{
                            mapa.lotniskowiecGroup.getChildren().remove(index);
                        }
                        catch (IndexOutOfBoundsException exception){

                            System.out.println("Usunięto Lotniskowiec o numerze ID - " + Id);
                        }
                    }
                }
            }
        });
    }

    /**
     * Opisuje działanie guzika dodaj element
     * Po wybraniu danego radiobuttona sprawdzamy czy wybrane lotnisko startowe ma wolne miejsce, jeśli nie na konsoli zostaje wypisana informacja i obiekt nie zostaje utworzony
     * Jeśli lotnisko ma wolne miejsce zostaje utworzony nowy obiekt a zapełnienie lotniska zostaje zwiększone o 1
     * lista i listview danego obeiktu zostają zaktualizowane
     */
    public void dzialanieGuzikaDodaj(){
        dodajButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (radioButtonSamolotPasazerski.isSelected()){
                    pobieranieDanychSamolotPasazerski();
                    if (aktualneLotniskoCywilne.getZapelnienie() >= aktualneLotniskoCywilne.getPojemnosc()){
                        System.out.println("Lotnisko zapełnione, zwolnij miejsce!");
                    }
                    else{
                        aktualneLotniskoCywilne.setZapelnienie(aktualneLotniskoCywilne.getZapelnienie() + 1);
                        SamolotPasazerski p = new SamolotPasazerski(liczbaPasazerow, maksymalnaPredkosc, liczbaPersonelu, aktualnePaliwo, maksymalnePaliwo, trasa, aktualnePolozenieX, aktualnePolozenieY, miejsceLadowania, id, docelowePolozenieX, docelowePolozenieY);
                        List <SamolotPasazerski> listaSamolotowPasazerskich = baza.getListaSamolotowPasazerskich();
                        listaSamolotowPasazerskich.add(p);
                        listViewSamolotPasazerski.getItems().add(p);
                        baza.setListaSamolotowPasazerskich(listaSamolotowPasazerskich);
                    }

                }
                else if(radioButtonSamolotWojskowy.isSelected()){
                    pobieranieDanychSamolotWojskowy();
                    SamolotWojskowy w = new SamolotWojskowy(aktualnePaliwo, maksymalnePaliwo, maksymalnaPredkosc, trasa, aktualnePolozenieX, aktualnePolozenieY, miejsceLadowania, id, typUzbrojenia, docelowePolozenieX, docelowePolozenieY);
                    List <SamolotWojskowy> listaSamolotowWojskowych = baza.getListaSamolotowWojskowych();
                    listaSamolotowWojskowych.add(w);
                    listViewSamolotWojskowy.getItems().add(w);
                    baza.setListaSamolotowWojskowych(listaSamolotowWojskowych);

                }

                else if(radioButtonStatekPasazerski.isSelected()){
                    pobieranieDanychStatekPasazerski();
                    StatekCywilny s = new StatekCywilny(maksymalnaPojemnosc, liczbaPasazerow, firma, maksymalnaPredkosc, aktualnePolozenieX, aktualnePolozenieY, id);
                    List <StatekCywilny> listaStatkowCywilnych = baza.getListaStatkowCywilnych();
                    listaStatkowCywilnych.add(s);
                    listViewStatekCywilny.getItems().add(s);
                    baza.setListaStatkowCywilnych(listaStatkowCywilnych);

                }
                else if(radioButtonLotniskowiec.isSelected()){
                    pobieranieDanychLotniskowiec();
                    Lotniskowiec l = new Lotniskowiec(maksymalnaPredkosc, aktualnePolozenieX, aktualnePolozenieY, id, typUzbrojenia);
                    List <Lotniskowiec> listaLotniskowcow = baza.getListaLotniskowcow();
                    listaLotniskowcow.add(l);
                    listViewLotniskowiec.getItems().add(l);
                    baza.setListaLotniskowcow(listaLotniskowcow);

                }
            }
        });
    }

    /**
     * Metoda opisująca działanie onClickEvent dla samolotów
     * Na konsoli wyśiwetla jego ID i koordynaty lotniska na które leci
     */
    public void clickEventObiektPasazerski(ImageView image, SamolotPasazerski samolot){
        image.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("ID Samolotu " + samolot.getIdSamolotu());
            System.out.println("Koordynaty na które leci samolot\nx - " + samolot.getDocelowePolozenieX() +" y - "+ samolot.getDocelowePolozenieY());
            event.consume();
        });
    }

    public void clickEventObiektWojskowy(ImageView image, SamolotWojskowy samolot){
        image.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("ID Samolotu " + samolot.getIdSamolotu());
            System.out.println("Koordynaty na które leci samolot\nx - " + samolot.getDocelowePolozenieX() +" y - "+ samolot.getDocelowePolozenieY());
            event.consume();
        });
    }

}
