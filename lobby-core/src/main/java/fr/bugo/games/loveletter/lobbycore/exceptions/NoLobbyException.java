package fr.bugo.games.loveletter.lobbycore.exceptions;

public class NoLobbyException extends Exception {

    public NoLobbyException(String lobbyKey) {
        super("The lobby [" + lobbyKey + "] does not exist");
    }
}
