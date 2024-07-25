package fr.bugo.games.loveletter.gamecore.model.gamemanager;

import fr.bugo.games.loveletter.gamecore.exceptions.EmptyCardStackException;
import fr.bugo.games.loveletter.gamecore.model.action.ALoveLetterRequestedAction;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.ALoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ALoveLetterGameOptions;
import fr.bugo.games.loveletter.gamecore.model.player.ALoveLetterPlayer;
import fr.bugo.games.loveletter.gamecore.model.stack.CardStack;
import fr.bugo.games.loveletter.shareddata.exceptions.NoUserException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class ALoveLetterGameManager<C extends ALoveLetterCard, P extends ALoveLetterPlayer<C>, A extends ALoveLetterRequestedAction<C, P>, O extends ALoveLetterGameOptions> extends AGameManager<P, A, O> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ALoveLetterGameManager.class);

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected CardStack<C> cardPile;
    protected CardStack<C> discardPile;
    protected List<C> asideCard;
    protected Integer nbTokensToWin;
    protected Integer roundNumber;
    protected Integer playerTurnIndex;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ALoveLetterGameManager() {
        super();
        this.cardPile = new CardStack<>();
        this.discardPile = new CardStack<>();
        this.asideCard = new ArrayList<>();
    }

    // *****************************************************************************************************************
    // ABSTRACT METHODS
    // *****************************************************************************************************************

    public abstract void startTurn();
    public abstract void startRound();
    protected abstract void endTurn();
    protected abstract void endRound();

    protected abstract void clearAndDrawCardsAside() throws EmptyCardStackException;

    // *****************************************************************************************************************
    // OVERRIDE METHODS
    // *****************************************************************************************************************

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClassicLoveLetterGameManager{");
        sb.append(super.toString());
        sb.append(", cardPile=").append(cardPile);
        sb.append(", discardPile=").append(discardPile);
        sb.append(", asideCard=").append(asideCard);
        sb.append('}');
        return sb.toString();
    }


    // *****************************************************************************************************************
    // PUBLIC METHODS
    // *****************************************************************************************************************

    /**
     * Draw a card from the card pile stack and give it to the player
     * @param playerName Name of the player to deal a card
     * @return Card object
     * @throws EmptyCardStackException The manager tried to deal cards but there are missing cards to play
     * @throws NoUserException The given name does not exists in this game
     */
    public C dealCardToPlayer(String playerName) throws EmptyCardStackException, NoUserException {
        P player = this.getPlayer(playerName);
        return dealCardToPlayer(player);
    }

    // *****************************************************************************************************************
    // PRIVATE METHODS
    // *****************************************************************************************************************

    // Players

    /**
     * Get the Player turn object
     * @return P Player object
     */
    protected P getPlayerTurn() {
        return this.players.get(playerTurnIndex);
    }

    /**
     * Set the current player turn
     * @param newPlayerTurnIndex New player index turn
     */
    protected void setPlayerTurn(int newPlayerTurnIndex) {
        playerTurnIndex = newPlayerTurnIndex;
    }

    /**
     * Change the current player turn to set the next one
     * @return Player object
     */
    protected P changePlayerTurn() {
        if (playerTurnIndex == null) {
            playerTurnIndex = 0;
        } else {
            playerTurnIndex = ( playerTurnIndex + 1 ) % this.players.size();
        }
        return getPlayerTurn();
    }

    /**
     * Clear hands of all players and deal a card to players
     * @throws EmptyCardStackException The manager tried to deal cards but there are missing cards to play
     */
    protected void clearHandsAndDealCardsToPlayers() throws EmptyCardStackException {
        for (P player : this.players) {
            player.clearHand();
            this.dealCardToPlayer(player);
        }
    }

    /**
     * Draw a card from the card pile stack and give it to the player
     * @param player P player to deal a card
     * @return Card object
     * @throws EmptyCardStackException The manager tried to deal cards but there are missing cards to play
     */
    protected C dealCardToPlayer(P player) throws EmptyCardStackException {
        C card = cardPile.drawCard();
        player.dealCard(card);
        return card;
    }

    /**
     * Fetch the list of the players with the highest card value
     * FIXME Check if the player as one card in his hand but does not throw error yet
     * @return List of the players objects
     */
    protected List<P> getPlayersWithHighestValue() {
        int highestValue = -1;
        List<P> playersWithHighestValue = new ArrayList<>();
        for (P player : players) {
            if (player.getHand().size() > 1) {
                LOGGER.error("Player must not have more than 1 card in hand");
                continue;
            }
            if (player.getHand().size() == 0) {
                continue;
            }
            C card = player.getHand().get(0);
            // Update highest value
            if (card.getValue() > highestValue) {
                highestValue = card.getValue();
                playersWithHighestValue.clear();
            }
            // Update players with the highest value
            if (card.getValue() == highestValue) {
                playersWithHighestValue.add(player);
            }
        }
        return playersWithHighestValue;
    }

    /**
     * Check if there is still more than one player in the game
     * @return True is there is only one player
     */
    protected boolean onlyOnePlayerRemain() {
        int nbAlive = 0;
        for (P player : players) {
            if (!player.isOut()) {
                nbAlive++;
                if (nbAlive > 1) {
                    return false;
                }
            }
        }
        return nbAlive == 1;
    }
}
