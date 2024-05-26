package fr.bugo.games.loveletter.gamecore;

import fr.bugo.games.loveletter.gamecore.model.gamemanager.ClassicLoveLetterGameManager;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class ClassicLoveLetterGameManagerTest {

    private List<ClassicLoveLetterPlayer> players = new ArrayList<>();

    @BeforeEach
    public void beforeEach() {
        players.add(new ClassicLoveLetterPlayer("Théo", 1));
        players.add(new ClassicLoveLetterPlayer("Mélanie", 2));
        players.add(new ClassicLoveLetterPlayer("Thomas", 3));
        players.add(new ClassicLoveLetterPlayer("Lilian", 4));
        players.add(new ClassicLoveLetterPlayer("Rémy", 5));
        players.add(new ClassicLoveLetterPlayer("Quentin", 6));
        players.add(new ClassicLoveLetterPlayer("Lysiane", 7));
        players.add(new ClassicLoveLetterPlayer("Clément", 8));
        players.add(new ClassicLoveLetterPlayer("Christophe", 9));
        players.add(new ClassicLoveLetterPlayer("Maxence", 10));
        players.add(new ClassicLoveLetterPlayer("Matthieu", 11));
        players.add(new ClassicLoveLetterPlayer("Hugo", 12));
    }

    @ParameterizedTest
    @CsvSource(value = {"2:15", "3:17", "4:16", "5:15", "6:14"}, delimiter = ':')
    public void nbPlayersTest(int nbPlayers, int expectedCardsInPile) {
        ClassicLoveLetterGameOptions options = new ClassicLoveLetterGameOptions();
        addPlayers(options, nbPlayers);
        ClassicLoveLetterGameManager gm = new ClassicLoveLetterGameManager();
        gm.initGame(options);
        System.out.println(gm);
        Assertions.assertEquals(expectedCardsInPile, gm.getCardPile().size(), "The stack does not have the right number of cards");
        for (ClassicLoveLetterPlayer player : gm.getPlayers()) {
            Assertions.assertEquals(1, player.getHand().size(), player.getName() + " must have only 1 card in their hands");
        }
    }

    private void addPlayers(ClassicLoveLetterGameOptions options, int nbPlayers) {
        for (int i = 0; i < nbPlayers; i++) {
            options.getPlayers().add(players.get(i));
        }
    }
}
