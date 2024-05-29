package fr.bugo.games.loveletter.gamecore.model.player;

import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.AClassicLoveLetterCard;
import fr.bugo.games.loveletter.shareddata.models.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClassicLoveLetterPlayer extends ALoveLetterPlayer<AClassicLoveLetterCard> {

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ClassicLoveLetterPlayer() {}

    public ClassicLoveLetterPlayer(User user, Integer position) {
        super(user, position);
    }

    // *****************************************************************************************************************
    // OVERRIDE METHODS
    // *****************************************************************************************************************


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClassicLoveLetterPlayer{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
