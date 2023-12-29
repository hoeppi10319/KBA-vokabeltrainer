package de.htwberlin.user_management_api;

import java.util.ArrayList;
import java.util.List;

public class Friend {

    private List<User> friend;

    public Friend() {
        this.friend = new ArrayList<>();
    }

    public void addfriend(User freund) {
        friend.add(freund);
    }

    public void removefriend(User freund) {
        friend.remove(freund);
    }

    public List<User> getFriend() {
        return friend;
    }
}
