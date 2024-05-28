package fr.bugo.games.loveletter.lobbycore.models.users;

import lombok.Data;

@Data
public class LobbyUser extends User {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private boolean isReady = false;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************


    public LobbyUser() {
    }

    public LobbyUser(String name) {
        super(name);
    }
}
