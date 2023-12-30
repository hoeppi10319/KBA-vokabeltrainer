package de.htwberlin;

import de.htwberlin.configuration.ConfigurationSpringAnnotation;
import de.htwberlin.duell_management_api.DuellService;
import de.htwberlin.daten_management_api.Lektion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationSpringAnnotationTest {

    @Test
    void testBeansCreation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpringAnnotation.class);

        DuellService duellService = context.getBean(DuellService.class);
        Assertions.assertNotNull(duellService, "DuellService sollte nicht null sein");

        Lektion lektion;
        try {
            lektion = context.getBean(Lektion.class);
            assertNotNull(lektion, "Lektion sollte nicht null sein");
        } catch (Exception e) {
            fail("Lektion konnte nicht erstellt werden: " + e.getMessage());
        }
    }
}
