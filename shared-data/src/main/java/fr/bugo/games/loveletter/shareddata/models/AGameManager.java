package fr.bugo.games.loveletter.shareddata.models;

import fr.bugo.games.loveletter.shareddata.exceptions.NoUserException;
import fr.bugo.games.loveletter.shareddata.models.gameoptions.AGameOptions;
import fr.bugo.games.loveletter.shareddata.utils.ToStringUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public abstract class AGameManager<P extends APlayer, O extends AGameOptions> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected List<P> players;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public AGameManager() {
        this.players = new ArrayList<>();
    }

    // *****************************************************************************************************************
    // ABSTRACT METHODS
    // *****************************************************************************************************************

    public abstract void initGame(O options, List<User> users);

    // *****************************************************************************************************************
    // PUBLIC METHODS
    // *****************************************************************************************************************

    public P getPlayer(String name) throws NoUserException {
        Optional<P> optPlayer = this.players.stream().filter(p -> p.user.getName().equals(name)).findAny();
        if (optPlayer.isEmpty()) {
            throw new NoUserException(name);
        }
        return optPlayer.get();
    }
    // *****************************************************************************************************************
    // OVERRIDE METHODS
    // *****************************************************************************************************************

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AGameManager{");
        sb.append(ToStringUtils.list(players, "players"));
        sb.append('}');
        return sb.toString();
    }
}
