package fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions;

import fr.bugo.games.loveletter.gamecore.factory.LoveLetterGame;
import fr.bugo.games.loveletter.gamecore.model.card.ClassicLoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;

public class ClassicLoveLetterGameOptions extends ALoveLetterGameOptions<ClassicLoveLetterCard, ClassicLoveLetterPlayer> {

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ClassicLoveLetterGameOptions() {
        super(LoveLetterGame.CLASSIC);
    }
}
