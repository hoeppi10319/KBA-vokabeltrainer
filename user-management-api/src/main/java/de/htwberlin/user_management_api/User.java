package de.htwberlin.user_management_api;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class User {
    private Long id;
    private String name;
    private List<Friend> friends;
    private Statistik statistik;

    // Eine statische Variable, um IDs zu generieren
    private static final AtomicLong ID_GENERATOR = new AtomicLong(1);

    public User(String name) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.name = name;
    }

    // Weitere Getter und Setter hier

    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public Statistik getStatistik() {
        return statistik;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public void setStatistik(Statistik statistik) {
        this.statistik = statistik;
    }

    // Weitere Methoden zur Benutzerverwaltung hier
}
