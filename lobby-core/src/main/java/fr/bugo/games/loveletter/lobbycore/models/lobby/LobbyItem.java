package fr.bugo.games.loveletter.lobbycore.models.lobby;

import fr.bugo.games.loveletter.shareddata.models.User;

public class LobbyItem extends ALobbyItem {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    LobbyItem() {}

    public LobbyItem(String key, User owner) {
        super(key, owner);
    }
}
