package fr.bugo.games.loveletter.dto.gamecore.convertors;

import fr.bugo.games.loveletter.dto.gamecore.LoveLetterCardDTO;
import fr.bugo.games.loveletter.dto.gamecore.gamemanager.LoveLetterGameManagerDTO;
import fr.bugo.games.loveletter.dto.gamecore.player.LoveLetterPlayerDTO;
import fr.bugo.games.loveletter.dto.lobbycore.convertors.LCModelToDTOConverter;
import fr.bugo.games.loveletter.gamecore.factory.card.CardFactory;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.AClassicLoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.ClassicLoveLetterGameManager;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;

import java.util.ArrayList;
import java.util.List;

public class GCModelToDTOConverter {

    // *****************************************************************************************************************
    // CONVERT GAME MANAGER
    // *****************************************************************************************************************

    public static LoveLetterGameManagerDTO convert(ClassicLoveLetterGameManager gameManager, ClassicLoveLetterPlayer currentPlayer, boolean hideOtherPlayerCards) {
        LoveLetterGameManagerDTO gameManagerDTO = new LoveLetterGameManagerDTO();
        gameManagerDTO.setCurrentPlayer(convert(currentPlayer));
        gameManagerDTO.setOtherPlayers(convertOtherPlayers(gameManager.getPlayers(), currentPlayer, hideOtherPlayerCards));
        gameManagerDTO.setCardPile(convert(gameManager.getCardPile().getStack()));
        gameManagerDTO.setDiscardPile(convert(gameManager.getDiscardPile().getStack()));
        gameManagerDTO.setAsideCard(convert(gameManager.getAsideCard()));
        gameManagerDTO.setPlayerTurn(gameManager.getPlayerTurn());
        return gameManagerDTO;
    }

    // *****************************************************************************************************************
    // CONVERT CARDS
    // *****************************************************************************************************************

    public static List<LoveLetterCardDTO> convert(List<AClassicLoveLetterCard> cards) {
        List<LoveLetterCardDTO> cardsDTO = new ArrayList<>();
        for (AClassicLoveLetterCard card : cards) {
            cardsDTO.add(convert(card));
        }
        return cardsDTO;
    }

    public static LoveLetterCardDTO convert(AClassicLoveLetterCard card) {
        LoveLetterCardDTO cardDTO = new LoveLetterCardDTO();
        cardDTO.setId(card.getId().toString());
        cardDTO.setSpriteId(card.getSpriteId());
        cardDTO.setFacingDown(card.isFacingDown());
        cardDTO.setName(card.getName());
        cardDTO.setValue(card.getValue());
        return cardDTO;
    }

    public static List<LoveLetterCardDTO> getHiddenCards(int nbCards) {
        List<LoveLetterCardDTO> cards = new ArrayList<>();
        for (int i = 0; i < nbCards; i++) {
            cards.add(getHiddenCard());
        }
        return cards;
    }

    public static LoveLetterCardDTO getHiddenCard() {
        LoveLetterCardDTO cardDTO = new LoveLetterCardDTO();
        cardDTO.setId("no-id");
        cardDTO.setSpriteId(CardFactory.backCardSpriteId("classic")); // TODO update this
        cardDTO.setFacingDown(true);
        cardDTO.setName("card");
        cardDTO.setValue(-1);
        return cardDTO;
    }

    // *****************************************************************************************************************
    // CONVERT PLAYERS
    // *****************************************************************************************************************

    public static List<LoveLetterPlayerDTO> convertPlayers(List<ClassicLoveLetterPlayer> players) {
        List<LoveLetterPlayerDTO> playersDTO = new ArrayList<>();
        for (ClassicLoveLetterPlayer player : players) {
            playersDTO.add(convert(player));
        }
        return playersDTO;
    }

    public static List<LoveLetterPlayerDTO> convertOtherPlayers(List<ClassicLoveLetterPlayer> players, ClassicLoveLetterPlayer currentPlayer, boolean hideOtherPlayerCards) {
        List<LoveLetterPlayerDTO> otherPlayersDTO = new ArrayList<>();
        // Reorder the list to match with the current player as 0 and the next player is following
        for (int i = (currentPlayer.getPosition() + 1)%players.size(); i != currentPlayer.getPosition(); i=(i+1)%players.size()) {
            ClassicLoveLetterPlayer player = players.get(i);
            if (hideOtherPlayerCards) {
                otherPlayersDTO.add(convertHiddenHandPlayer(player));
            } else {
                otherPlayersDTO.add(convert(player));
            }
        }
        return otherPlayersDTO;
    }

    public static LoveLetterPlayerDTO convertHiddenHandPlayer(ClassicLoveLetterPlayer player) {
        LoveLetterPlayerDTO playerDTO = new LoveLetterPlayerDTO();
        playerDTO.setUser(LCModelToDTOConverter.convert(player.getUser()));
        playerDTO.setHand(getHiddenCards(player.getHand().size()));
        playerDTO.setPosition(player.getPosition());
        playerDTO.setNbFavorPeace(player.getNbFavorPeace());
        return playerDTO;
    }

    public static LoveLetterPlayerDTO convert(ClassicLoveLetterPlayer player) {
        LoveLetterPlayerDTO playerDTO = new LoveLetterPlayerDTO();
        playerDTO.setUser(LCModelToDTOConverter.convert(player.getUser()));
        playerDTO.setHand(convert(player.getHand()));
        playerDTO.setPosition(player.getPosition());
        playerDTO.setNbFavorPeace(player.getNbFavorPeace());
        return playerDTO;
    }
}
