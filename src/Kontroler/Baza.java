package Kontroler;

import Klasy.*;

import java.util.ArrayList;
import java.util.List;

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



    public void dodajLotniskaCywilne(){
        LotniskoCywilne lotnisko1 = new LotniskoCywilne(700,100,3,1, "Warszawa");
        LotniskoCywilne lotnisko2 = new LotniskoCywilne(1200,500,3,2, "Melbourne");
        LotniskoCywilne lotnisko3 = new LotniskoCywilne(300,100,3,3, "Toronto");
        LotniskoCywilne lotnisko4 = new LotniskoCywilne(400,500,3,4, "Buenos Aires");
        LotniskoCywilne lotnisko5 = new LotniskoCywilne(740,200,3,5, "Aleksandria");
        listaLotniskCywilnych.add(lotnisko1);
        listaLotniskCywilnych.add(lotnisko2);
        listaLotniskCywilnych.add(lotnisko3);
        listaLotniskCywilnych.add(lotnisko4);
        listaLotniskCywilnych.add(lotnisko5);
        listaNazwLotniskCywilnych.add("Warszawa");
        listaNazwLotniskCywilnych.add("Melbourne");
        listaNazwLotniskCywilnych.add("Toronto");
        listaNazwLotniskCywilnych.add("Buenos Aires");
        listaNazwLotniskCywilnych.add("Aleksandria");
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
        list5.add(740);
        list5.add(200);
        listaKoordynatowLotniskCywilnych.add(list1);
        listaKoordynatowLotniskCywilnych.add(list2);
        listaKoordynatowLotniskCywilnych.add(list3);
        listaKoordynatowLotniskCywilnych.add(list4);
        listaKoordynatowLotniskCywilnych.add(list5);
    }

    public void dodajLotniskaWojskowe(){
        LotniskoWojskowe lotnisko1 = new LotniskoWojskowe(1100, 100, 10, 1, "Rakiety", "Chabarowsk");
        LotniskoWojskowe lotnisko2 = new LotniskoWojskowe(775, 100, 10, 2, "Bombowce", "Moskwa");
        LotniskoWojskowe lotnisko3 = new LotniskoWojskowe(1070, 150, 10, 3, "Bombowce", "Pekin");
        LotniskoWojskowe lotnisko4 = new LotniskoWojskowe(700, 500, 10, 4, "Bombowce", "Kapsztad");
        LotniskoWojskowe lotnisko5 = new LotniskoWojskowe(180, 180, 10, 5, "Bombowce", "Los Angeles");
        listaLotniskWojskowch.add(lotnisko1);
        listaLotniskWojskowch.add(lotnisko2);
        listaLotniskWojskowch.add(lotnisko3);
        listaLotniskWojskowch.add(lotnisko4);
        listaLotniskWojskowch.add(lotnisko5);
        listaNazwLotniskWojskowych.add("Chabarowsk");
        listaNazwLotniskWojskowych.add("Moskwa");
        listaNazwLotniskWojskowych.add("Pekin");
        listaNazwLotniskWojskowych.add("Kapsztad");
        listaNazwLotniskWojskowych.add("Los Angeles");
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
        list5.add(180);
        list5.add(180);
        listaKoordynatowLotniskWojskowych.add(list1);
        listaKoordynatowLotniskWojskowych.add(list2);
        listaKoordynatowLotniskWojskowych.add(list3);
        listaKoordynatowLotniskWojskowych.add(list4);
        listaKoordynatowLotniskWojskowych.add(list5);
    }

    public void dodajTrasyMorskie(){
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(400);
        list1.add(170);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(430);
        list2.add(330);
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(500);
        list3.add(390);
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        list4.add(430);
        list4.add(550);
        ArrayList<Integer> list5 = new ArrayList<Integer>();
        list5.add(950);
        list5.add(560);
        ArrayList<Integer> list6 = new ArrayList<Integer>();
        list6.add(1090);
        list6.add(490);
        ArrayList<Integer> list7 = new ArrayList<Integer>();
        list7.add(1020);
        list7.add(340);
        ArrayList<Integer> list8 = new ArrayList<Integer>();
        list8.add(850);
        list8.add(350);
        ArrayList<Integer> list9 = new ArrayList<Integer>();
        list9.add(890);
        list9.add(490);
        ArrayList<Integer> list10 = new ArrayList<Integer>();
        list10.add(740);
        list10.add(550);
        ArrayList<Integer> list11 = new ArrayList<Integer>();
        list11.add(650);
        list11.add(510);
        ArrayList<Integer> list12 = new ArrayList<Integer>();
        list12.add(580);
        list12.add(350);
        ArrayList<Integer> list13 = new ArrayList<Integer>();
        list13.add(530);
        list13.add(270);
        ArrayList<Integer> list14 = new ArrayList<Integer>();
        list14.add(600);
        list14.add(130);

        listaPunktowTrasMorskich.add(list1);
        listaPunktowTrasMorskich.add(list2);
        listaPunktowTrasMorskich.add(list3);
        listaPunktowTrasMorskich.add(list4);
        listaPunktowTrasMorskich.add(list5);
        listaPunktowTrasMorskich.add(list6);
        listaPunktowTrasMorskich.add(list7);
        listaPunktowTrasMorskich.add(list8);
        listaPunktowTrasMorskich.add(list9);
        listaPunktowTrasMorskich.add(list10);
        listaPunktowTrasMorskich.add(list11);
        listaPunktowTrasMorskich.add(list12);
        listaPunktowTrasMorskich.add(list13);
        listaPunktowTrasMorskich.add(list14);



    }


    public int obliczanieDlugosciTrasy(int startoweX, int startoweY, int koncoweX, int koncoweY){
        int trasa = (int) Math.sqrt(Math.pow((koncoweX - startoweX),2) + Math.pow((koncoweY - startoweY),2));
        return trasa;

    }

    public void wyswietlInfoPasazerski(int startoweX, int startoweY, SamolotPasazerski samolotPasazerski) {
        int aktualneX = samolotPasazerski.getAktualnePolozenieX();
        int aktualneY = samolotPasazerski.getAktualnePolozenieY();
        if (startoweX == aktualneX && startoweY == aktualneY) {
            int Id = samolotPasazerski.getIdSamolotu();
            int liczbaPasazerow = samolotPasazerski.getLiczbaPasazerow();
            int liczbaPersonelu = samolotPasazerski.getLiczbaPersonelu();
            int aktualnePaliwo = samolotPasazerski.getAktualnePaliwo();
            int maksymalnePaliwo = samolotPasazerski.getMaksymalnePaliwo();
            System.out.println("Samolot Pasażerski nr " + Id + " z " + liczbaPasazerow + " pasażerami i personelem liczącym " + liczbaPersonelu + " doleciał na miejsce. Podczas podróży nikt nie zginął :)\nPaliwo po zakończeniu podróży " + aktualnePaliwo + " Maksymalna pojemność paliwa " + maksymalnePaliwo + "\nWymiana pasażerów, personelu i tankowanie");
        }
    }

    public void wyswietlInfoWojskowy(int startoweX, int startoweY, SamolotWojskowy samolotWojskowy){
            int aktualneX = samolotWojskowy.getAktualnePolozenieX();
            int aktualneY = samolotWojskowy.getAktualnePolozenieY();
            if (startoweX == aktualneX && startoweY == aktualneY){
                int Id = samolotWojskowy.getIdSamolotu();
                String typUzbrojenia = samolotWojskowy.getTypUzbrojenia();
                int aktualnePaliwo = samolotWojskowy.getAktualnePaliwo();
                System.out.println("Samolot Wojskowy nr " + Id + " typu uzbrojenia - " + typUzbrojenia + " doleciał na miejsce. Podczas podróży nikt nie zginął :)\nPaliwo po zakończeniu podróży " + aktualnePaliwo +"\nWymiana pasażerów, personelu i tankowanie");

            }
    }



}


