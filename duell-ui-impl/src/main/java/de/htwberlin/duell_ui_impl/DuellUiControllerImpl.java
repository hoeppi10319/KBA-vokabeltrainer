package de.htwberlin.duell_ui_impl;

import de.htwberlin.daten_management_api.Lektion;
import de.htwberlin.duell_management_api.DuellService;
import de.htwberlin.duell_management_api.Spielsession;
import de.htwberlin.duell_ui_api.DuellUiController;
import de.htwberlin.user_management_api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DuellUiControllerImpl implements DuellUiController {

    private DuellService duellService;
    private DuellUiView view;

    @Autowired
    public DuellUiControllerImpl(DuellService duellService, DuellUiView view) {
        this.duellService = duellService;
        this.view = view;
    }

    @Override
    public void run() {
        view.printEnterUser1();
        User user1 = new User(view.readUser1());

        view.printEnterUser2();
        User user2 = new User(view.readUser2());

        // Verwende die vordefinierte Lektion
        Lektion lektion = view.getPredefinedLektion();

        Spielsession session = duellService.starteDuell(user1, user2, lektion);
        view.printDuellStarted(session);
    }
}
