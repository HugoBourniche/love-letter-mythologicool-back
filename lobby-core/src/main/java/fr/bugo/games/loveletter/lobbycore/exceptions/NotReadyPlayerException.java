package fr.bugo.games.loveletter.lobbycore.exceptions;

public class NotReadyPlayerException extends Exception {

    public NotReadyPlayerException() {
        super("All players are not ready");
    }
}
