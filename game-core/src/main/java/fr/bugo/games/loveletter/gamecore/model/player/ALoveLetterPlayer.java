package fr.bugo.games.loveletter.gamecore.model.player;

import fr.bugo.games.loveletter.gamecore.model.card.loveletter.ALoveLetterCard;
import fr.bugo.games.loveletter.shareddata.models.User;
import fr.bugo.games.loveletter.shareddata.utils.ToStringUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class ALoveLetterPlayer<C extends ALoveLetterCard> extends APlayer {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected Integer position;
    protected Integer nbFavorPeace;
    protected List<C> hand;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ALoveLetterPlayer() {
        this.hand = new ArrayList<>();
        this.nbFavorPeace = 0;
    }

    public ALoveLetterPlayer(User user, Integer position) {
        super(user);
        this.position = position;
        this.hand = new ArrayList<>();
        this.nbFavorPeace = 0;
    }

    // *****************************************************************************************************************
    // OVERRIDE METHODS
    // *****************************************************************************************************************

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ALoveLetterPlayer{");
        sb.append(super.toString());
        sb.append(", position=").append(position);
        sb.append(", ");
        if (isOut()) {
            sb.append("is out");
        } else {
            sb.append(ToStringUtils.list(hand, "hand"));
        }
        sb.append('}');
        return sb.toString();
    }

    // *****************************************************************************************************************
    // PUBLIC METHODS
    // *****************************************************************************************************************

    // HANDS

    /**
     * Empty the hand
     */
    public void clearHand() {
        hand.clear();
    }

    /**
     * Add a card in the hand
     * @param card the card to deal
     */
    public void dealCard(C card) {
        hand.add(card);
    }

    // POINTS

    /**
     * The player gain a favor peace
     */
    public void grantFavorPeace() {
        nbFavorPeace++;
    }

    // UTILS

    /**
     * Is the player out of the game
     * @return true if the player is out
     */
    public boolean isOut() {
        return hand.isEmpty();
    }

}
