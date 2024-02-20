package cz.czechitas.ukol3.model;

public class Pocitac {
    private boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;

    public Pocitac() {
        this.jeZapnuty = false;
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

    public boolean jeZapnuty() {
        return jeZapnuty;
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

    public String toString() {
        return "Počítač - je zapnutý: " + jeZapnuty() + ", procesor - " + getCpu() + ", paměť - " + getRam() + ", disk - " + getPevnyDisk();
    }
}
