package de.htwberlin.duell_management_api;

import de.htwberlin.daten_management_api.Lektion;
import de.htwberlin.user_management_api.User;

import java.util.List;

public class Spielsession {
    private List<Frage> fragen;
    private int aktuelleFrageIndex;
    private User spieler1;
    private User spieler2;
    private Lektion lektion;

    public Spielsession(User spieler1, User spieler2, Lektion lektion) {
        this.spieler1 = spieler1;
        this.spieler2 = spieler2;
        this.lektion = lektion;
        this.fragen = erstelleFragen(lektion);
        this.aktuelleFrageIndex = 0;
    }

    private List<Frage> erstelleFragen(Lektion lektion) {
        return null;
    }

    // Weitere Methoden zur Steuerung des Spiels hier
}
