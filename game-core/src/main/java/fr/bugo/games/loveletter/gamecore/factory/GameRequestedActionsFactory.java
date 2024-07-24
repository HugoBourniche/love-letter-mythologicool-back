package fr.bugo.games.loveletter.gamecore.factory;

import fr.bugo.games.loveletter.gamecore.model.action.EAction;

import java.util.List;

public class GameRequestedActionsFactory {

    public static List<EAction> fetchDefaultClassicLoveLetterActions() {
        return List.of(
                EAction.DRAW,
                EAction.PLAY_CARD
        );
    }
}
