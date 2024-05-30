package fr.bugo.games.loveletter.gamecore;

import fr.bugo.games.loveletter.gamecore.model.gamemanager.ClassicLoveLetterGameManager;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;
import fr.bugo.games.loveletter.shareddata.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class ClassicLoveLetterGameManagerTest {

    private List<User> users = new ArrayList<User>();
    private List<ClassicLoveLetterPlayer> players = new ArrayList<>();

    @BeforeEach
    public void beforeEach() {
        users.add(new User("Théo"));
        users.add(new User("Mélanie"));
        users.add(new User("Thomas"));
        users.add(new User("Lilian"));
        users.add(new User("Rémy"));
        users.add(new User("Quentin"));
        users.add(new User("Lysiane"));
        users.add(new User("Clément"));
        users.add(new User("Christophe"));
        users.add(new User("Matthieu"));
        users.add(new User("Hugo"));
        for (int i = 0; i < users.size(); i++) {
            players.add(new ClassicLoveLetterPlayer(users.get(i), i));
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"2:15", "3:17", "4:16", "5:15", "6:14"}, delimiter = ':')
    public void nbPlayersTest(int nbPlayers, int expectedCardsInPile) {
        ClassicLoveLetterGameOptions options = new ClassicLoveLetterGameOptions();
        List<ClassicLoveLetterPlayer> players = addPlayers(nbPlayers);
        ClassicLoveLetterGameManager gm = new ClassicLoveLetterGameManager();
        gm.initGame(options, players);
        System.out.println(gm);
        Assertions.assertEquals(expectedCardsInPile, gm.getCardPile().size(), "The stack does not have the right number of cards");
        for (ClassicLoveLetterPlayer player : gm.getPlayers()) {
            Assertions.assertEquals(1, player.getHand().size(), player.getUser().getName() + " must have only 1 card in their hands");
        }
    }

    private List<ClassicLoveLetterPlayer> addPlayers(int nbPlayers) {
        List<ClassicLoveLetterPlayer> currentPlayers = new ArrayList<>();
        for (int i = 0; i < nbPlayers; i++) {
            currentPlayers.add(players.get(i));
        }
        return currentPlayers;
    }
}
