package Klasy;

public class LotniskoWojskowe extends Lotnisko{

    private int polozenieX;
    private int polozenieY;
    private int pojemnosc;
    private int id;
    private String typUzbrojenia;
    private String miasto;

    public LotniskoWojskowe(int polozenieX, int polozenieY, int pojemnosc, int id, String typUzbrojenia, String miasto) {
        this.polozenieX = polozenieX;
        this.polozenieY = polozenieY;
        this.pojemnosc = pojemnosc;
        this.id = id;
        this.typUzbrojenia = typUzbrojenia;
        this.miasto = miasto;

    }

    public int getPolozenieX() {
        return polozenieX;
    }

    public void setPolozenieX(int polozenieX) {
        this.polozenieX = polozenieX;
    }

    public int getPolozenieY() {
        return polozenieY;
    }

    public void setPolozenieY(int polozenieY) {
        this.polozenieY = polozenieY;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
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

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }
}
