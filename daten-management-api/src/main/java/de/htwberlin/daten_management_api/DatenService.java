package de.htwberlin.daten_management_api;

import java.io.IOException;

/**
 * Eine Schnittstelle für das User-management.
 * Diese Schnittstelle definiert Methoden zur Erzeugung von Usern.
 */
public interface DatenService {

    /**
     * Erzeugt eine neue Lektion aus der übergebenen Datei.
     *
     * @param dateiPfad Der Pfad der Lektionsdatei.
     * @return Ein Lektion-Objekt aus einer eingelesenen Datei.
     * @throws IOException ein Fehler beim Einlesen der Lektion entsteht.
     */
    Lektion createLektion(String dateiPfad) throws IOException;
}
