package Kontroler;

import Klasy.*;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Baza {
    private List<LotniskoCywilne> listaLotniskCywilnych = new ArrayList<LotniskoCywilne>();
    private List<LotniskoWojskowe> listaLotniskWojskowch = new ArrayList<LotniskoWojskowe>();
    private List<SamolotPasazerski> listaSamolotowPasazerskich = new ArrayList<SamolotPasazerski>();
    private List<SamolotWojskowy> listaSamolotowWojskowych = new ArrayList<SamolotWojskowy>();
    private List<StatekCywilny> listaStatkowCywilnych = new ArrayList<StatekCywilny>();
    private List<Lotniskowiec> listaLotniskowcow = new ArrayList<Lotniskowiec>();

    public List<LotniskoCywilne> getListaLotniskCywilnych() {
        return listaLotniskCywilnych;
    }

    public void setListaLotniskCywilnych(List<LotniskoCywilne> listaLotniskCywilnych) {
        this.listaLotniskCywilnych = listaLotniskCywilnych;
    }

    public List<LotniskoWojskowe> getListaLotniskWojskowch() {
        return listaLotniskWojskowch;
    }

    public void setListaLotniskWojskowch(List<LotniskoWojskowe> listaLotniskWojskowch) {
        this.listaLotniskWojskowch = listaLotniskWojskowch;
    }

    public List<SamolotPasazerski> getListaSamolotowPasazerskich() {
        return listaSamolotowPasazerskich;
    }

    public void setListaSamolotowPasazerskich(List<SamolotPasazerski> listaSamolotowPasazerskich) {
        this.listaSamolotowPasazerskich = listaSamolotowPasazerskich;
    }

    public List<SamolotWojskowy> getListaSamolotowWojskowych() {
        return listaSamolotowWojskowych;
    }

    public void setListaSamolotowWojskowych(List<SamolotWojskowy> listaSamolotowWojskowych) {
        this.listaSamolotowWojskowych = listaSamolotowWojskowych;
    }

    public List<StatekCywilny> getListaStatkowCywilnych() {
        return listaStatkowCywilnych;
    }

    public void setListaStatkowCywilnych(List<StatekCywilny> listaStatkowCywilnych) {
        this.listaStatkowCywilnych = listaStatkowCywilnych;
    }

    public List<Lotniskowiec> getListaLotniskowcow() {
        return listaLotniskowcow;
    }

    public void setListaLotniskowcow(List<Lotniskowiec> listaLotniskowcow) {
        this.listaLotniskowcow = listaLotniskowcow;
    }

    public void stworzPasazerski(int liczbaPasazerow, int maksymalnaPojemnosc, int liczbaPersonelu, int aktualnePaliwo, int maksymalnePaliwo, String trasa, int aktualnePolozenieX, int aktualnePolozenieY, String miejsceLadowania, int id){
        SamolotPasazerski s = new SamolotPasazerski(liczbaPasazerow, maksymalnaPojemnosc, liczbaPersonelu, aktualnePaliwo, maksymalnePaliwo, trasa, aktualnePolozenieX, aktualnePolozenieY, miejsceLadowania, id);
        listaSamolotowPasazerskich.add(s);
    }

    public void stworzWojskowy(){

    }

    public void stworzCywilny(){

    }

    public void stworzLotniskowiec(){

    }

    public void wyswietlInfo(){

    }

    public void usun(){

    }

    public void wywolajAwarie(){

    }



}

