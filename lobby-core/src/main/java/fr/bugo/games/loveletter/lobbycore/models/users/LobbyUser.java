package fr.bugo.games.loveletter.lobbycore.models.users;

import fr.bugo.games.loveletter.shareddata.models.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
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

    public LobbyUser(User user) {
        super(user.getName());
    }
}
