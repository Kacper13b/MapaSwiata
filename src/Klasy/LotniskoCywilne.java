package Klasy;

public class LotniskoCywilne extends Lotnisko{

    private int polozenieX;
    private int polozenieY;
    private int pojemnosc;
    private int id;
    private String miasto;

    public LotniskoCywilne(int polozenieX, int polozenieY, int pojemnosc, int id, String miasto) {
        this.polozenieX = polozenieX;
        this.polozenieY = polozenieY;
        this.pojemnosc = pojemnosc;
        this.id = id;
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

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }



}
