package fr.bugo.games.loveletter.lobbycore.exceptions;

public class UniqueNameException extends Exception {

    public UniqueNameException(String name) {
        super("The name \"" + name + "\" is already used");
    }
}
