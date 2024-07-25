package fr.bugo.games.loveletter.api.services;

import fr.bugo.games.loveletter.gamecore.exceptions.EmptyCardStackException;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.AClassicLoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.ClassicLoveLetterGameManager;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.lobbycore.exceptions.NoLobbyException;
import fr.bugo.games.loveletter.shareddata.exceptions.NoUserException;
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

    public void initializeGame(String lobbyKey, ClassicLoveLetterGameOptions gameOptions, List<User> players) {
        ClassicLoveLetterGameManager gameManager = new ClassicLoveLetterGameManager();
        gameManager.setAccessKey(lobbyKey);
        gameManager.initGame(gameOptions, players);
        gameManagersMap.put(lobbyKey, gameManager);
    }

    public AClassicLoveLetterCard drawCard(String lobbyKey, String playerName) throws NoLobbyException, NoUserException, EmptyCardStackException {
        ClassicLoveLetterGameManager manager = getGameManager(lobbyKey);
        return manager.dealCardToPlayer(playerName);
    }

    // GETTERS

    public ClassicLoveLetterGameManager getGameManager(String lobbyKey) throws NoLobbyException {
        if (!gameManagersMap.containsKey(lobbyKey)) {
            throw new NoLobbyException(lobbyKey);
        }
        return gameManagersMap.get(lobbyKey);
    }
}
