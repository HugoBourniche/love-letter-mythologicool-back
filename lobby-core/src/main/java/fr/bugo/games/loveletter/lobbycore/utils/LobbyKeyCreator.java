package fr.bugo.games.loveletter.lobbycore.utils;


import java.util.Set;

public class LobbyKeyCreator {

    public static String generateKey(Set<String> existingKeys) {
        String key;
        do {
            key = "OUI"; // TODO Generator
        } while(existingKeys.contains(key));

        return "QUOI-FEUR";
    }
}
