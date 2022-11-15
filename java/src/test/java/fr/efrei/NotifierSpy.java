package fr.efrei;

public class NotifierSpy implements Notifier {
    public int numberOfCall;

    @Override
    public void notify(User user, String message) {
        numberOfCall++;
    }

    public int getNumberOfCall() {
        return numberOfCall;
    }
}
