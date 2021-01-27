package Klasy;

/**
 * Klasa Lotniska wojskowego wraz z getterami i setterami
 * Zawiera położenie x i y na mapie, akutalną ilość samolotów znajdujących się na lotnisku, maksymalną pojemność, id, typ uzbrojenia i miasto w jakim występuje
 */
public class LotniskoWojskowe extends Lotnisko{

    private int polozenieX;
    private int polozenieY;
    private int zapelnienie;
    private int pojemnosc;
    private int id;
    private String typUzbrojenia;
    private String miasto;

    public LotniskoWojskowe(int polozenieX, int polozenieY, int zapelnienie, int pojemnosc, int id, String typUzbrojenia, String miasto) {
        this.polozenieX = polozenieX;
        this.polozenieY = polozenieY;
        this.pojemnosc = pojemnosc;
        this.id = id;
        this.typUzbrojenia = typUzbrojenia;
        this.miasto = miasto;
        this.zapelnienie = zapelnienie;

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

    public int getZapelnienie() {
        return zapelnienie;
    }

    public void setZapelnienie(int zapelnienie) {
        this.zapelnienie = zapelnienie;
    }
}
