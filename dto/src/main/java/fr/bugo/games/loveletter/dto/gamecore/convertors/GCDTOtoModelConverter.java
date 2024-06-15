package fr.bugo.games.loveletter.dto.gamecore.convertors;

import fr.bugo.games.loveletter.dto.gamecore.LoveLetterCardDTO;
import fr.bugo.games.loveletter.dto.gamecore.gamemanager.gameoptions.LoveLetterGameOptionsDTO;
import fr.bugo.games.loveletter.dto.gamecore.player.LoveLetterPlayerDTO;
import fr.bugo.games.loveletter.gamecore.factory.card.ClassicLoveLetterCardFactory;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.AClassicLoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;
import fr.bugo.games.loveletter.shareddata.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GCDTOtoModelConverter {

    // *****************************************************************************************************************
    // CONVERT OPTIONS
    // *****************************************************************************************************************

    public static ClassicLoveLetterGameOptions convert(LoveLetterGameOptionsDTO gameOptionsDTO) {
        ClassicLoveLetterGameOptions gameOptions = new ClassicLoveLetterGameOptions();
        return gameOptions;
    }

    // *****************************************************************************************************************
    // CONVERT PLAYERS
    // *****************************************************************************************************************

    public static List<ClassicLoveLetterPlayer> convertPlayers(List<LoveLetterPlayerDTO> playersDTO) {
        List<ClassicLoveLetterPlayer> players = new ArrayList<>();
        for (LoveLetterPlayerDTO playerDTO : playersDTO) {
            players.add(convert(playerDTO));
        }
        return players;
    }

    public static ClassicLoveLetterPlayer convert(LoveLetterPlayerDTO playerDTO) {
        ClassicLoveLetterPlayer player = new ClassicLoveLetterPlayer();
        User user = new User(playerDTO.getName());
        player.setUser(user); // TODO Fix this
        player.setPosition(playerDTO.getPosition());
        player.setHand(convert(playerDTO.getHand()));
        player.setNbFavorPeace(playerDTO.getNbFavorPeace());
        return player;
    }

    // *****************************************************************************************************************
    // CONVERT CARDS
    // *****************************************************************************************************************

    public static List<AClassicLoveLetterCard> convert(List<LoveLetterCardDTO> cardsDTO) {
        List<AClassicLoveLetterCard> cards = new ArrayList<>();
        for (LoveLetterCardDTO card : cardsDTO) {
            cards.add(convert(card));
        }
        return cards;
    }

    public static AClassicLoveLetterCard convert(LoveLetterCardDTO cardDTO) {
        AClassicLoveLetterCard card = ClassicLoveLetterCardFactory.buildCard(cardDTO.getName());
        card.setId(UUID.fromString(cardDTO.getId()));
        card.setFacingDown(cardDTO.isFacingDown());
        return card;
    }
}
