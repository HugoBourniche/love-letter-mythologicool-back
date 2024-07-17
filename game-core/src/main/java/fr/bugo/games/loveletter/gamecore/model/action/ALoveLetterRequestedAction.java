package fr.bugo.games.loveletter.gamecore.model.action;

import fr.bugo.games.loveletter.gamecore.model.card.loveletter.ALoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.player.ALoveLetterPlayer;

public abstract class ALoveLetterRequestedAction<C extends ALoveLetterCard, P extends ALoveLetterPlayer<C>> extends ARequestedAction<P> {

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    protected ALoveLetterRequestedAction(P player, EAction action) {
        super(player, action);
    }
}
