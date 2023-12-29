package de.htwberlin.duell_ui_impl;

import java.util.Scanner;

import de.htwberlin.daten_management_api.Lektion;
import de.htwberlin.duell_management_api.Spielsession;
import de.htwberlin.user_management_api.User;
import org.springframework.stereotype.Component;

@Component
public class DuellUiView {

    private Scanner scanner = new Scanner(System.in);


    void printEnterUser1() {
        System.out.println("Geben Sie den Namen des ersten Users ein:");
    }

    String readUser1(){
        return scanner.nextLine();
    }

    void printEnterUser2() {
        System.out.println("Geben Sie den Namen des zweiten Users ein:");
    }

    String readUser2(){
        return scanner.nextLine();
    }


    void printEnterLektion() {
        System.out.println("Geben Sie den Namen der Lektion ein:");
    }

    String readLektion(){
        return scanner.nextLine();
    }



    void printDuellStarted(Spielsession session) {
        System.out.println("Duell gestartet: " + session);
    }

    // Weitere Methoden für UI-Interaktionen
}
