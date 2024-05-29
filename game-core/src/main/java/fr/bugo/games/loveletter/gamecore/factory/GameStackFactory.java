package fr.bugo.games.loveletter.gamecore.factory;

import fr.bugo.games.loveletter.gamecore.model.card.ACard;
import fr.bugo.games.loveletter.shareddata.enums.GameToPlay;

import java.util.ArrayList;
import java.util.List;

public class GameStackFactory {

    public static <P extends ACard> List<P> buildGameCardStack(GameToPlay gameType) {
        return new ArrayList<>();
    }
}
