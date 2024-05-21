package fr.bugo.games.loveletter.gamecore.factory;

import fr.bugo.games.loveletter.gamecore.model.card.ACard;

import java.util.ArrayList;
import java.util.List;

public class GameStackFactory {

    public static <P extends ACard> List<P> buildGameCardStack(LoveLetterGame gameType) {
        return new ArrayList<>();
    }
}
