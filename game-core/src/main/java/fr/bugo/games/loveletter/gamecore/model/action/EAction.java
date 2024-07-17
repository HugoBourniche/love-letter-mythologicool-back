package fr.bugo.games.loveletter.gamecore.model.action;

public enum EAction {
    IDLE,
    // Shared actions
    DRAW, PLAY_CARD,
    // Love Letter actions
    DISCARD, SELECT_PLAYER, SELECT_OTHER_PLAYER, SELECT_CARD
}
