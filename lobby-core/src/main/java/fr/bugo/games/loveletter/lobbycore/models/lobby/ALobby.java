package fr.bugo.games.loveletter.lobbycore.models.lobby;

import fr.bugo.games.loveletter.lobbycore.exceptions.MultipleOwnerException;
import fr.bugo.games.loveletter.lobbycore.exceptions.NoOwnerException;
import fr.bugo.games.loveletter.lobbycore.exceptions.UniqueNameException;
import fr.bugo.games.loveletter.lobbycore.models.users.LobbyUser;
import fr.bugo.games.loveletter.shareddata.models.gameoptions.AGameOptions;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public abstract class ALobby {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private String key;
    private List<LobbyUser> users;
    private AGameOptions gameOptions;
    private boolean isInGame;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ALobby() {
        this.users = new ArrayList<>();
        this.isInGame = false;
    }

    // *****************************************************************************************************************
    // METHODS
    // *****************************************************************************************************************

    public LobbyUser getOwner() throws NoOwnerException, MultipleOwnerException {
        List<LobbyUser> owner = this.users.stream().filter(LobbyUser::isOwner).collect(Collectors.toList());
        if (owner.size() == 0) {
            throw new NoOwnerException(this.key);
        } else if (owner.size() > 1) {
            throw new MultipleOwnerException(this.key);
        }
        return owner.get(0);
    }

    public void addNewUser(LobbyUser user) throws UniqueNameException {
        for (LobbyUser otherUser : users) {
            if (user.getName().equals(otherUser.getName())) {
                throw new UniqueNameException(user.getName());
            }
        }
        this.users.add(user);
    }
}
