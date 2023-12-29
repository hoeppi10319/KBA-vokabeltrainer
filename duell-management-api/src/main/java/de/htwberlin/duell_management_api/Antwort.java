package de.htwberlin.duell_management_api;

import de.htwberlin.user_management_api.User;

import java.time.LocalDateTime;

public class Antwort {
    private Frage frage;
    private String antwortText;
    private boolean istRichtig;
    private LocalDateTime zeitstempel;
    private User spieler;
    private int punktzahl;

    public Antwort(Frage frage, String antwortText, boolean istRichtig, LocalDateTime zeitstempel, User spieler, int punktzahl) {
        this.frage = frage;
        this.antwortText = antwortText;
        this.istRichtig = istRichtig;
        this.zeitstempel = zeitstempel;
        this.spieler = spieler;
        this.punktzahl = punktzahl;
    }

    // Getter und Setter für die Eigenschaften
}
