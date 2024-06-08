package fr.bugo.games.loveletter.lobbycore;

import fr.bugo.games.loveletter.lobbycore.utils.LobbyKeyCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LobbyKeyCreatorTest {

    private final int NB_ITERATION = 1000;
    @Test
    public void keyGenerationTest() {
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < NB_ITERATION; i++) {
            String key = LobbyKeyCreator.generateKey(stringSet);
            System.out.println(key);
            Assertions.assertTrue(key.matches("[A-Z]{3}-[A-Z]{3}"), "The key must be format XXX-XXX");
            Assertions.assertFalse(stringSet.contains(key));
            stringSet.add(key);
        }
    }

    @Test
    public void letterGenerationSuccessTest() {
        for (int i = 0; i < NB_ITERATION; i++) {
            Character alphabet = LobbyKeyCreator.generateLetter();
            System.out.println(alphabet);
            Assertions.assertTrue(alphabet.toString().matches("[A-Z]"), "Letter must be between A and Z");
        }
    }

}
