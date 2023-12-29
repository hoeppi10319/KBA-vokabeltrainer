package de.htwberlin.daten_management_impl;

import de.htwberlin.daten_management_api.Lektion;
import de.htwberlin.daten_management_api.Vokabel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DatenServiceImplTest {

    private DatenServiceImpl datenManagement;

    @BeforeEach
    void setUp() {
        datenManagement = new DatenServiceImpl();
    }

    @TempDir
    static Path tempDir;

    @Test
    void testCreateLektionWithValidFile() throws IOException {
        // Erstelle eine temporäre Testdatei mit gültigem Inhalt
        Path testFile = tempDir.resolve("validUnit.txt");
        List<String> lines = List.of(
                "{{{Unit 1 This is London - Part A}}}",
                "word1:Wort1",
                "word2:Wort2",
                "phrase1:Ausdruck1"
        );
        Files.write(testFile, lines);

        // Erstelle eine Instanz von DatenManagement oder verwende eine bestehende


        // Versuche eine Lektion aus der Testdatei zu erstellen
        Lektion lektion = datenManagement.createLektion(testFile.toString());

        // Überprüfe, ob die Lektion korrekt erstellt wurde
        assertNotNull(lektion, "Die Lektion sollte nicht null sein.");
        assertEquals("Unit 1 This is London - Part A", lektion.getLektionsName(), "Der Lektionsname stimmt nicht überein.");
        List<Vokabel> vokabelListe = lektion.getVokabelListe();
        assertNotNull(vokabelListe, "Die Vokabelliste sollte nicht null sein.");
        assertEquals(3, vokabelListe.size(), "Die Anzahl der Vokabeln sollte 3 sein.");
        assertEquals("word1", vokabelListe.get(0).getEnglischeFormen().get(0), "Die englische Form der ersten Vokabel sollte 'word1' sein.");
        assertEquals("Wort1", vokabelListe.get(0).getDeutscheBedeutungen().get(0), "Die deutsche Bedeutung der ersten Vokabel sollte 'Wort1' sein.");
    }



    @Test
    void testCreateLektionWithNonexistentFile() {
        // Versuche eine Lektion aus einer nicht existierenden Datei zu erstellen
        assertThrows(IOException.class, () -> datenManagement.createLektion("nonexistent_file.txt"));
    }

    @Test
    void testCreateLektionWithInvalidFile() throws IOException {
        // Erstelle eine temporäre Testdatei mit ungültigem Inhalt
        Path testFile = Files.createFile(tempDir.resolve("invalid_test_file.txt"));
        String content = "Invalid Content";
        Files.write(testFile, content.getBytes());

        // Versuche eine Lektion aus der Testdatei zu erstellen
        assertThrows(IOException.class, () -> datenManagement.createLektion(testFile.toString()));
    }

    @Test
    public void testCreateLektionWithEmptyFile() throws IOException {
        // Erstelle eine temporäre leere Testdatei
        Path testFile = Files.createFile(tempDir.resolve("empty_test_file.txt"));

        try {
            // Versuche eine Lektion aus der leeren Testdatei zu erstellen
            datenManagement.createLektion(testFile.toString());
        } catch (IOException e) {
            // Die Methode sollte eine IOException auslösen, was in diesem Fall erfolgreich ist
        }
    }


}