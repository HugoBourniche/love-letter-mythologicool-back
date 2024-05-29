package fr.bugo.games.loveletter.gamecore.factory;

import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.shareddata.enums.GameToPlay;
import fr.bugo.games.loveletter.shareddata.models.AGameOptions;

public class GameOptionFactory {

    public static AGameOptions createGameOptions(GameToPlay game) {
        switch (game) {
            case CLASSIC:
            default: return new ClassicLoveLetterGameOptions();
        }
    }
}
