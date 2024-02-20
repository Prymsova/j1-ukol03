package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Disk;
import cz.czechitas.ukol3.model.Pamet;
import cz.czechitas.ukol3.model.Pocitac;
import cz.czechitas.ukol3.model.Procesor;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
        //TODO tady bude váš kód - vytvoření instance třídy Pocitac, zapnutí, vpynutí, výpis hodnot.
        System.out.println("Program spuštěn.");

        Pocitac mujPocitac = new Pocitac();
        System.out.println(mujPocitac);
        mujPocitac.zapniSe();      // Vypíše chybu, protože počítač v tuto chvíli nemá všechny povinné součásti.

        Procesor filipuvProcesor = new Procesor();
        filipuvProcesor.setRychlost(2_000_000_000L);
        filipuvProcesor.setVyrobce("Dell");

        Pamet filipovaPamet = new Pamet();
        filipovaPamet.setKapacita(10_000_000_000L);

        Disk filipuvDisk = new Disk();
        filipuvDisk.setKapacita(499_000_000_000L);

        mujPocitac.setCpu(filipuvProcesor);
        mujPocitac.setRam(filipovaPamet);
        mujPocitac.setPevnyDisk(filipuvDisk);

        System.out.println(mujPocitac);

        mujPocitac.zapniSe();
        mujPocitac.zapniSe();      // Vypíše chybu, protože počítač už běží
        System.out.println(mujPocitac);
        mujPocitac.vypniSe();

        mujPocitac.vypniSe();      // Nevypíše chybu, ale nic neprovede, protože počítač už je vypnutý

        // druhá část úkolu
        System.out.println("--- Druhá část úkolu ---");
        mujPocitac.zapniSe();
        mujPocitac.vytvorSouborOVelikosti(300000000000000L); // Vypíše chybu, že soubor je větší než kapacita.
        mujPocitac.vytvorSouborOVelikosti(3000); // Soubor půjde vytvořit.
        mujPocitac.vytvorSouborOVelikosti(30300); // Soubor půjde vytvořit.
        System.out.println(mujPocitac.getPevnyDisk().getVyuziteMisto()); // Vypíše velikost využitého místa.

        mujPocitac.vypniSe();
        mujPocitac.vymazSouboryOVelikosti(11100); // Soubor nepůjde smazat, protože je počítač vypnutý.

        mujPocitac.zapniSe();
        mujPocitac.vymazSouboryOVelikosti(11100); // Smaže soubor.
        System.out.println(mujPocitac.getPevnyDisk().getVyuziteMisto()); // Vypíše velikost využitého místa.
        mujPocitac.vymazSouboryOVelikosti(1110000000); // Vypíše chybu, že soubor nelze smazat.

        mujPocitac.vypniSe();
    }

}
