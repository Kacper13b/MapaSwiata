package Klasy;

/**
 * Klasa abstrakcyjna samolotu, jedyna metoda tankuj - do tankowania samolotu
 */
public abstract class Samolot extends Thread {

    public abstract int tankuj(int paliwo);

}
