import Pojazdy.SamolotPasazerski;
import Pojazdy.SamolotWojskowy;
import Pojazdy.Lotniskowiec;
import Pojazdy.StatekCywilny;

import java.util.HashMap;

public class Baza {
    HashMap<Integer, SamolotPasazerski> SamolotyPasazerskie = new HashMap<>();
    HashMap<Integer, SamolotWojskowy> SamolotyWojskowe = new HashMap<>();
    HashMap<Integer, StatekCywilny> StatkiCywilne = new HashMap<>();
    HashMap<Integer, Lotniskowiec>Lotniskowce = new HashMap<>();

    public Baza(HashMap<Integer, SamolotPasazerski> samoloty_pasazerskie, HashMap<Integer, SamolotWojskowy> samoloty_wojskowe, HashMap<Integer, StatekCywilny> statki_cywilne, HashMap<Integer, Lotniskowiec> lotniskowce) {
        SamolotyPasazerskie = samoloty_pasazerskie;
        SamolotyWojskowe = samoloty_wojskowe;
        StatkiCywilne = statki_cywilne;
        Lotniskowce = lotniskowce;
    }

    public HashMap<Integer, SamolotPasazerski> getSamolotyPasazerskie() {
        return SamolotyPasazerskie;
    }

    public void setSamolotyPasazerskie(HashMap<Integer, SamolotPasazerski> samolotyPasazerskie) {
        SamolotyPasazerskie = samolotyPasazerskie;
    }

    public HashMap<Integer, SamolotWojskowy> getSamolotyWojskowe() {
        return SamolotyWojskowe;
    }

    public void setSamolotyWojskowe(HashMap<Integer, SamolotWojskowy> samolotyWojskowe) {
        SamolotyWojskowe = samolotyWojskowe;
    }

    public HashMap<Integer, StatekCywilny> getStatkiCywilne() {
        return StatkiCywilne;
    }

    public void setStatkiCywilne(HashMap<Integer, StatekCywilny> statkiCywilne) {
        StatkiCywilne = statkiCywilne;
    }

    public HashMap<Integer, Lotniskowiec> getLotniskowce() {
        return Lotniskowce;
    }

    public void setLotniskowce(HashMap<Integer, Lotniskowiec> lotniskowce) {
        Lotniskowce = lotniskowce;
    }

    //generate

    public static void stworzPasazerski(){

    }

    public static void stworzWojskowy(){

    }

    public static void stworzCywilny(){

    }

    public static void stworzLotniskowiec(){

    }

    public static void wyswietlInfo(){

    }

    public static void usun(){

    }

    public static void wywolajAwarie(){

    }

}
