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

        Procesor mujProcesor = new Procesor();
        mujProcesor.setRychlost(2_000_000_000L);
        mujProcesor.setVyrobce("Dell");

        Pamet mojePamet = new Pamet();
        mojePamet.setKapacita(10_000_000_000L);

        Disk mujDisk = new Disk();
        mujDisk.setKapacita(499_000_000_000L);

        mujPocitac.setCpu(mujProcesor);
        mujPocitac.setRam(mojePamet);
        mujPocitac.setPevnyDisk(mujDisk);

        System.out.println(mujPocitac);

        mujPocitac.zapniSe();
        mujPocitac.zapniSe();      // Vypíše chybu, protože počítač už běží

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

        // třetí část
        System.out.println("--- Třetí část úkolu ---");
        Disk druhyDisk = new Disk();
        druhyDisk.setKapacita(199_000_000_000L);
        mujPocitac.setDruhyDisk(druhyDisk);
        System.out.println(mujPocitac);

        mujPocitac.zapniSe();
        mujPocitac.vytvorSouborOVelikosti(200_000_000_000L);
        mujPocitac.vytvorSouborOVelikosti(200_000_000_000L);
        System.out.println(mujPocitac); // Soubory budou uloženy pouze na prvním disku.

        mujPocitac.vytvorSouborOVelikosti(100_000_000_000L);
        System.out.println(mujPocitac); // Předchozí soubor se uložil na druhý disk.

        mujPocitac.vytvorSouborOVelikosti(1000); // Soubor se uloží na první disk, protože tam je ještě na něj místo.
        System.out.println(mujPocitac);

        mujPocitac.vymazSouboryOVelikosti(300_000_000_000L); // Soubor se smaže z prvního disku, protože není tolik vyuzitého místa na druhém disku.
        mujPocitac.vymazSouboryOVelikosti(999_999_999L); // Soubor se smaže z druhého disku.
        mujPocitac.vymazSouboryOVelikosti(222_222_222_222L); // Soubor nepůjde smazat.
        System.out.println(mujPocitac);

        mujPocitac.vypniSe();
    }

}
