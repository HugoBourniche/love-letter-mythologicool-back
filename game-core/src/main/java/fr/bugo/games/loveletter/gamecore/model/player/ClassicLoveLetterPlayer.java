package fr.bugo.games.loveletter.gamecore.model.player;

import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.AClassicLoveLetterCard;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClassicLoveLetterPlayer extends ALoveLetterPlayer<AClassicLoveLetterCard> {

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ClassicLoveLetterPlayer() {}

    public ClassicLoveLetterPlayer(String name, Integer position) {
        super(name, position);
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
