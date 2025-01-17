package fr.bugo.games.loveletter.gamecore;

import fr.bugo.games.loveletter.gamecore.model.gamemanager.ClassicLoveLetterGameManager;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;
import fr.bugo.games.loveletter.lobbycore.models.users.LobbyUser;
import fr.bugo.games.loveletter.shareddata.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class ClassicLoveLetterGameManagerTest {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private final List<User> users = new ArrayList<>();
    private final List<ClassicLoveLetterPlayer> players = new ArrayList<>();

    // *****************************************************************************************************************
    // BEFORE
    // *****************************************************************************************************************

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

    // *****************************************************************************************************************
    // TESTS
    // *****************************************************************************************************************

    @ParameterizedTest
    @CsvSource(value = {"2:15", "3:17", "4:16", "5:15", "6:14"}, delimiter = ':')
    public void nbPlayersTest(int nbPlayers, int expectedCardsInPile) {
        ClassicLoveLetterGameOptions options = new ClassicLoveLetterGameOptions();
        List<User> users = fetchUsers(nbPlayers);
        ClassicLoveLetterGameManager gm = new ClassicLoveLetterGameManager();
        gm.initGame(options, users);
        System.out.println(gm);
        Assertions.assertEquals(expectedCardsInPile, gm.getCardPile().size(), "The stack does not have the right number of cards");
        for (ClassicLoveLetterPlayer player : gm.getPlayers()) {
            Assertions.assertEquals(1, player.getHand().size(), player.getUser().getName() + " must have only 1 card in their hands");
        }
    }

    // *****************************************************************************************************************
    // UTILS
    // *****************************************************************************************************************

    private List<ClassicLoveLetterPlayer> fetchPlayers(int nbPlayers) {
        List<ClassicLoveLetterPlayer> currentPlayers = new ArrayList<>();
        for (int i = 0; i < nbPlayers; i++) {
            currentPlayers.add(players.get(i));
        }
        return currentPlayers;
    }

    private List<User> fetchUsers(int nbUsers) {
        List<User> currentUsers = new ArrayList<>();
        for (int i = 0; i < nbUsers; i++) {
            currentUsers.add(users.get(i));
        }
        return currentUsers;
    }
}
