package fr.bugo.games.loveletter.gamecore;

import fr.bugo.games.loveletter.gamecore.model.gamemanager.ClassicLoveLetterGameManager;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class ClassicLoveLetterGameManagerTest {

    private static final List<ClassicLoveLetterPlayer> PLAYERS = new ArrayList<>();

    @BeforeAll
    public static void beforeAll() {
        PLAYERS.add(new ClassicLoveLetterPlayer("Théo", 1));
        PLAYERS.add(new ClassicLoveLetterPlayer("Mélanie", 2));
        PLAYERS.add(new ClassicLoveLetterPlayer("Thomas", 3));
        PLAYERS.add(new ClassicLoveLetterPlayer("Lilian", 4));
        PLAYERS.add(new ClassicLoveLetterPlayer("Rémy", 5));
        PLAYERS.add(new ClassicLoveLetterPlayer("Quentin", 6));
        PLAYERS.add(new ClassicLoveLetterPlayer("Lysiane", 7));
        PLAYERS.add(new ClassicLoveLetterPlayer("Clément", 8));
        PLAYERS.add(new ClassicLoveLetterPlayer("Christophe", 9));
        PLAYERS.add(new ClassicLoveLetterPlayer("Maxence", 10));
        PLAYERS.add(new ClassicLoveLetterPlayer("Matthieu", 11));
        PLAYERS.add(new ClassicLoveLetterPlayer("Hugo", 12));
    }

    @ParameterizedTest
    @CsvSource(value = {"2:15", "3:17", "4:16", "5:15", "6:14"}, delimiter = ':')
    public void nbPlayersTest(int nbPlayers, int expectedCardsInPile) {
        ClassicLoveLetterGameOptions options = new ClassicLoveLetterGameOptions();
        addPlayers(options, nbPlayers);
        ClassicLoveLetterGameManager gm = new ClassicLoveLetterGameManager();
        gm.initGame(options);
        System.out.println(gm);
        Assertions.assertEquals(expectedCardsInPile, gm.getCardPile().size());
    }

    private void addPlayers(ClassicLoveLetterGameOptions options, int nbPlayers) {
        for (int i = 0; i < nbPlayers; i++) {
            options.getPlayers().add(PLAYERS.get(i));
        }
    }
}
