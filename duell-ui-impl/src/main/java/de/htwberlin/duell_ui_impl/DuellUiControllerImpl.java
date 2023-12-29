package de.htwberlin.duell_ui_impl;

import de.htwberlin.daten_management_api.Vokabel;
import de.htwberlin.duell_management_api.Spielsession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import de.htwberlin.duell_management_api.DuellService;
import de.htwberlin.duell_ui_api.DuellUiController;
import de.htwberlin.user_management_api.User;
import de.htwberlin.daten_management_api.Lektion;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DuellUiControllerImpl implements DuellUiController {

    private DuellService duellService;

    List<Vokabel> vokabelListe = new ArrayList<>();
    private DuellUiView view;

    @Autowired
    public DuellUiControllerImpl(DuellService duellService, DuellUiView view) {
        this.duellService = duellService;
        this.view = view;
    }

    @Override
    public void run() {
        // Beispiel für die Interaktion mit dem Benutzer
        view.printEnterUser1();
        view.printEnterUser2();
        view.printEnterLektion();
        User user1 = new User(view.readUser1());
        User user2 = new User(view.readUser2());

        Lektion lektion = new Lektion(view.readLektion(), vokabelListe, "Te");

        Spielsession session = duellService.starteDuell(user1,user2, lektion);
        view.printDuellStarted(session);
    }

    // Weitere Methoden und Logik können hier hinzugefügt werden
}
