package fr.bugo.games.loveletter.lobbycore.models;

import fr.bugo.games.loveletter.lobbycore.models.users.LobbyUser;
import fr.bugo.games.loveletter.lobbycore.models.users.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Lobby {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private String key;
    private User owner;
    private List<LobbyUser> users;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public Lobby() {
        this.users = new ArrayList<>();
    }

}
