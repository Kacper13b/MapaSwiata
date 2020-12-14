package Pojazdy;

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


    public SamolotPasazerski(int liczbaPasazerow, int maksymalnaPredkosc, int liczbaPersonelu, int aktualnePaliwo, int maksymalnePaliwo, String trasa, int aktualnePolozenieX, int aktualnePolozenieY, String miejsceLadowania, int id) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    //methods

    public void startuj(){

    }

    public void laduj(){

    }

    public int tankuj(int akt_paliwo){

        return maksymalnePaliwo;
    }

    public void zglosWade(){

    }

    public void ladujAwaryjnie(){

    }

    public void zmienTrase(){

    }

    public void zmienPasazerow(){

    }
}
