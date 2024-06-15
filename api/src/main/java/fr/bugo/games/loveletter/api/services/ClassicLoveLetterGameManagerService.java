package fr.bugo.games.loveletter.api.services;

import fr.bugo.games.loveletter.gamecore.model.gamemanager.ClassicLoveLetterGameManager;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.shareddata.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ClassicLoveLetterGameManagerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LobbyService.class);

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private final HashMap<String, ClassicLoveLetterGameManager> gameManagersMap = new HashMap<>();

    // *****************************************************************************************************************
    // PUBLIC METHODS
    // *****************************************************************************************************************

    public ClassicLoveLetterGameManager initializeGame(String lobbyKey, ClassicLoveLetterGameOptions gameOptions, List<User> players) {
        ClassicLoveLetterGameManager gameManager = new ClassicLoveLetterGameManager();
        gameManager.initGame(gameOptions, players);
        gameManagersMap.put(lobbyKey, gameManager);
        return gameManager;
    }
}
