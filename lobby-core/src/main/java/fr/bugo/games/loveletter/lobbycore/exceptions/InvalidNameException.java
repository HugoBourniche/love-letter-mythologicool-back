package fr.bugo.games.loveletter.lobbycore.exceptions;

public class InvalidNameException extends Exception {

    public InvalidNameException(String name) {
        super("The name \"" + name + "\" is not valid");
    }
}
