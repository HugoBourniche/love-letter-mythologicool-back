package fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic;

import fr.bugo.games.loveletter.gamecore.model.card.loveletter.ALoveLetterCard;

public abstract class AClassicLoveLetterCard extends ALoveLetterCard {

    public AClassicLoveLetterCard(String spriteId, boolean facingDown, String name, Integer value, String description) {
        super(spriteId, facingDown, name, value, description);
    }
}
