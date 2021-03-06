package Klasy;

/**
 * Klasa Lotniskowca wraz z getterami i setterami
 * Obiekt składa się z maksymalnej prędkości, akutalnych współrzędnych x i y, id, i typu uzbrojenia samolotów wojskowych które produkuje
 */

public class Lotniskowiec extends Statek {

    private int maksymalnaPredkosc;
    private int aktualnePolozenieX;
    private int aktualnePolozenieY;
    private int id;
    private String typUzbrojenia;


    public Lotniskowiec(int maksymalnaPredkosc, int aktualnePolozenieX, int aktualnePolozenieY, int id, String typUzbrojenia) {
        this.maksymalnaPredkosc = maksymalnaPredkosc;
        this.aktualnePolozenieX = aktualnePolozenieX;
        this.aktualnePolozenieY = aktualnePolozenieY;
        this.id = id;
        this.typUzbrojenia = typUzbrojenia;
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

    public int getId2() {
        return id;
    }

    public void setId2(int id) {
        this.id = id;
    }

    public String getTypUzbrojenia() {
        return typUzbrojenia;
    }

    public void setTypUzbrojenia(String typUzbrojenia) {
        this.typUzbrojenia = typUzbrojenia;
    }


}
