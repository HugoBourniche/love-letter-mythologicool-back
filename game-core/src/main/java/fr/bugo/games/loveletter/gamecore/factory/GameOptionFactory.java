package fr.bugo.games.loveletter.gamecore.factory;

import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.shareddata.enums.GameToPlay;
import fr.bugo.games.loveletter.shareddata.models.gameoptions.AGameOptions;
import fr.bugo.games.loveletter.shareddata.models.gameoptions.GameOptionsRanges;

import static fr.bugo.games.loveletter.shareddata.utils.Constants.MAX_PLAYERS;
import static fr.bugo.games.loveletter.shareddata.utils.Constants.MIN_PLAYERS;

public class GameOptionFactory {

    public static AGameOptions createGameOptions(GameToPlay game) {
        switch (game) {
            case CLASSIC:
            default:
                AGameOptions options =  new ClassicLoveLetterGameOptions();
                options.setRanges(createGameRanges());
                return options;
        }
    }

    private static GameOptionsRanges createGameRanges() {
        return new GameOptionsRanges(MIN_PLAYERS, MAX_PLAYERS);
    }
}
