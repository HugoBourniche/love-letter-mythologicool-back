package fr.bugo.games.loveletter.gamecore.model.action;

import fr.bugo.games.loveletter.gamecore.model.player.APlayer;
import lombok.Data;

@Data
public abstract class ARequestedAction<P extends APlayer> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected P player;
    protected EAction action;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    protected ARequestedAction(P player, EAction action) {
        this.player = player;
        this.action = action;
    }
}
