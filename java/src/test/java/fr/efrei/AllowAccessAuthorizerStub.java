package fr.efrei;

public class AllowAccessAuthorizerStub implements Authorizer {
    @Override
    public boolean authorize() {
        return true;
    }
}
