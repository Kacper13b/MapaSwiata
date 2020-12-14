package Pojazdy;

public class SamolotWojskowy extends Samolot {

    private int aktualnePaliwo;
    private int maksymalnePaliwo;
    private String trasa;
    private int aktualnePolozenieX;
    private int aktualnePolozenieY;
    private String miejsceLadowania;
    private int id;
    private String typUzbrojenia;

    public SamolotWojskowy(int aktualnePaliwo, int maksymalnePaliwo, String trasa, int aktualnePolozenieX, int aktualnePolozenieY, String miejsceLadowania, int id, String typUzbrojenia) {
        this.aktualnePaliwo = aktualnePaliwo;
        this.maksymalnePaliwo = maksymalnePaliwo;
        this.trasa = trasa;
        this.aktualnePolozenieX = aktualnePolozenieX;
        this.aktualnePolozenieY = aktualnePolozenieY;
        this.miejsceLadowania = miejsceLadowania;
        this.id = id;
        this.typUzbrojenia = typUzbrojenia;
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

    public String getTypUzbrojenia() {
        return typUzbrojenia;
    }

    public void setTypUzbrojenia(String typUzbrojenia) {
        this.typUzbrojenia = typUzbrojenia;
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

    public static String wybierzUzbrojenie(){
        return "kkk";
    }
}
