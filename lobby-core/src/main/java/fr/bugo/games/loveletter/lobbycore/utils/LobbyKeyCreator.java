package fr.bugo.games.loveletter.lobbycore.utils;


import java.util.Random;
import java.util.Set;

public class LobbyKeyCreator {

    public static String generateKey(Set<String> existingKeys) {
        String key = "";
        do {
            key += LobbyKeyCreator.generateLetter();
            key += LobbyKeyCreator.generateLetter();
            key += LobbyKeyCreator.generateLetter();
            key += '-';
            key += LobbyKeyCreator.generateLetter();
            key += LobbyKeyCreator.generateLetter();
            key += LobbyKeyCreator.generateLetter();
        } while(existingKeys.contains(key));

        return key;
    }

    public static Character generateLetter() {
        Random random = new Random();

        // Générer un nombre aléatoire entre 0 et 25 (inclus)
        int randomNumber = random.nextInt(26);

        // Convertir ce nombre en lettre de l'alphabet
        return (char) ('A' + randomNumber);
    }
}
