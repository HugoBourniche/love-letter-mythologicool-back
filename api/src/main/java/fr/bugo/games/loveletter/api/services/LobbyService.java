package fr.bugo.games.loveletter.api.services;

import fr.bugo.games.loveletter.gamecore.factory.GameOptionFactory;
import fr.bugo.games.loveletter.lobbycore.models.lobby.Lobby;
import fr.bugo.games.loveletter.shareddata.enums.GameToPlay;
import fr.bugo.games.loveletter.shareddata.models.User;
import fr.bugo.games.loveletter.lobbycore.utils.LobbyKeyCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LobbyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LobbyService.class);

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private final HashMap<String, Lobby> lobbiesMap = new HashMap<>();

    // *****************************************************************************************************************
    // PUBLIC METHODS
    // *****************************************************************************************************************

    public Lobby createLobby(User owner, GameToPlay game) {
        Lobby lobby = new Lobby();
        lobby.setKey(LobbyKeyCreator.generateKey(lobbiesMap.keySet()));
        lobby.setOwner(owner);
        lobby.setGameOptions(GameOptionFactory.createGameOptions(game));
        this.lobbiesMap.put(lobby.getKey(), lobby);
        LOGGER.info("Lobby [" + lobby.getKey() + "] created by " + owner.getName());
        return lobby;
    }

}
