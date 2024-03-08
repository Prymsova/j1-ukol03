package cz.czechitas.ukol3.model;

public class Disk {
    private long kapacita;
    private long vyuziteMisto;

    public long getKapacita() {
        return kapacita;
    }

    public void setKapacita(long kapacita) {
        this.kapacita = kapacita;
    }

    public long getVyuziteMisto() {
        return vyuziteMisto;
    }

    public void setVyuziteMisto(long vyuziteMisto) {
        if (vyuziteMisto > kapacita) {
            System.err.println("Na disku není dost místa pro vytvoření souboru.");
            return;
        } else if (vyuziteMisto < 0) {
            System.err.println("Soubor není možné vymazat, došlo k nějaké chybě a využité místo by po smazání bylo menší než nula:-)");
            return;
        }
        this.vyuziteMisto = vyuziteMisto;
    }

    public String toString() {
        return "kapacita: " + getKapacita() + " bajtů, vyuziteMisto: " + getVyuziteMisto() + " bajtů";
    }
}
