package de.htwberlin.user_management_api;

public class Statistik {
    private int gesamtSpiele;
    private int gewonneneSpiele;
    private int verloreneSpiele;

    public Statistik() {
        this.gesamtSpiele = 0;
        this.gewonneneSpiele = 0;
        this.verloreneSpiele = 0;
    }

    public void spielGewonnen() {
        gesamtSpiele++;
        gewonneneSpiele++;
    }

    public void spielVerloren() {
        gesamtSpiele++;
        verloreneSpiele++;
    }

    public int getGesamtSpiele() {
        return gesamtSpiele;
    }

    public int getGewonneneSpiele() {
        return gewonneneSpiele;
    }

    public int getVerloreneSpiele() {
        return verloreneSpiele;
    }
}
