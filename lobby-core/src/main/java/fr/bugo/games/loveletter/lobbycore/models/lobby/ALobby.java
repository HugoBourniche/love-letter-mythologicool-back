package fr.bugo.games.loveletter.lobbycore.models.lobby;

import fr.bugo.games.loveletter.lobbycore.models.users.LobbyUser;
import fr.bugo.games.loveletter.shareddata.models.AGameOptions;
import fr.bugo.games.loveletter.shareddata.models.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class ALobby {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private String key;
    private User owner;
    private List<LobbyUser> users;
    private AGameOptions gameOptions;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ALobby() {
        this.users = new ArrayList<>();
    }

}
