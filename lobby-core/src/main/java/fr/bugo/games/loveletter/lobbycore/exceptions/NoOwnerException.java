package fr.bugo.games.loveletter.lobbycore.exceptions;

public class NoOwnerException extends Exception {

    public NoOwnerException(String lobby) {
        super("The lobby " + lobby + " does not have an owner");
    }
}
