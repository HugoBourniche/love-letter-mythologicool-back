package fr.bugo.games.loveletter.dto.gamecore.convertors;

import fr.bugo.games.loveletter.dto.gamecore.LoveLetterCardDTO;
import fr.bugo.games.loveletter.dto.gamecore.gamemanager.LoveLetterGameManagerDTO;
import fr.bugo.games.loveletter.dto.gamecore.player.LoveLetterPlayerDTO;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.AClassicLoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.ClassicLoveLetterGameManager;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;

import java.util.ArrayList;
import java.util.List;

public class GCModelToDTOConverter {

    // *****************************************************************************************************************
    // CONVERT GAME MANAGER
    // *****************************************************************************************************************

    public static LoveLetterGameManagerDTO convert(ClassicLoveLetterGameManager gameManager) {
        LoveLetterGameManagerDTO gameManagerDTO = new LoveLetterGameManagerDTO();
        gameManagerDTO.setPlayers(convertPlayers(gameManager.getPlayers()));
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

    public static LoveLetterPlayerDTO convert(ClassicLoveLetterPlayer player) {
        LoveLetterPlayerDTO playerDTO = new LoveLetterPlayerDTO();
        playerDTO.setName(player.getName());
        playerDTO.setHand(convert(player.getHand()));
        playerDTO.setPosition(player.getPosition());
        return playerDTO;
    }
}
