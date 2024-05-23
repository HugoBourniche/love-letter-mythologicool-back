package fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions;

import fr.bugo.games.loveletter.gamecore.factory.LoveLetterGame;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.ALoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.player.ALoveLetterPlayer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class ALoveLetterGameOptions<C extends ALoveLetterCard, P extends ALoveLetterPlayer<C>> extends AGameOptions<P> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected LoveLetterGame gameType;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ALoveLetterGameOptions() {
        super();
    }

    public ALoveLetterGameOptions(LoveLetterGame gameType) {
        this();
        this.gameType = gameType;
    }
}
