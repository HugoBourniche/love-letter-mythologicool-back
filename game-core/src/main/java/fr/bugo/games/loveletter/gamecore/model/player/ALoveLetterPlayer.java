package fr.bugo.games.loveletter.gamecore.model.player;

import fr.bugo.games.loveletter.gamecore.model.card.loveletter.ALoveLetterCard;
import fr.bugo.games.loveletter.shareddata.models.User;
import fr.bugo.games.loveletter.shareddata.utils.ToStringUtils;
import fr.bugo.games.loveletter.shareddata.models.APlayer;
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
    protected List<C> hand;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ALoveLetterPlayer() {
        this.hand = new ArrayList<>();
    }

    public ALoveLetterPlayer(User user, Integer position) {
        super(user);
        this.position = position;
        this.hand = new ArrayList<>();
    }

    // *****************************************************************************************************************
    // OVERRIDE METHODS
    // *****************************************************************************************************************

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ALoveLetterPlayer{");
        sb.append(super.toString());
        sb.append(", position=").append(position);
        sb.append(", ");
        if (IsOut()) {
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

    public void dealCard(C card) {
        hand.add(card);
    }

    public boolean IsOut() {
        return hand.isEmpty();
    }

}
