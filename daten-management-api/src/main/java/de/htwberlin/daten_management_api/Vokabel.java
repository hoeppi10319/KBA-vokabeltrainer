package de.htwberlin.daten_management_api;

import java.util.List;

public class Vokabel {
    private List<String> englischeFormen;
    private List<String> deutscheBedeutungen;

    public Vokabel(List<String> englischeFormen, List<String> deutscheBedeutungen) {
        this.englischeFormen = englischeFormen;
        this.deutscheBedeutungen = deutscheBedeutungen;
    }

    public List<String> getEnglischeFormen() {
        return englischeFormen;
    }

    public List<String> getDeutscheBedeutungen() {
        return deutscheBedeutungen;
    }
}
