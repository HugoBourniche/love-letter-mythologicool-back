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
    private boolean isOwner = false;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LobbyUser() {}

    public LobbyUser(User user, boolean isOwner) {
        super(user.getName());
        this.isOwner = isOwner;
    }

    public LobbyUser(User user) {
        this(user, false);
    }
}
