package Klasy;

public class SamolotWojskowy extends Samolot {

    private int aktualnePaliwo;
    private int maksymalnePaliwo;
    private int maksymalnaPredkosc;
    private String trasa;
    private int aktualnePolozenieX;
    private int aktualnePolozenieY;
    private String miejsceLadowania;
    private int id;
    private String typUzbrojenia;
    private int docelowePolozenieX;
    private int docelowePolozenieY;

    public SamolotWojskowy(int aktualnePaliwo, int maksymalnePaliwo, int maksymalnaPredkosc, String trasa, int aktualnePolozenieX, int aktualnePolozenieY, String miejsceLadowania, int id, String typUzbrojenia, int docelowePolozenieX, int docelowePolozenieY) {
        this.aktualnePaliwo = aktualnePaliwo;
        this.maksymalnePaliwo = maksymalnePaliwo;
        this.maksymalnaPredkosc = maksymalnaPredkosc;
        this.trasa = trasa;
        this.aktualnePolozenieX = aktualnePolozenieX;
        this.aktualnePolozenieY = aktualnePolozenieY;
        this.miejsceLadowania = miejsceLadowania;
        this.id = id;
        this.typUzbrojenia = typUzbrojenia;
        this.docelowePolozenieX = docelowePolozenieX;
        this.docelowePolozenieY = docelowePolozenieY;
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

    public int getMaksymalnaPredkosc() {
        return maksymalnaPredkosc;
    }

    public void setMaksymalnaPredkosc(int maksymalnaPredkosc) {
        this.maksymalnaPredkosc = maksymalnaPredkosc;
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

    public String getTypUzbrojenia() {
        return typUzbrojenia;
    }

    public void setTypUzbrojenia(String typUzbrojenia) {
        this.typUzbrojenia = typUzbrojenia;
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

    public void startuj(){

    }

    public void laduj(){

    }

    public int tankuj(int akt_paliwo){
        int nowe_akt_paliwo = maksymalnePaliwo;
        System.out.println("Zatankowano do pełna!");
        return nowe_akt_paliwo;
    }

    public void zglosWade(){
        System.out.println("Wada Zgłoszona");
    }

    public void ladujAwaryjnie(){

    }

    public void zmienTrase(){

    }

    public static String wybierzUzbrojenie(){
        return "kkk";
    }
}
