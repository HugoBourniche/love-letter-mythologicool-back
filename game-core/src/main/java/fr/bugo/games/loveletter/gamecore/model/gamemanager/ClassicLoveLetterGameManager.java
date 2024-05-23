package fr.bugo.games.loveletter.gamecore.model.gamemanager;

import fr.bugo.games.loveletter.gamecore.exceptions.EmptyCardStackException;
import fr.bugo.games.loveletter.gamecore.factory.card.ClassicLoveLetterCardFactory;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.AClassicLoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassicLoveLetterGameManager extends ALoveLetterGameManager<AClassicLoveLetterCard, ClassicLoveLetterPlayer, ClassicLoveLetterGameOptions> {

    // *****************************************************************************************************************
    // CONSTANTS
    // *****************************************************************************************************************

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassicLoveLetterGameManager.class);

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    // *****************************************************************************************************************
    // OVERRIDE METHODS
    // *****************************************************************************************************************

    @Override
    public void initGame(ClassicLoveLetterGameOptions options) {
        cardPile = ClassicLoveLetterCardFactory.buildInitialGameStack();
        cardPile.shuffle();
        try {
            asideCard.add(cardPile.drawCard());
            // Remove 3 more cards facing up when there are two players
            for (int i = 0; i < 3 && options.getPlayers().size() == 2; i++) {
                AClassicLoveLetterCard card = cardPile.drawCard();
                card.setFacingDown(false);
                asideCard.add(card);
            }
            for (ClassicLoveLetterPlayer player : options.getPlayers()) {
                player.dealCard(cardPile.drawCard());
                this.players.add(player);
            }
        } catch (EmptyCardStackException e) {
            LOGGER.error("Impossible to start the game, an error has occurred during the card dealing, it is empty");
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClassicLoveLetterGameManager{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
