package de.htwberlin.daten_management_api;

import java.util.List;

public class Lektion {
    private String lektionsName;
    private List<Vokabel> vokabelListe;
    private String dateiPfad; // Neue Variable für den Dateipfad

    public Lektion(String lektionsName, List<Vokabel> vokabelListe, String dateiPfad) {
        this.lektionsName = lektionsName;
        this.vokabelListe = vokabelListe;
        this.dateiPfad = dateiPfad;
    }
  //
    public String getLektionsName() {
        return lektionsName;
    }

    public void setLektionsName(String lektionsName) {
        this.lektionsName = lektionsName;
    }

    public List<Vokabel> getVokabelListe() {
        return vokabelListe;
    }

    public void setVokabelListe(List<Vokabel> vokabelListe) {
        this.vokabelListe = vokabelListe;
    }

    public String getDateiPfad() {
        return dateiPfad;
    }

    public void setDateiPfad(String dateiPfad) {
        this.dateiPfad = dateiPfad;
    }
}
