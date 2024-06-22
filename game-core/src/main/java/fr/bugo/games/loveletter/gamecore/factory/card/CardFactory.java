package fr.bugo.games.loveletter.gamecore.factory.card;

import fr.bugo.games.loveletter.shareddata.enums.GameToPlay;

public class CardFactory {

    private static final String CLASSIC_LOVE_LETTER_BACK_CARD_SPRITE = "loveletter_classic_dos";

    public static String backCardSpriteId(String gameName) {
        return backCardSpriteId(GameToPlay.convert(gameName));
    }

    public static String backCardSpriteId(GameToPlay game) {
        switch (game){
            case CLASSIC:
            default: return CLASSIC_LOVE_LETTER_BACK_CARD_SPRITE;
        }
    }
}
