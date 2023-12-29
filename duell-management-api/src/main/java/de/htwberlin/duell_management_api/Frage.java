package de.htwberlin.duell_management_api;


import de.htwberlin.daten_management_api.Vokabel;

import java.util.List;

public class Frage {
    private Vokabel vokabel;
    private List<String> antworten;
    private String richtigeAntwort;

    public Frage(Vokabel vokabel, List<String> antworten, String richtigeAntwort) {
        this.vokabel = vokabel;
        this.antworten = antworten;
        this.richtigeAntwort = richtigeAntwort;
    }

    public Vokabel getVokabel() {
        return vokabel;
    }

    public List<String> getAntworten() {
        return antworten;
    }

    public String getRichtigeAntwort() {
        return richtigeAntwort;
    }
}
