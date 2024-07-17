package fr.bugo.games.loveletter.gamecore.model.action;

import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.AClassicLoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;

public class ClassicLoveLetterRequestedAction extends ALoveLetterRequestedAction<AClassicLoveLetterCard, ClassicLoveLetterPlayer> {

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ClassicLoveLetterRequestedAction(ClassicLoveLetterPlayer player, EAction action) {
        super(player, action);
    }
}
