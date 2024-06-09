package fr.bugo.games.loveletter.lobbycore.exceptions;

public class MultipleOwnerException extends Exception {

    public MultipleOwnerException(String lobby) {
        super("The lobby " + lobby + " has multiple owners");
    }
}
