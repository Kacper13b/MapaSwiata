package Klasy;

public class LotniskoWojskowe extends Lotnisko{

    private int polozenieX;
    private int polozenieY;
    private int pojemnosc;
    private int id;
    private String typUzbrojenia;

    public LotniskoWojskowe(int polozenieX, int polozenieY, int pojemnosc, int id, String typUzbrojenia) {
        this.polozenieX = polozenieX;
        this.polozenieY = polozenieY;
        this.pojemnosc = pojemnosc;
        this.id = id;
        this.typUzbrojenia = typUzbrojenia;

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
}