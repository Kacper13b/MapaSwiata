package Klasy;
import Kontroler.*;

public abstract class Samolot extends Thread {

    public abstract void startuj();

    public abstract void laduj();

    public abstract int tankuj(int paliwo);

    public abstract void zglosWade();

    public abstract void ladujAwaryjnie();

    public abstract void zmienTrase();


}
