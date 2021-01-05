package Kontroler;

import Klasy.*;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Baza {
    private List<LotniskoCywilne> listaLotniskCywilnych = new ArrayList<LotniskoCywilne>();
    private List<LotniskoWojskowe> listaLotniskWojskowch = new ArrayList<LotniskoWojskowe>();
    private List<SamolotPasazerski> listaSamolotowPasazerskich = new ArrayList<SamolotPasazerski>();
    private List<SamolotWojskowy> listaSamolotowWojskowych = new ArrayList<SamolotWojskowy>();
    private List<StatekCywilny> listaStatkowCywilnych = new ArrayList<StatekCywilny>();
    private List<Lotniskowiec> listaLotniskowcow = new ArrayList<Lotniskowiec>();

    public List<String> listaNazwLotniskCywilnych = new ArrayList<>();
    public ArrayList<ArrayList<Integer> > listaKoordynatowLotniskCywilnych = new ArrayList<ArrayList<Integer> >();
    public List<String> listaNazwLotniskWojskowych = new ArrayList<>();
    public ArrayList<ArrayList<Integer> > listaKoordynatowLotniskWojskowych = new ArrayList<ArrayList<Integer> >();

    public ArrayList<ArrayList<Integer> > listaPunktowTrasMorskich = new ArrayList<ArrayList<Integer>>();




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

    public void dodajLotniskaCywilne(){
        LotniskoCywilne lotnisko1 = new LotniskoCywilne(700,100,10,1, "Warszawa");
        LotniskoCywilne lotnisko2 = new LotniskoCywilne(1200,500,10,2, "Melbourne");
        LotniskoCywilne lotnisko3 = new LotniskoCywilne(300,100,10,3, "Toronto");
        LotniskoCywilne lotnisko4 = new LotniskoCywilne(400,500,10,4, "Buenos Aires");
        LotniskoCywilne lotnisko5 = new LotniskoCywilne(180,180,10,4, "Los Angeles");
        listaLotniskCywilnych.add(lotnisko1);
        listaLotniskCywilnych.add(lotnisko2);
        listaLotniskCywilnych.add(lotnisko3);
        listaLotniskCywilnych.add(lotnisko4);
        listaLotniskCywilnych.add(lotnisko5);
        listaNazwLotniskCywilnych.add("Warszawa");
        listaNazwLotniskCywilnych.add("Melbourne");
        listaNazwLotniskCywilnych.add("Toronto");
        listaNazwLotniskCywilnych.add("Buenos Aires");
        listaNazwLotniskCywilnych.add("Los Angeles");
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(700);
        list1.add(100);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(1200);
        list2.add(500);
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(300);
        list3.add(100);
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        list4.add(400);
        list4.add(500);
        ArrayList<Integer> list5 = new ArrayList<Integer>();
        list5.add(200);
        list5.add(200);
        listaKoordynatowLotniskCywilnych.add(list1);
        listaKoordynatowLotniskCywilnych.add(list2);
        listaKoordynatowLotniskCywilnych.add(list3);
        listaKoordynatowLotniskCywilnych.add(list4);
        listaKoordynatowLotniskCywilnych.add(list5);
    }

    public void dodajLotniskaWojskowe(){
        LotniskoWojskowe lotnisko1 = new LotniskoWojskowe(1100, 100, 10, 1, "Rakiety", "Chabarowsk");
        LotniskoWojskowe lotnisko2 = new LotniskoWojskowe(775, 100, 10, 1, "Bombowce", "Moskwa");
        LotniskoWojskowe lotnisko3 = new LotniskoWojskowe(1070, 150, 10, 1, "Bombowce", "Pekin");
        LotniskoWojskowe lotnisko4 = new LotniskoWojskowe(700, 500, 10, 1, "Bombowce", "Kapsztad");
        LotniskoWojskowe lotnisko5 = new LotniskoWojskowe(740, 200, 10, 1, "Bombowce", "Aleksandria");
        listaLotniskWojskowch.add(lotnisko1);
        listaLotniskWojskowch.add(lotnisko2);
        listaLotniskWojskowch.add(lotnisko3);
        listaLotniskWojskowch.add(lotnisko4);
        listaLotniskWojskowch.add(lotnisko5);
        listaNazwLotniskWojskowych.add("Chabarowsk");
        listaNazwLotniskWojskowych.add("Moskwa");
        listaNazwLotniskWojskowych.add("Pekin");
        listaNazwLotniskWojskowych.add("Kapsztad");
        listaNazwLotniskWojskowych.add("Aleksandria");
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1100);
        list1.add(100);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(775);
        list2.add(100);
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(1070);
        list3.add(150);
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        list4.add(700);
        list4.add(500);
        ArrayList<Integer> list5 = new ArrayList<Integer>();
        list5.add(740);
        list5.add(200);
        listaKoordynatowLotniskWojskowych.add(list1);
        listaKoordynatowLotniskWojskowych.add(list2);
        listaKoordynatowLotniskWojskowych.add(list3);
        listaKoordynatowLotniskWojskowych.add(list4);
        listaKoordynatowLotniskWojskowych.add(list5);
    }

    public void dodajTrasyMorskie(){
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(450);
        list1.add(500);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(850);
        list2.add(540);
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(1050);
        list3.add(300);
        listaKoordynatowLotniskWojskowych.add(list1);
        listaKoordynatowLotniskWojskowych.add(list2);
        listaKoordynatowLotniskWojskowych.add(list3);

    }


    public int obliczanieDlugosciTrasy(int startoweX, int startoweY, int koncoweX, int koncoweY){
        int trasa = (int) Math.sqrt((koncoweX - startoweX)^2 + (koncoweY - startoweY)^2);

        return trasa;

    }


}


