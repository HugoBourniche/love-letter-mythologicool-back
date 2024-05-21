package fr.bugo.games.loveletter.gamecore.model.gamemanager;

import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.AGameOptions;
import fr.bugo.games.loveletter.gamecore.model.card.ALoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.player.ALoveLetterPlayer;
import fr.bugo.games.loveletter.gamecore.model.stack.CardStack;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public abstract class ALoveLetterGameManager<C extends ALoveLetterCard, P extends ALoveLetterPlayer<C>> extends AGameManager<C, P, CardStack<C>> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    CardStack<C> cardPile;
    CardStack<C> discardPile;
    C offCard;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    // *****************************************************************************************************************
    // ABSTRACT METHODS
    // *****************************************************************************************************************

    public abstract void InitGame(AGameOptions<P> options);
}
