package fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions;

import fr.bugo.games.loveletter.gamecore.factory.LoveLetterGame;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.AClassicLoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClassicLoveLetterGameOptions extends ALoveLetterGameOptions<AClassicLoveLetterCard, ClassicLoveLetterPlayer> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ClassicLoveLetterGameOptions() {
        super(LoveLetterGame.CLASSIC);
    }
}
