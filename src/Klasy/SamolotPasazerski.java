package Klasy;


import Kontroler.Baza;
import Kontroler.ControllerView;
import Kontroler.Mapa;

import java.util.List;

/**
 * Klasa samolotu Pasażerskiego wraz z getterami i setterami
 * Klasa składa się z liczby pasażerów, maksymalnej prędkości, liczby personelu, aktualnego i maksymalnego stanu paliwa, trasy - lotniska z którego zaczyna lot, startowych wartości x i y, miejsca lądowania - lotnisko na którym ląduje, id i wartości x i y lotniska na którym ląduje
 * zawiera metodę tankuj zmieniającą stan akutalnego paliwa na stan maksymalnego paliwa
 */
public class SamolotPasazerski extends Samolot {

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
    private int docelowePolozenieX;
    private int docelowePolozenieY;

    public Baza baza;
    public ControllerView controllerView;
    public Mapa mapa;


    public SamolotPasazerski(int liczbaPasazerow, int maksymalnaPredkosc, int liczbaPersonelu, int aktualnePaliwo, int maksymalnePaliwo, String trasa, int aktualnePolozenieX, int aktualnePolozenieY, String miejsceLadowania, int id, int docelowePolozenieX, int docelowePolozenieY) {
        this.liczbaPasazerow = liczbaPasazerow;
        this.maksymalnaPredkosc = maksymalnaPredkosc;
        this.liczbaPersonelu = liczbaPersonelu;
        this.aktualnePaliwo = aktualnePaliwo;
        this.maksymalnePaliwo = maksymalnePaliwo;
        this.trasa = trasa;
        this.aktualnePolozenieX = aktualnePolozenieX;
        this.aktualnePolozenieY = aktualnePolozenieY;
        this.miejsceLadowania = miejsceLadowania;
        this.id = id;
        this.docelowePolozenieX = docelowePolozenieX;
        this.docelowePolozenieY = docelowePolozenieY;

    }

    public int getLiczbaPasazerow() {
        return liczbaPasazerow;
    }

    public void setLiczbaPasazerow(int liczbaPasazerow) {
        this.liczbaPasazerow = liczbaPasazerow;
    }

    public int getMaksymalnaPredkosc() {
        return maksymalnaPredkosc;
    }

    public void setMaksymalnaPredkosc(int maksymalnaPredkosc) {
        this.maksymalnaPredkosc = maksymalnaPredkosc;
    }

    public int getLiczbaPersonelu() {
        return liczbaPersonelu;
    }

    public void setLiczbaPersonelu(int liczbaPersonelu) {
        this.liczbaPersonelu = liczbaPersonelu;
    }

    public int getAktualnePaliwo() {
        return aktualnePaliwo;
    }

    public void setAktualnePaliwo(int aktualnePaliwo) {
        this.aktualnePaliwo = aktualnePaliwo;
    }

    public int getMaksymalnePaliwo() {
        return maksymalnePaliwo;
    }

    public void setMaksymalnePaliwo(int maksymalnePaliwo) {
        this.maksymalnePaliwo = maksymalnePaliwo;
    }

    public String getTrasa() {
        return trasa;
    }

    public void setTrasa(String trasa) {
        this.trasa = trasa;
    }

    public int getAktualnePolozenieX() {
        return aktualnePolozenieX;
    }

    public void setAktualnePolozenieX(int aktualnePolozenieX) {
        this.aktualnePolozenieX = aktualnePolozenieX;
    }

    public int getAktualnePolozenieY() {
        return aktualnePolozenieY;
    }

    public void setAktualnePolozenieY(int aktualnePolozenieY) {
        this.aktualnePolozenieY = aktualnePolozenieY;
    }

    public String getMiejsceLadowania() {
        return miejsceLadowania;
    }

    public void setMiejsceLadowania(String miejsceLadowania) {
        this.miejsceLadowania = miejsceLadowania;
    }

    public int getIdSamolotu() {
        return id;
    }

    public void setIdSamolotu(int id) {
        this.id = id;
    }

    public int getDocelowePolozenieX() {
        return docelowePolozenieX;
    }

    public void setDocelowePolozenieX(int docelowePolozenieX) {
        this.docelowePolozenieX = docelowePolozenieX;
    }

    public int getDocelowePolozenieY() {
        return docelowePolozenieY;
    }

    public void setDocelowePolozenieY(int docelowePolozenieY) {
        this.docelowePolozenieY = docelowePolozenieY;
    }

    //methods

    public int tankuj(int akt_paliwo){

        int nowe_akt_paliwo = maksymalnePaliwo;
        System.out.println("Zatankowano do pełna!");
        return nowe_akt_paliwo;

    }

}
