package fr.bugo.games.loveletter.shareddata.models;

import fr.bugo.games.loveletter.shareddata.models.gameoptions.AGameOptions;
import fr.bugo.games.loveletter.shareddata.utils.ToStringUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
