package de.htwberlin.daten_management_impl;


import de.htwberlin.daten_management_api.DatenService;
import de.htwberlin.daten_management_api.Lektion;
import de.htwberlin.daten_management_api.Vokabel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Implementierung des DatenService-Interfaces zur Erstellung von Lektionen aus Textdateien.
 */
public class DatenServiceImpl implements DatenService {

    /**
     * Erstellt eine Lektion aus einer Textdatei.
     *
     * @param dateiPfad Der Pfad zur Textdatei.
     * @return Eine Lektion, die aus der Textdatei erstellt wurde.
     * @throws IOException Wenn ein Fehler beim Lesen der Datei auftritt.
     */
    @Override
    public Lektion createLektion(String dateiPfad) throws IOException {
        validateFileExists(dateiPfad);


        List<Vokabel> vokabelListe = new ArrayList<>();
        String lektionsName = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(dateiPfad))) {
            String line = reader.readLine(); // Lese die erste Zeile für den Lektionsnamen

            // Überprüfe, ob die erste Zeile den Lektionsnamen enthält
            if (line != null && line.startsWith("{{{") && line.contains("}}}")) {
                // Extrahiere den Lektionsnamen, indem du nur das erste Set von geschweiften Klammern berücksichtigst
                int endOfLektionName = line.indexOf("}}}") + 3;
                lektionsName = line.substring(3, endOfLektionName - 3).trim(); // Entferne die letzten 3 Klammern

            } else {
                throw new IOException("Die erste Zeile enthält keinen Lektionsnamen.");
            }

            // Weitermachen mit dem Lesen der Vokabeln
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        List<String> englischeFormen = Arrays.asList(parts[0].trim().replaceAll("\\{|\\}", "").split(",\\s*"));
                        List<String> deutscheBedeutungen = Arrays.asList(parts[1].trim().replaceAll("\\{|\\}", "").split(",\\s*"));
                        // neues Vokabelobjekt wird für jede Zeile erstellt und zur Liste hinzugefügt
                        Vokabel vokabel = new Vokabel(englischeFormen, deutscheBedeutungen);
                        vokabelListe.add(vokabel);
                    }
                }
            }
        }

        // Wirft Exception, wenn nach dem Lesen der Datei kein Lektionsname oder keine Vokabeln vorhanden sind
        if (lektionsName == null || vokabelListe.isEmpty()) {
            throw new IOException("Die Lektion konnte nicht erstellt werden, da keine gültigen Daten gefunden wurden.");
        }

        return new Lektion(lektionsName, vokabelListe, dateiPfad);
    }



    /**
     * Überprüft, ob die angegebene Datei existiert.
     *
     * @param dateiPfad Der Pfad zur Datei.
     * @throws IOException Wenn die Datei nicht existiert, der Pfad leer ist oder keine .txt Endung besitzt.
     */
    private void validateFileExists(String dateiPfad) throws IOException {
        if (dateiPfad == null || dateiPfad.isEmpty() || !dateiPfad.endsWith(".txt")) {
            throw new IllegalArgumentException("Dateipfad darf nicht leer sein und muss mit '.txt' enden.");
        }

        Path filePath = Path.of(dateiPfad);

        if (!Files.exists(filePath)) {
            throw new IOException("Die Datei existiert nicht: " + dateiPfad);
        }
    }
}