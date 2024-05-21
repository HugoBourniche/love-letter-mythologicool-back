package fr.bugo.games.loveletter.gamecore.model.player;

import fr.bugo.games.loveletter.gamecore.model.card.ALoveLetterCard;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public abstract class ALoveLetterPlayer<C extends ALoveLetterCard> extends APlayer {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private List<C> hand;

}
