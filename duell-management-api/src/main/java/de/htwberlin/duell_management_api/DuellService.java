package de.htwberlin.duell_management_api;

import de.htwberlin.daten_management_api.Lektion;
import de.htwberlin.user_management_api.User;

/**
 * Eine Schnittstelle für das Duell-management.
 * Diese Schnittstelle definiert Methoden zur Erzeugung von Spielsessions.
 */
public interface DuellService {

    /**
     * Erzeugt eine neue Spielsession mit angegebenen Usern und Lektion.
     *
     * @param spieler1 Der Name des ersten Users für die Spielsession.
     * @param spieler2 Der Name des ersten Users für die Spielsession.
     * @param lektion Die lektion für die Spielsession.
     * @return Ein Spielsession-Objekt mit gewählten Usern und Lektion.
     */
    Spielsession starteDuell(User spieler1, User spieler2, Lektion lektion);
}

