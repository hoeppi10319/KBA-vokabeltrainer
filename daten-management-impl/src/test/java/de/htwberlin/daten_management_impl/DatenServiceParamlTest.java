package de.htwberlin.daten_management_impl;

import de.htwberlin.daten_management_api.DatenService;
import de.htwberlin.daten_management_api.Lektion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DatenServiceParamlTest {

    private DatenService datenService;
    // Pfad zum Testdateiverzeichnis, angepasst an das Betriebssystem
    private static final String TEST_FILE_DIR = Paths.get(System.getProperty("user.dir"), "src", "main", "resources","resources", "vocabulary") + File.separator;



    @BeforeEach
    public void setUp() {
        datenService = new DatenServiceImpl();
    }

    private static Stream<String> validDateiPfade() {
        return Stream.of(
                TEST_FILE_DIR + "body.txt",
                TEST_FILE_DIR + "clothes.txt",
                TEST_FILE_DIR + "time.txt"
        );
    }

    private static Stream<String> invalidDateiPfade() {
        return Stream.of(null, "", "Unit1", "   ");
    }

    @ParameterizedTest
    @MethodSource("validDateiPfade")
    public void testCreateLektionWithValidDateiPfad(String validDateiPfad) throws IOException {
        Lektion lektion = datenService.createLektion(validDateiPfad);
        assertNotNull(lektion);
        assertEquals(validDateiPfad, lektion.getDateiPfad());
    }

    @ParameterizedTest
    @MethodSource("invalidDateiPfade")
    public void testCreateLektionWithInvalidDateiPfad(String invalidDateiPfad) {
        assertThrows(IllegalArgumentException.class, () -> datenService.createLektion(invalidDateiPfad));
    }

}