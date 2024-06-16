package fr.bugo.games.loveletter.shareddata.exceptions;

public class NoUserException extends Exception {
    public NoUserException(String userName) {
        super("The user [" + userName + "] does not exists");
    }
}
