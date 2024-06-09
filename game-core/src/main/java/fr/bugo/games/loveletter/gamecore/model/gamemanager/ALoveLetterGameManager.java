package fr.bugo.games.loveletter.gamecore.model.gamemanager;

import fr.bugo.games.loveletter.gamecore.model.card.loveletter.ALoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ALoveLetterGameOptions;
import fr.bugo.games.loveletter.gamecore.model.player.ALoveLetterPlayer;
import fr.bugo.games.loveletter.gamecore.model.stack.CardStack;
import fr.bugo.games.loveletter.shareddata.models.AGameManager;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class ALoveLetterGameManager<C extends ALoveLetterCard, P extends ALoveLetterPlayer<C>, O extends ALoveLetterGameOptions> extends AGameManager<P, O> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected CardStack<C> cardPile;
    protected CardStack<C> discardPile;
    protected List<C> asideCard;
    protected Integer playerTurn;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ALoveLetterGameManager() {
        super();
        this.cardPile = new CardStack<>();
        this.discardPile = new CardStack<>();
        this.asideCard = new ArrayList<>();
    }

    // *****************************************************************************************************************
    // OVERRIDE METHODS
    // *****************************************************************************************************************


    @Override
    public abstract void initGame(O options, List<P> players);

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClassicLoveLetterGameManager{");
        sb.append(super.toString());
        sb.append(", cardPile=").append(cardPile);
        sb.append(", discardPile=").append(discardPile);
        sb.append(", asideCard=").append(asideCard);
        sb.append('}');
        return sb.toString();
    }
}
