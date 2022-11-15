package fr.efrei;

import java.util.ArrayList;
import java.util.List;

public class NotifierMock implements Notifier {
    private final List<User> notifiedUsers = new ArrayList<>();

    @Override
    public void notify(User user, String message) {
        notifiedUsers.add(user);
    }

    public boolean isCallForAll(List<User> users) {
        return notifiedUsers.containsAll(users);
    }
}
