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
import fr.bugo.games.loveletter.shareddata.utils.Constants;
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
        for (int position = 0; position < users.size(); position++) {
            User user = users.get(position);
            ClassicLoveLetterPlayer player = new ClassicLoveLetterPlayer(user, position);
            players.add(player);
        }
        nbTokensToWin = Constants.NB_TOKENS_PER_NB_PLAYERS.get(players.size()); // TODO use options to set this parameter
        isPlaying = true;
        roundNumber = 0;
        this.startRound();
    }

    // ROUNDS

    @Override
    public void startRound() {
        roundNumber++;
        cardPile = ClassicLoveLetterCardFactory.buildInitialGameStack();
        cardPile.shuffle();
        try {
            this.clearAndDrawCardsAside();
            this.clearHandsAndDealCardsToPlayers();
            this.startTurn();
        } catch (EmptyCardStackException e) {
            LOGGER.error("Impossible to start the game, an error has occurred during the card dealing, it is empty");
            e.printStackTrace();
        }
    }

    @Override
    protected void endRound() {
        // Compute each player's winning tokens
        List<ClassicLoveLetterPlayer> winningPlayers = getPlayersWithHighestValue();
        // TODO grant favor peace to player who played the spy
        for (ClassicLoveLetterPlayer winningPlayer : winningPlayers) {
            winningPlayer.grantFavorPeace();
        }
    }

    // TURNS

    @Override
    public void startTurn() {
        ClassicLoveLetterPlayer playerTurn = changePlayerTurn();
        List<EAction> actions = GameRequestedActionsFactory.fetchDefaultClassicLoveLetterActions();
        this.addRequestedActions(playerTurn, actions);
    }

    @Override
    protected void endTurn() {
        if (cardPile.isEmpty() || onlyOnePlayerRemain()) {
            this.endRound();
        } else {
            this.startTurn();
        }
    }

    // CARD PILES

    @Override
    protected void clearAndDrawCardsAside() throws EmptyCardStackException {
        asideCard.clear();
        asideCard.add(cardPile.drawCard());
        // Remove 3 more cards facing up when there are two users
        for (int i = 0; i < 3 && players.size() == 2; i++) {
            AClassicLoveLetterCard card = cardPile.drawCard();
            card.setFacingDown(false);
            asideCard.add(card);
        }
    }

    // ACTIONS

    @Override
    public void addRequestedActions(ClassicLoveLetterPlayer player, List<EAction> actions) {
        for (EAction action : actions) {
            this.requestedActions.add(new ClassicLoveLetterRequestedAction(player, action));
        }
    }

    // UTILS

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClassicLoveLetterGameManager{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
