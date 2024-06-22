package fr.bugo.games.loveletter.dto;

import fr.bugo.games.loveletter.dto.gamecore.LoveLetterCardDTO;
import fr.bugo.games.loveletter.dto.gamecore.convertors.GCModelToDTOConverter;
import fr.bugo.games.loveletter.dto.gamecore.player.LoveLetterPlayerDTO;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;
import fr.bugo.games.loveletter.shareddata.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GCModelToDTOConverterTest {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private final List<ClassicLoveLetterPlayer> players = new ArrayList<>();

    // *****************************************************************************************************************
    // BEFORE
    // *****************************************************************************************************************


    @BeforeEach
    public void beforeEach() {
        this.players.add(new ClassicLoveLetterPlayer(new User("Theo"), 0));
        this.players.add(new ClassicLoveLetterPlayer(new User("Thomas"), 1));
        this.players.add(new ClassicLoveLetterPlayer(new User("Melanie"), 2));
        this.players.add(new ClassicLoveLetterPlayer(new User("Lilian"), 3));
        this.players.add(new ClassicLoveLetterPlayer(new User("Remi"), 4));
        this.players.add(new ClassicLoveLetterPlayer(new User("Hugo"), 5));
    }

    // *****************************************************************************************************************
    // TESTS
    // *****************************************************************************************************************

    @Test
    public void other5Players0Tests() {
        ClassicLoveLetterPlayer currentPlayer = this.players.get(0);
        List<LoveLetterPlayerDTO> otherPlayers = GCModelToDTOConverter.convertOtherPlayers(this.players, currentPlayer, true);
        Assertions.assertEquals(5, otherPlayers.size(), "The list must contains all players except the current player " + currentPlayer.getUser().getName());
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(0), "Thomas");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(1), "Melanie");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(2), "Lilian");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(3), "Remi");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(4), "Hugo");
    }

    @Test
    public void other5Players1Tests() {
        ClassicLoveLetterPlayer currentPlayer = this.players.get(1);
        List<LoveLetterPlayerDTO> otherPlayers = GCModelToDTOConverter.convertOtherPlayers(this.players, currentPlayer, true);
        Assertions.assertEquals(5, otherPlayers.size(), "The list must contains all players except the current player " + currentPlayer.getUser().getName());
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(0), "Melanie");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(1), "Lilian");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(2), "Remi");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(3), "Hugo");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(4), "Theo");
    }

    @Test
    public void other5Players2Tests() {
        ClassicLoveLetterPlayer currentPlayer = this.players.get(2);
        List<LoveLetterPlayerDTO> otherPlayers = GCModelToDTOConverter.convertOtherPlayers(this.players, currentPlayer, true);
        Assertions.assertEquals(5, otherPlayers.size(), "The list must contains all players except the current player " + currentPlayer.getUser().getName());
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(0), "Lilian");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(1), "Remi");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(2), "Hugo");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(3), "Theo");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(4), "Thomas");
    }

    @Test
    public void other5Players3Tests() {
        ClassicLoveLetterPlayer currentPlayer = this.players.get(3);
        List<LoveLetterPlayerDTO> otherPlayers = GCModelToDTOConverter.convertOtherPlayers(this.players, currentPlayer, true);
        Assertions.assertEquals(5, otherPlayers.size(), "The list must contains all players except the current player " + currentPlayer.getUser().getName());
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(0), "Remi");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(1), "Hugo");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(2), "Theo");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(3), "Thomas");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(4), "Melanie");
    }

    @Test
    public void other5Players4Tests() {
        ClassicLoveLetterPlayer currentPlayer = this.players.get(4);
        List<LoveLetterPlayerDTO> otherPlayers = GCModelToDTOConverter.convertOtherPlayers(this.players, currentPlayer, true);
        Assertions.assertEquals(5, otherPlayers.size(), "The list must contains all players except the current player " + currentPlayer.getUser().getName());
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(0), "Hugo");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(1), "Theo");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(2), "Thomas");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(3), "Melanie");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(4), "Lilian");
    }

    @Test
    public void other5Players5Tests() {
        ClassicLoveLetterPlayer currentPlayer = this.players.get(5);
        List<LoveLetterPlayerDTO> otherPlayers = GCModelToDTOConverter.convertOtherPlayers(this.players, currentPlayer, true);
        Assertions.assertEquals(5, otherPlayers.size(), "The list must contains all players except the current player " + currentPlayer.getUser().getName());
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(0), "Theo");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(1), "Thomas");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(2), "Melanie");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(3), "Lilian");
        this.checkOtherPlayerStatusWithHiddenCard(otherPlayers.get(4), "Remi");
    }

    @Test
    public void other5PlayersWithNoneHiddenCardsTests() {
        ClassicLoveLetterPlayer currentPlayer = this.players.get(5);
        List<LoveLetterPlayerDTO> otherPlayers = GCModelToDTOConverter.convertOtherPlayers(this.players, currentPlayer, false);
        Assertions.assertEquals(5, otherPlayers.size(), "The list must contains all players except the current player " + currentPlayer.getUser().getName());
        this.checkOtherPlayerStatusWithShownCard(otherPlayers.get(0), "Theo");
        this.checkOtherPlayerStatusWithShownCard(otherPlayers.get(1), "Thomas");
        this.checkOtherPlayerStatusWithShownCard(otherPlayers.get(2), "Melanie");
        this.checkOtherPlayerStatusWithShownCard(otherPlayers.get(3), "Lilian");
        this.checkOtherPlayerStatusWithShownCard(otherPlayers.get(4), "Remi");
    }

    // *****************************************************************************************************************
    // UTILS
    // *****************************************************************************************************************

    private void checkOtherPlayerStatusWithHiddenCard(LoveLetterPlayerDTO player, String name) {
        this.checkOtherPlayer(player, name, false);
    }

    private void checkOtherPlayerStatusWithShownCard(LoveLetterPlayerDTO playerDTO, String name) {
        this.checkOtherPlayer(playerDTO, name, true);
    }

    private void checkOtherPlayer(LoveLetterPlayerDTO player, String name, boolean shouldHandBeHidden) {
        Assertions.assertEquals(name, player.getUser().getName());
        for (LoveLetterCardDTO cardDTO : player.getHand()) {
            if (shouldHandBeHidden) {
                Assertions.assertEquals(-1, cardDTO.getValue(), "The card of " + name + " must be hidden");
            } else {
                Assertions.assertNotEquals(-1, cardDTO.getValue(), "The card of " + name + " must be shown");
            }
        }
    }
}
