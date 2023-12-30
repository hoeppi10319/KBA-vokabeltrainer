package de.htwberlin.configuration;

import de.htwberlin.daten_management_api.DatenService;
import de.htwberlin.daten_management_api.Lektion;
import de.htwberlin.daten_management_impl.DatenServiceImpl;
import de.htwberlin.duell_management_api.DuellService;
import de.htwberlin.duell_management_api.Spielsession;
import de.htwberlin.user_management_api.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Configuration
public class ConfigurationSpringAnnotation {

    @Bean
    public DuellService duellService() {
        return new DuellService() {
            @Override
            public Spielsession starteDuell(User spieler1, User spieler2, Lektion lektion) {
                return new Spielsession(spieler1, spieler2, lektion);
            }
        };
    }

    @Bean
    public Lektion lektion() throws IOException {
        DatenService datenService = new DatenServiceImpl();
        return datenService.createLektion("C:\\Users\\paulm\\IdeaProjects\\kba_final\\daten-management-impl\\src\\main\\resources\\resources\\vocabulary\\Unit 1 This is London - Part A.txt");

    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpringAnnotation.class);

        DuellService duellService = context.getBean(DuellService.class);
        Lektion lektion = context.getBean(Lektion.class);

        User user1 = new User("Peter");
        User user2 = new User("Paul");

        Spielsession spielsession = duellService.starteDuell(user1, user2, lektion);
    }
}
