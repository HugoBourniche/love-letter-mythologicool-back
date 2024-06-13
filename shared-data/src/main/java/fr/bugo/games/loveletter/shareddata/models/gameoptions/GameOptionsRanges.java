package fr.bugo.games.loveletter.shareddata.models.gameoptions;

import fr.bugo.games.loveletter.shareddata.utils.Constants;
import lombok.Data;

@Data
public class GameOptionsRanges {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    int minPlayersChoice = Constants.MAX_PLAYERS;
    int maxPlayersChoice = Constants.MAX_PLAYERS;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public GameOptionsRanges() {}

    public GameOptionsRanges(int minPlayersChoice, int maxPlayersChoice) {
        this.minPlayersChoice = minPlayersChoice;
        this.maxPlayersChoice = maxPlayersChoice;
    }
}
