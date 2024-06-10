package fr.bugo.games.loveletter.shareddata.models.gameoptions;

import fr.bugo.games.loveletter.shareddata.utils.Constants;
import lombok.Data;

@Data
public abstract class AGameOptions {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected int maxPlayers = Constants.MAX_PLAYERS;
    protected GameOptionsRanges ranges;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public AGameOptions() {}

}
