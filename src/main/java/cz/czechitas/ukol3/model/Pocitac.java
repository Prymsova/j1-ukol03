package cz.czechitas.ukol3.model;

public class Pocitac {
    private boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;
    private Disk druhyDisk;

    public Pocitac() {
        this.jeZapnuty = false;
    }

    public boolean jeZapnuty() {
        return jeZapnuty;
    }

    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Pamet getRam() {
        return ram;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    public Disk getDruhyDisk() {
        return druhyDisk;
    }

    public void setDruhyDisk(Disk druhyDisk) {
        this.druhyDisk = druhyDisk;
    }

    public void zapniSe() {
        if (jeZapnuty()) {
            System.err.println("Počítač je již zapnutý.");
            return;
        }
        if (cpu == null || ram == null || pevnyDisk == null) {
            System.err.println("Počítači chybí nějaké součástky, počítač nelze zapnout.");
            return;
        }
        jeZapnuty = true;
        System.out.println("Počítač se zapnul.");
    }

    public void vypniSe() {
        if (!jeZapnuty()) {
            return;
        }
        jeZapnuty = false;
        System.out.println("Počítač se vypnul.");
    }

    public void vytvorSouborOVelikosti(long velikost) {
        if (jeZapnuty) {
            if (pevnyDisk.getVyuziteMisto() + velikost <= pevnyDisk.getKapacita()) {
                pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() + velikost);
                System.out.println("--- ULOZIME NA PRVNI DISK ---");
            } else if (druhyDisk != null) {
                druhyDisk.setVyuziteMisto(druhyDisk.getVyuziteMisto() + velikost);
                System.out.println("--- ULOZIME NA DRUHY DISK ---");
            } else {
                pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() + velikost);
                System.out.println("--- NENI DRUHY DISK, POKUSI SE ULOZIT NA PRVNI DISK ---");
            }
        } else {
            System.err.println("Počítač není zapnutý a nelze vytvořit soubor.");
        }
    }

    public void vymazSouboryOVelikosti(long velikost) {
        if (jeZapnuty) {
            if (druhyDisk != null && druhyDisk.getVyuziteMisto() - velikost >= 0) {
                druhyDisk.setVyuziteMisto(druhyDisk.getVyuziteMisto() - velikost);
                System.out.println("--- SOUBOR SE SMAZE PREDNOSTNE Z DRUHEHO DISKU");
            } else {
                pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() - velikost);
                System.out.println("--- SOUBOR SE POKUSI SMAZAT Z PRVNIHO DISKU, ANEBO VYPISE CHYBU, protože není dost využitého místa ani na jednom disku jako je velikost souboru ke smazání ---");
            }
        } else {
            System.err.println("Počítač není zapnutý a nelze smazat soubor.");
        }
    }

    public String toString() {
        return "Počítač - je zapnutý: " + jeZapnuty() + ", procesor - " + getCpu() + ", paměť - " + getRam() + ", disk - " + getPevnyDisk() + ", druhý disk - " + getDruhyDisk();
    }
}
