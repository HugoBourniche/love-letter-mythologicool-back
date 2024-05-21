package fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions;

import fr.bugo.games.loveletter.gamecore.factory.LoveLetterGame;
import fr.bugo.games.loveletter.gamecore.model.card.ALoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.player.ALoveLetterPlayer;
import fr.bugo.games.loveletter.gamecore.model.player.APlayer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class ALoveLetterGameOptions<C extends ALoveLetterCard, P extends ALoveLetterPlayer<C>> extends AGameOptions<P> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    LoveLetterGame gameType;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ALoveLetterGameOptions(LoveLetterGame gameType) {
        super();
        this.gameType = gameType;
    }
}
