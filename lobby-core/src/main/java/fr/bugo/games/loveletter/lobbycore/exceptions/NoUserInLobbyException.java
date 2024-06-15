package fr.bugo.games.loveletter.lobbycore.exceptions;

public class NoUserInLobbyException extends Exception {

    public NoUserInLobbyException(String lobbyKey, String userName) {
        super("The lobby [" + lobbyKey + "] does not contains the user [" + userName + "]");
    }
}
