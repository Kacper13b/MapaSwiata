package Klasy;

public class StatekCywilny extends Statek {

    private int maksymalnaPojemnosc;
    private int liczbaPasazerow;
    private String firma;
    private int maksymalnaPredkosc;
    private int aktualnePolozenieX;
    private int aktualnePolozenieY;
    private int id;


    public StatekCywilny(int maksymalnaPojemnosc, int liczbaPasazerow, String firma, int maksymalnaPredkosc, int aktualnePolozenieX, int aktualnePolozenieY, int id) {
        this.maksymalnaPojemnosc = maksymalnaPojemnosc;
        this.liczbaPasazerow = liczbaPasazerow;
        this.firma = firma;
        this.maksymalnaPredkosc = maksymalnaPredkosc;
        this.aktualnePolozenieX = aktualnePolozenieX;
        this.aktualnePolozenieY = aktualnePolozenieY;
        this.id = id;
    }

    public int getMaksymalnaPojemnosc() {
        return maksymalnaPojemnosc;
    }

    public void setMaksymalnaPojemnosc(int maksymalnaPojemnosc) {
        this.maksymalnaPojemnosc = maksymalnaPojemnosc;
    }

    public int getLiczbaPasazerow() {
        return liczbaPasazerow;
    }

    public void setLiczbaPasazerow(int liczbaPasazerow) {
        this.liczbaPasazerow = liczbaPasazerow;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public int getMaksymalnaPredkosc() {
        return maksymalnaPredkosc;
    }

    public void setMaksymalnaPredkosc(int maksymalnaPredkosc) {
        this.maksymalnaPredkosc = maksymalnaPredkosc;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //methods

    public void plynDo(){

    }

    public void zmianaTrasy(){

    }
}
