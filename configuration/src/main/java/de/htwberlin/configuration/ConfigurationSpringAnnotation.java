package de.htwberlin.configuration;


import de.htwberlin.daten_management_api.Lektion;
import de.htwberlin.duell_management_api.DuellService;
import de.htwberlin.duell_management_api.Spielsession;
import de.htwberlin.user_management_api.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSpringAnnotation {

    @Bean
    public DuellService duellService() {
        return new DuellService() {
            @Override
            public Spielsession starteDuell(User spieler1, User spieler2, Lektion lektion) {
                return null;
            }
        };
    }

    ;

    public static void main(String[] args) {
        // Initialize Spring Application Context
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpringAnnotation.class);

        // Retrieve the DuellService bean
        DuellService duellService = context.getBean(DuellService.class);

        // Example usage of duellService
        User user1 = new User("Peter"); // Replace with actual user creation/logic
        User user2 = new User("Paul"); // Replace with actual user creation/logic
      //  Lektion lektion = new Lektion("Unit 1"); // Replace with actual lektion creation/logic

      //  Spielsession spielsession = duellService.starteDuell(user1, user2);

        // Add your application logic here
        // For example, you can interact with 'spielsession' as needed
    }


}
