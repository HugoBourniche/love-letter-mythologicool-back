package fr.bugo.games.loveletter.dto.gamecore.convertors;

import fr.bugo.games.loveletter.dto.gamecore.LoveLetterCardDTO;
import fr.bugo.games.loveletter.dto.gamecore.action.LoveLetterRequestedActionDTO;
import fr.bugo.games.loveletter.dto.gamecore.gamemanager.LoveLetterGameManagerDTO;
import fr.bugo.games.loveletter.dto.gamecore.player.LoveLetterPlayerDTO;
import fr.bugo.games.loveletter.dto.lobbycore.convertors.LCModelToDTOConverter;
import fr.bugo.games.loveletter.gamecore.factory.card.CardFactory;
import fr.bugo.games.loveletter.gamecore.model.action.ClassicLoveLetterRequestedAction;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.AClassicLoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.ClassicLoveLetterGameManager;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;

import java.util.ArrayList;
import java.util.List;

public class GCModelToDTOConverter {

    // *****************************************************************************************************************
    // CONVERT GAME MANAGER
    // *****************************************************************************************************************

    public static LoveLetterGameManagerDTO convert(ClassicLoveLetterGameManager gameManager, ClassicLoveLetterPlayer currentPlayer, boolean showCards) {
        LoveLetterGameManagerDTO gameManagerDTO = new LoveLetterGameManagerDTO();
        gameManagerDTO.setCurrentPlayer(convert(currentPlayer, true));
        gameManagerDTO.setOtherPlayers(convertOtherPlayers(gameManager.getPlayers(), currentPlayer, showCards));
        if (!gameManager.getRequestedActions().isEmpty()) {
            // Send only the first action required
            gameManagerDTO.setRequestedAction(convert(gameManager.getRequestedActions().get(0)));
        }
        gameManagerDTO.setCardPile(convertCards(gameManager.getCardPile().getStack(), showCards));
        gameManagerDTO.setDiscardPile(convertCards(gameManager.getDiscardPile().getStack(), showCards));
        gameManagerDTO.setAsideCard(convertCards(gameManager.getAsideCard(), showCards));
        gameManagerDTO.setPlayerTurn(gameManager.getPlayerTurnIndex());
        gameManagerDTO.setRoundNumber(gameManager.getRoundNumber());
        return gameManagerDTO;
    }

    // *****************************************************************************************************************
    // CONVERT CARDS
    // *****************************************************************************************************************

    public static List<LoveLetterCardDTO> convertCards(List<AClassicLoveLetterCard> cards, boolean showCards) {
        List<LoveLetterCardDTO> cardsDTO = new ArrayList<>();
        for (AClassicLoveLetterCard card : cards) {
            cardsDTO.add(convert(card, showCards));
        }
        return cardsDTO;
    }

    public static LoveLetterCardDTO convert(AClassicLoveLetterCard card, boolean showCards) {
        boolean showCardToPlayer = showCards || !card.isFacingDown();
        LoveLetterCardDTO cardDTO = new LoveLetterCardDTO();
        cardDTO.setId(showCardToPlayer ? card.getId().toString() : "no-id");
        cardDTO.setSpriteId(showCardToPlayer ? card.getSpriteId() : CardFactory.backCardSpriteId("classic"));
        cardDTO.setFacingDown(card.isFacingDown());
        cardDTO.setName(showCardToPlayer ? card.getName() : "card");
        cardDTO.setValue(showCardToPlayer ? card.getValue() : -1);
        return cardDTO;
    }

    // *****************************************************************************************************************
    // CONVERT PLAYERS
    // *****************************************************************************************************************

    public static List<LoveLetterPlayerDTO> convertPlayers(List<ClassicLoveLetterPlayer> players, boolean showCards) {
        List<LoveLetterPlayerDTO> playersDTO = new ArrayList<>();
        for (ClassicLoveLetterPlayer player : players) {
            playersDTO.add(convert(player, showCards));
        }
        return playersDTO;
    }

    public static List<LoveLetterPlayerDTO> convertOtherPlayers(List<ClassicLoveLetterPlayer> players, ClassicLoveLetterPlayer currentPlayer, boolean showCards) {
        List<LoveLetterPlayerDTO> otherPlayersDTO = new ArrayList<>();
        // Reorder the list to match with the current player as 0 and the next player is following
        for (int i = (currentPlayer.getPosition() + 1)%players.size(); i != currentPlayer.getPosition(); i=(i+1)%players.size()) {
            otherPlayersDTO.add(convert(players.get(i), showCards));
        }
        return otherPlayersDTO;
    }

    public static LoveLetterPlayerDTO convert(ClassicLoveLetterPlayer player, boolean showCards) {
        LoveLetterPlayerDTO playerDTO = new LoveLetterPlayerDTO();
        playerDTO.setUser(LCModelToDTOConverter.convert(player.getUser()));
        playerDTO.setHand(convertCards(player.getHand(), showCards));
        playerDTO.setPosition(player.getPosition());
        playerDTO.setNbFavorPeace(player.getNbFavorPeace());
        return playerDTO;
    }

    // *****************************************************************************************************************
    // REQUESTED ACTIONS
    // *****************************************************************************************************************

    public static List<LoveLetterRequestedActionDTO> convert(List<ClassicLoveLetterRequestedAction> actions) {
        List<LoveLetterRequestedActionDTO> actionsDTO = new ArrayList<>();
        for (ClassicLoveLetterRequestedAction action : actions) {
            actionsDTO.add(convert(action));
        }
        return actionsDTO;
    }

    public static LoveLetterRequestedActionDTO convert(ClassicLoveLetterRequestedAction action) {
        LoveLetterRequestedActionDTO actionDTO = new LoveLetterRequestedActionDTO();
        actionDTO.setPlayerName(action.getPlayer().getUser().getName());
        actionDTO.setAction(action.getAction().name());
        return actionDTO;
    }
}
