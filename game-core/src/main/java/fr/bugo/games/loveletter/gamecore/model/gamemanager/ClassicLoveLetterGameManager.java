package fr.bugo.games.loveletter.gamecore.model.gamemanager;

import fr.bugo.games.loveletter.gamecore.exceptions.EmptyCardStackException;
import fr.bugo.games.loveletter.gamecore.factory.GameRequestedActionsFactory;
import fr.bugo.games.loveletter.gamecore.factory.card.ClassicLoveLetterCardFactory;
import fr.bugo.games.loveletter.gamecore.model.action.ClassicLoveLetterRequestedAction;
import fr.bugo.games.loveletter.gamecore.model.action.EAction;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.AClassicLoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;
import fr.bugo.games.loveletter.shareddata.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClassicLoveLetterGameManager extends ALoveLetterGameManager<AClassicLoveLetterCard, ClassicLoveLetterPlayer, ClassicLoveLetterRequestedAction, ClassicLoveLetterGameOptions> {

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
    public void initGame(ClassicLoveLetterGameOptions options, List<User> users) {
        cardPile = ClassicLoveLetterCardFactory.buildInitialGameStack();
        cardPile.shuffle();
        try {
            asideCard.add(cardPile.drawCard());
            // Remove 3 more cards facing up when there are two users
            for (int i = 0; i < 3 && users.size() == 2; i++) {
                AClassicLoveLetterCard card = cardPile.drawCard();
                card.setFacingDown(false);
                asideCard.add(card);
            }
            for (int position = 0; position < users.size(); position++) {
                User user = users.get(position);
                ClassicLoveLetterPlayer player = new ClassicLoveLetterPlayer(user, position);
                this.players.add(player);
                this.playerDrawCard(player);
            }
            playerTurn = 0;
            this.startTurn(this.players.get(playerTurn));
        } catch (EmptyCardStackException e) {
            LOGGER.error("Impossible to start the game, an error has occurred during the card dealing, it is empty");
        }
    }

    @Override
    public void startTurn(ClassicLoveLetterPlayer player) {
        List<EAction> actions = GameRequestedActionsFactory.fetchDefaultClassicLoveLetterActions();
        this.addRequestedActions(player, actions);
    }

    @Override
    public void addRequestedActions(ClassicLoveLetterPlayer player, List<EAction> actions) {
        for (EAction action : actions) {
            this.requestedActions.add(new ClassicLoveLetterRequestedAction(player, action));
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClassicLoveLetterGameManager{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
