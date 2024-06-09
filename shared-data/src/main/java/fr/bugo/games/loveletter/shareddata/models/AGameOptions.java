package fr.bugo.games.loveletter.shareddata.models;

import fr.bugo.games.loveletter.shareddata.utils.Constants;
import lombok.Data;

@Data
public abstract class AGameOptions {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    int maxPlayers = Constants.MAX_PLAYERS;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public AGameOptions() {}

}
