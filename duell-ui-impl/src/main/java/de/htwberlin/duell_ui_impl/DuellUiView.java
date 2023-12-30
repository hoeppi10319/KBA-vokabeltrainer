package de.htwberlin.duell_ui_impl;

import java.util.Scanner;

import de.htwberlin.daten_management_api.DatenService;
import de.htwberlin.daten_management_api.Lektion;
import de.htwberlin.duell_management_api.Spielsession;
import de.htwberlin.user_management_api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DuellUiView {

    private Scanner scanner = new Scanner(System.in);
    private DatenService datenService;

    @Autowired
    public DuellUiView(DatenService datenService) {
        this.datenService = datenService;
    }

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

    // Methode, die eine vordefinierte Lektion zurückgibt
    Lektion getPredefinedLektion() {
        try {
            // Erstellen Sie hier eine Lektion mit einem hardgecodeten Dateipfad
            // Beispiel:
            return datenService.createLektion("pfad/zur/Datei");
        } catch (IOException e) {
            System.out.println("Fehler beim Erstellen der Lektion: " + e.getMessage());
            return null; // Oder eine geeignete Fehlerbehandlung durchführen
        }
    }

    void printDuellStarted(Spielsession session) {
        System.out.println("Duell gestartet: " + session);
    }

    // Weitere Methoden für UI-Interaktionen
}
