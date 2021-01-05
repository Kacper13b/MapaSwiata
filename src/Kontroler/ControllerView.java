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

    private ListView <SamolotPasazerski> listViewSamolotPasazerski;
    private ListView <SamolotWojskowy> listViewSamolotWojskowy;
    private ListView <StatekCywilny> listViewStatekCywilny;
    private ListView <Lotniskowiec> listViewLotniskowiec;

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
    private TextField aktualnePolozenieXTextField;
    private TextField aktualnePolozenieYTextField;
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
    private String miasto;



    public ControllerView(Stage controllerWindow, Baza baza, Mapa mapa) {
        this.controllerWindow = controllerWindow;
        this.baza = baza;
        this.mapa = mapa;
        tworzenieOkna();
    }

    public void tworzenieOkna() {
        borderPane = new BorderPane();
        scene = new Scene(borderPane, 800, 550);
        controllerWindow.setTitle("Kontroler");
        //controllerWindow.show();
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

    public void tworzenieSrodkowego(){
        srodek = new VBox();
        srodek.setPadding(new Insets(25));
        srodek.setSpacing(10);
        srodek.setAlignment(Pos.CENTER);
        tworzenieTekstu();


    }

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
                        //aktualnePolozenieXTextField = new TextField();
                        //aktualnePolozenieXTextField.setPromptText("Wartość x wybranego lotniska");
                        //aktualnePolozenieYTextField = new TextField();
                        //aktualnePolozenieYTextField.setPromptText("Wartość y wybranego lotniska");
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
                        //aktualnePolozenieXTextField.setFont(font);
                        //aktualnePolozenieYTextField.setFont(font);
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
                        trasaTextField = new TextField();
                        trasaTextField.setPromptText("Lotnisko z którego zaczyna lot");
                        //aktualnePolozenieXTextField = new TextField();
                        //aktualnePolozenieXTextField.setPromptText("Aktualne położenie wartości x");
                        //aktualnePolozenieYTextField = new TextField();
                        //aktualnePolozenieYTextField.setPromptText("Aktualne położenie wartości y");
                        miejsceLadowaniaTextField = new TextField();
                        miejsceLadowaniaTextField.setPromptText("Miejsce lądowania samolotu");
                        idTextField = new TextField();
                        idTextField.setPromptText("ID Samolotu");
                        typUzbrojeniaTextField = new TextField();
                        typUzbrojeniaTextField.setPromptText("Typ uzbrojenia samolotu");

                        maksymalnaPredkoscTextField.setFont(font);
                        aktualnePaliwoTextField.setFont(font);
                        maksymalnePaliwoTextField.setFont(font);
                        trasaTextField.setFont(font);
                        //aktualnePolozenieXTextField.setFont(font);
                        //aktualnePolozenieYTextField.setFont(font);
                        miejsceLadowaniaTextField.setFont(font);
                        idTextField.setFont(font);
                        typUzbrojeniaTextField.setFont(font);
                        srodek.getChildren().addAll(samolotWojskowyText, maksymalnaPredkoscTextField, aktualnePaliwoTextField, maksymalnePaliwoTextField, trasaTextField, miejsceLadowaniaTextField, idTextField, typUzbrojeniaTextField);

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
                        aktualnePolozenieXTextField = new TextField();
                        aktualnePolozenieXTextField.setPromptText("Aktualne położenie wartości x");
                        aktualnePolozenieYTextField = new TextField();
                        aktualnePolozenieYTextField.setPromptText("Aktualne położenie wartości y");
                        firmaTextField = new TextField();
                        firmaTextField.setPromptText("Firma statku");
                        idTextField = new TextField();
                        idTextField.setPromptText("ID statku");

                        liczbaPasazerowTextField.setFont(font);
                        maksymalnaPojemnoscTextField.setFont(font);
                        maksymalnaPredkoscTextField.setFont(font);
                        aktualnePolozenieXTextField.setFont(font);
                        aktualnePolozenieYTextField.setFont(font);
                        firmaTextField.setFont(font);
                        idTextField.setFont(font);


                        srodek.getChildren().addAll(statekPasazerskiText, liczbaPasazerowTextField, maksymalnaPojemnoscTextField, maksymalnaPredkoscTextField, aktualnePolozenieXTextField, aktualnePolozenieYTextField, firmaTextField, idTextField);

                    }
                    else if(radioButtonLotniskowiec.isSelected()){
                        srodek.getChildren().clear();
                        lotniskowiecText = new Text("Lotniskowiec");
                        lotniskowiecText.setFont(Font.font("Verdana",20));
                        maksymalnaPredkoscTextField = new TextField();
                        maksymalnaPredkoscTextField.setPromptText("Maksymalna prędkość statku ");
                        aktualnePolozenieXTextField = new TextField();
                        aktualnePolozenieXTextField.setPromptText("Aktualne położenie wartości x");
                        aktualnePolozenieYTextField = new TextField();
                        aktualnePolozenieYTextField.setPromptText("Aktualne położenie wartości y");
                        idTextField = new TextField();
                        idTextField.setPromptText("ID statku");
                        typUzbrojeniaTextField = new TextField();
                        typUzbrojeniaTextField.setPromptText("Typ uzbrojenia statku");

                        typUzbrojeniaTextField.setFont(font);
                        maksymalnaPredkoscTextField.setFont(font);
                        aktualnePolozenieXTextField.setFont(font);
                        aktualnePolozenieYTextField.setFont(font);
                        idTextField.setFont(font);
                        typUzbrojeniaTextField.setFont(font);

                        srodek.getChildren().addAll(lotniskowiecText, maksymalnaPredkoscTextField, aktualnePolozenieXTextField, aktualnePolozenieYTextField, idTextField, typUzbrojeniaTextField);
                    }
                    else if(radioButtonInfo.isSelected()){
                        srodek.getChildren().clear();
                        infoCywilne = new Text("Dostepne lotniska cywilne:\nWarszawa\nToronto\nMelbourne\nBuenos Aires");
                        infoCywilne.setFont(Font.font("Verdana",16));
                        infoCywilne.setTextAlignment(TextAlignment.LEFT);
                        infoWojskowe = new Text("Dostępne lotniska wojskowe:\nPekin\nMoskwa\nKapsztad\nChabarowsk");
                        infoWojskowe.setFont(Font.font("Verdana",16));
                        infoWojskowe.setTextAlignment(TextAlignment.LEFT);
                        srodek.getChildren().addAll(infoCywilne,infoWojskowe);
                    }
                }

            }
        });

    }

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




    public void pobieranieDanychSamolotPasazerski(){
        liczbaPasazerow = Integer.parseInt(liczbaPasazerowTextField.getText());
        maksymalnaPredkosc = Integer.parseInt(maksymalnaPredkoscTextField.getText());
        liczbaPersonelu = Integer.parseInt(liczbaPersoneluTextField.getText());
        aktualnePaliwo = Integer.parseInt(aktualnePaliwoTextField.getText());
        maksymalnePaliwo = Integer.parseInt(maksymalnePaliwoTextField.getText());
        //aktualnePolozenieX = Integer.parseInt(aktualnePolozenieXTextField.getText());
        //aktualnePolozenieY = Integer.parseInt(aktualnePolozenieYTextField.getText());
        id = Integer.parseInt(idTextField.getText());
        trasa = trasaTextField.getText();
        int index = baza.listaNazwLotniskCywilnych.indexOf(trasa);
        for (int i = 0; i < baza.listaKoordynatowLotniskCywilnych.size(); i++){
            if(i==index){
                aktualnePolozenieX = baza.listaKoordynatowLotniskCywilnych.get(i).get(0);
                aktualnePolozenieY = baza.listaKoordynatowLotniskCywilnych.get(i).get(1);
            }
        }
        miejsceLadowania = miejsceLadowaniaTextField.getText();
        int index2 = baza.listaNazwLotniskCywilnych.indexOf(miejsceLadowania);
        for (int i = 0; i < baza.listaKoordynatowLotniskCywilnych.size(); i++){
            if(i==index2){
                docelowePolozenieX = baza.listaKoordynatowLotniskCywilnych.get(i).get(0);
                docelowePolozenieY = baza.listaKoordynatowLotniskCywilnych.get(i).get(1);
            }
        }

    }

    public void pobieranieDanychSamolotWojskowy(){
        maksymalnaPredkosc = Integer.parseInt(maksymalnaPredkoscTextField.getText());
        aktualnePaliwo = Integer.parseInt(aktualnePaliwoTextField.getText());
        maksymalnePaliwo = Integer.parseInt(maksymalnePaliwoTextField.getText());
        int index = baza.listaNazwLotniskWojskowych.indexOf(trasa);
        for (int i = 0; i < baza.listaKoordynatowLotniskWojskowych.size(); i++){
            if(i==index){
                aktualnePolozenieX = baza.listaKoordynatowLotniskWojskowych.get(i).get(0);
                aktualnePolozenieY = baza.listaKoordynatowLotniskWojskowych.get(i).get(1);
            }
        }
        //aktualnePolozenieX = Integer.parseInt(aktualnePolozenieXTextField.getText());
        //aktualnePolozenieY = Integer.parseInt(aktualnePolozenieYTextField.getText());
        id = Integer.parseInt(idTextField.getText());
        trasa = trasaTextField.getText();
        miejsceLadowania = miejsceLadowaniaTextField.getText();
        typUzbrojenia = typUzbrojeniaTextField.getText();

    }

    public void pobieranieDanychStatekPasazerski(){
        liczbaPasazerow = Integer.parseInt(liczbaPasazerowTextField.getText());
        maksymalnaPojemnosc = Integer.parseInt(maksymalnaPojemnoscTextField.getText());
        maksymalnaPredkosc = Integer.parseInt(maksymalnaPredkoscTextField.getText());
        aktualnePolozenieX = Integer.parseInt(aktualnePolozenieXTextField.getText());
        aktualnePolozenieY = Integer.parseInt(aktualnePolozenieYTextField.getText());
        id = Integer.parseInt(idTextField.getText());
        firma = firmaTextField.getText();

    }

    public void pobieranieDanychLotniskowiec(){
        maksymalnaPredkosc = Integer.parseInt(maksymalnaPredkoscTextField.getText());
        aktualnePolozenieX = Integer.parseInt(aktualnePolozenieXTextField.getText());
        aktualnePolozenieY = Integer.parseInt(aktualnePolozenieYTextField.getText());
        id = Integer.parseInt(idTextField.getText());
        typUzbrojenia = typUzbrojeniaTextField.getText();

    }


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
                        mapa.przenoszenieObiektu(polozenieX, polozenieY, polozenieCeluX, polozenieCeluY, mapa.imageViewSamolotuCywilnego);
                    }
                }
                else if(radioButtonSamolotWojskowy.isSelected()){
                    pobieranieDanychSamolotWojskowy();
                    List <SamolotWojskowy> w = baza.getListaSamolotowWojskowych();
                    System.out.println(w);
                }
                else if(radioButtonStatekPasazerski.isSelected()){
                    pobieranieDanychStatekPasazerski();
                    List <StatekCywilny> s = baza.getListaStatkowCywilnych();
                    System.out.println(s);
                }
                else if(radioButtonLotniskowiec.isSelected()){
                    pobieranieDanychLotniskowiec();
                    List <Lotniskowiec> l = baza.getListaLotniskowcow();
                    System.out.println(l);
                }
            }
        });
    }

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
                        SamolotPasazerski doUsuniecia = listViewSamolotPasazerski.getSelectionModel().getSelectedItem();

                        final int nowyIndex = (index == listViewSamolotPasazerski.getItems().size() - 1)
                                ? index - 1
                                : index;

                        listViewSamolotPasazerski.getItems().remove(index);
                        listViewSamolotPasazerski.getSelectionModel().select(nowyIndex);
                        listaSamolotowPasazerskich.remove(index);
                        baza.setListaSamolotowPasazerskich(listaSamolotowPasazerskich);
                        mapa.clearPasazerski();
                        mapa.tworzenieObrazuSamolotuCywilnego();
                        System.out.println("Usunięto samolot pasażerski: " + doUsuniecia);
                    }
                }
                else if(radioButtonSamolotWojskowy.isSelected()){
                    final int index = listViewSamolotWojskowy.getSelectionModel().getSelectedIndex();
                    if (index != -1){
                        SamolotWojskowy doUsuniecia = listViewSamolotWojskowy.getSelectionModel().getSelectedItem();

                        final int nowyIndex = (index == listViewSamolotWojskowy.getItems().size() - 1)
                                ? index - 1
                                : index;

                        listViewSamolotWojskowy.getItems().remove(index);
                        listViewSamolotWojskowy.getSelectionModel().select(nowyIndex);
                        listaSamolotowWojskowych.remove(index);
                        baza.setListaSamolotowWojskowych(listaSamolotowWojskowych);
                        mapa.clearWojskowy();
                        mapa.tworzenieObrazuSamolotuWojskowego();
                        System.out.println("Usunięto samolot wojskowych: " + doUsuniecia);
                    }
                }
                else if(radioButtonStatekPasazerski.isSelected()){
                    final int index = listViewStatekCywilny.getSelectionModel().getSelectedIndex();
                    if (index != -1){
                        StatekCywilny doUsuniecia = listViewStatekCywilny.getSelectionModel().getSelectedItem();

                        final int nowyIndex = (index == listViewStatekCywilny.getItems().size() - 1)
                                ? index - 1
                                : index;

                        listViewStatekCywilny.getItems().remove(index);
                        listViewStatekCywilny.getSelectionModel().select(nowyIndex);
                        listaStatkowCywilnych.remove(index);
                        baza.setListaStatkowCywilnych(listaStatkowCywilnych);
                        mapa.clearCywilny();
                        mapa.tworzenieObrazuStatkuCywilnego();
                        System.out.println("Usunięto samolot wojskowych: " + doUsuniecia);
                    }
                }
                else if(radioButtonLotniskowiec.isSelected()){
                    final int index = listViewLotniskowiec.getSelectionModel().getSelectedIndex();
                    if (index != -1){
                        Lotniskowiec doUsuniecia = listViewLotniskowiec.getSelectionModel().getSelectedItem();
                        final int nowyIndex = (index == listViewLotniskowiec.getItems().size() - 1)
                                ? index - 1
                                : index;

                        listViewLotniskowiec.getItems().remove(index);
                        listViewLotniskowiec.getSelectionModel().select(nowyIndex);
                        listaLotniskowcow.remove(index);
                        baza.setListaLotniskowcow(listaLotniskowcow);
                        mapa.clearLotniskowiec();
                        mapa.tworzenieObrazuLotniskowca();
                        System.out.println("Usunięto Lotniskowiec: " + doUsuniecia);
                    }
                }
            }
        });
    }

    public void dzialanieGuzikaDodaj(){
        dodajButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (radioButtonSamolotPasazerski.isSelected()){
                    pobieranieDanychSamolotPasazerski();
                    SamolotPasazerski p = new SamolotPasazerski(liczbaPasazerow, maksymalnaPredkosc, liczbaPersonelu, aktualnePaliwo, maksymalnePaliwo, trasa, aktualnePolozenieX, aktualnePolozenieY, miejsceLadowania, id, docelowePolozenieX, docelowePolozenieY);
                    List <SamolotPasazerski> listaSamolotowPasazerskich = baza.getListaSamolotowPasazerskich();
                    listaSamolotowPasazerskich.add(p);
                    listViewSamolotPasazerski.getItems().add(p);
                    baza.setListaSamolotowPasazerskich(listaSamolotowPasazerskich);
                    mapa.tworzenieObrazuSamolotuCywilnego();

                }
                else if(radioButtonSamolotWojskowy.isSelected()){
                    pobieranieDanychSamolotWojskowy();
                    SamolotWojskowy w = new SamolotWojskowy(aktualnePaliwo, maksymalnePaliwo, maksymalnaPredkosc, trasa, aktualnePolozenieX, aktualnePolozenieY, miejsceLadowania, id, typUzbrojenia);
                    List <SamolotWojskowy> listaSamolotowWojskowych = baza.getListaSamolotowWojskowych();
                    listaSamolotowWojskowych.add(w);
                    listViewSamolotWojskowy.getItems().add(w);
                    baza.setListaSamolotowWojskowych(listaSamolotowWojskowych);
                    mapa.tworzenieObrazuSamolotuWojskowego();

                }

                else if(radioButtonStatekPasazerski.isSelected()){
                    pobieranieDanychStatekPasazerski();
                    StatekCywilny s = new StatekCywilny(maksymalnaPojemnosc, liczbaPasazerow, firma, maksymalnaPredkosc, aktualnePolozenieX, aktualnePolozenieY, id);
                    List <StatekCywilny> listaStatkowCywilnych = baza.getListaStatkowCywilnych();
                    listaStatkowCywilnych.add(s);
                    listViewStatekCywilny.getItems().add(s);
                    baza.setListaStatkowCywilnych(listaStatkowCywilnych);
                    mapa.tworzenieObrazuStatkuCywilnego();


                }
                else if(radioButtonLotniskowiec.isSelected()){
                    pobieranieDanychLotniskowiec();
                    Lotniskowiec l = new Lotniskowiec(maksymalnaPredkosc, aktualnePolozenieX, aktualnePolozenieY, id, typUzbrojenia);
                    List <Lotniskowiec> listaLotniskowcow = baza.getListaLotniskowcow();
                    listaLotniskowcow.add(l);
                    listViewLotniskowiec.getItems().add(l);
                    baza.setListaLotniskowcow(listaLotniskowcow);
                    mapa.tworzenieObrazuLotniskowca();
                }
            }
        });
    }

    public void test(){

    }
}
