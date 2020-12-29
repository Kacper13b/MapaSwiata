package Kontroler;
import Klasy.*;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;


public class ControllerView{

    private final Stage controllerWindow;
    public Baza baza;
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
    private ToggleGroup grupaRadioButtonow;

    private Button dodajButton;
    private Button usunButton;
    private Button wyswietlInfoButton;

    private Font font = Font.font("Verdana", 14);
    private Text samolotPasazerskiText;
    private Text samolotWojskowyText;
    private Text statekPasazerskiText;
    private Text lotniskowiecText;



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
    private String miejsceLadowania;
    private int id;
    private String typUzbrojenia;
    private int maksymalnaPojemnosc;
    private String firma;





    public ControllerView(Stage controllerWindow, Baza baza) {
        this.controllerWindow = controllerWindow;
        this.baza = baza;
        tworzenieOkna();
    }

    public void tworzenieOkna() {
        borderPane = new BorderPane();
        scene = new Scene(borderPane, 1000, 600);
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
        grupaRadioButtonow = new ToggleGroup();
        radioButtonSamolotPasazerski.setToggleGroup(grupaRadioButtonow);
        radioButtonSamolotWojskowy.setToggleGroup(grupaRadioButtonow);
        radioButtonStatekPasazerski.setToggleGroup(grupaRadioButtonow);
        radioButtonLotniskowiec.setToggleGroup(grupaRadioButtonow);
        elementy.setSpacing(25);
        elementy.setAlignment(Pos.CENTER);
        elementy.setPadding(new Insets(25));
        elementy.getChildren().addAll(radioButtonSamolotPasazerski, radioButtonSamolotWojskowy, radioButtonStatekPasazerski, radioButtonLotniskowiec);

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
                        trasaTextField.setPromptText("Trasa lotu");
                        aktualnePolozenieXTextField = new TextField();
                        aktualnePolozenieXTextField.setPromptText("Aktualne położenie wartości x");
                        aktualnePolozenieYTextField = new TextField();
                        aktualnePolozenieYTextField.setPromptText("Aktualne położenie wartości y");
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
                        aktualnePolozenieXTextField.setFont(font);
                        aktualnePolozenieYTextField.setFont(font);
                        miejsceLadowaniaTextField.setFont(font);
                        idTextField.setFont(font);

                        srodek.getChildren().addAll(samolotPasazerskiText, liczbaPasazerowTextField, maksymalnaPredkoscTextField, liczbaPersoneluTextField, aktualnePaliwoTextField, maksymalnePaliwoTextField, trasaTextField, aktualnePolozenieXTextField, aktualnePolozenieYTextField, miejsceLadowaniaTextField, idTextField);
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
                        trasaTextField.setPromptText("Trasa lotu");
                        aktualnePolozenieXTextField = new TextField();
                        aktualnePolozenieXTextField.setPromptText("Aktualne położenie wartości x");
                        aktualnePolozenieYTextField = new TextField();
                        aktualnePolozenieYTextField.setPromptText("Aktualne położenie wartości y");
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
                        aktualnePolozenieXTextField.setFont(font);
                        aktualnePolozenieYTextField.setFont(font);
                        miejsceLadowaniaTextField.setFont(font);
                        idTextField.setFont(font);
                        typUzbrojeniaTextField.setFont(font);
                        srodek.getChildren().addAll(samolotWojskowyText, maksymalnaPredkoscTextField, aktualnePaliwoTextField, maksymalnePaliwoTextField, trasaTextField, aktualnePolozenieXTextField, aktualnePolozenieYTextField, miejsceLadowaniaTextField, idTextField, typUzbrojeniaTextField);

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
        wyswietlInfoButton = new Button("Wyswietl Info");
        dzialanieGuzikaDodaj();
        dzialanieGuzikaInfo();
        dzialanieGuzikaUsun();

        guzikiTworzenia.getChildren().addAll(dodajButton, usunButton, wyswietlInfoButton);

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
        aktualnePolozenieX = Integer.parseInt(aktualnePolozenieXTextField.getText());
        aktualnePolozenieY = Integer.parseInt(aktualnePolozenieYTextField.getText());
        id = Integer.parseInt(idTextField.getText());
        trasa = trasaTextField.getText();
        miejsceLadowania = miejsceLadowaniaTextField.getText();

    }

    public void pobieranieDanychSamolotWojskowy(){
        maksymalnaPredkosc = Integer.parseInt(maksymalnaPredkoscTextField.getText());
        aktualnePaliwo = Integer.parseInt(aktualnePaliwoTextField.getText());
        maksymalnePaliwo = Integer.parseInt(maksymalnePaliwoTextField.getText());
        aktualnePolozenieX = Integer.parseInt(aktualnePolozenieXTextField.getText());
        aktualnePolozenieY = Integer.parseInt(aktualnePolozenieYTextField.getText());
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


    public void dzialanieGuzikaInfo(){
        wyswietlInfoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (radioButtonSamolotPasazerski.isSelected()){
                    pobieranieDanychSamolotPasazerski();
                    List <SamolotPasazerski> p = baza.getListaSamolotowPasazerskich();
                    System.out.println(p);
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
                    SamolotPasazerski p = new SamolotPasazerski(liczbaPasazerow, maksymalnaPredkosc, liczbaPersonelu, aktualnePaliwo, maksymalnePaliwo, trasa, aktualnePolozenieX, aktualnePolozenieY, miejsceLadowania, id);
                    List <SamolotPasazerski> listaSamolotowPasazerskich = baza.getListaSamolotowPasazerskich();
                    listaSamolotowPasazerskich.add(p);
                    listViewSamolotPasazerski.getItems().add(p);
                    baza.setListaSamolotowPasazerskich(listaSamolotowPasazerskich);
                }
                else if(radioButtonSamolotWojskowy.isSelected()){
                    pobieranieDanychSamolotWojskowy();
                    SamolotWojskowy w = new SamolotWojskowy(aktualnePaliwo, maksymalnePaliwo, maksymalnaPredkosc, trasa, aktualnePolozenieX, aktualnePolozenieY, miejsceLadowania, id, typUzbrojenia);
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

}
