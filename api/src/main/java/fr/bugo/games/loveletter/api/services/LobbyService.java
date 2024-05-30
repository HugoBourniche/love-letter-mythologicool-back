package fr.bugo.games.loveletter.api.services;

import fr.bugo.games.loveletter.gamecore.factory.GameOptionFactory;
import fr.bugo.games.loveletter.lobbycore.exceptions.UniqueNameException;
import fr.bugo.games.loveletter.lobbycore.exceptions.NoLobbyException;
import fr.bugo.games.loveletter.lobbycore.models.lobby.Lobby;
import fr.bugo.games.loveletter.lobbycore.models.users.LobbyUser;
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
        try {
            lobby.addNewUser(new LobbyUser(owner));
        } catch (UniqueNameException e) {
            e.printStackTrace(); // Should not be triggered here
        }
        lobby.setGameOptions(GameOptionFactory.createGameOptions(game));
        this.lobbiesMap.put(lobby.getKey(), lobby);
        LOGGER.info("Lobby [" + lobby.getKey() + "] created by " + owner.getName());
        return lobby;
    }

    public Lobby getLobby(String key) throws NoLobbyException {
        if (!lobbiesMap.containsKey(key)) {
            throw new NoLobbyException(key);
        }
        return lobbiesMap.get(key);
    }

    public Lobby joinLobby(String key, User user) throws NoLobbyException, UniqueNameException {
        Lobby lobby = getLobby(key);
        LobbyUser lobbyUser = new LobbyUser(user);
        lobby.addNewUser(lobbyUser);
        return lobby;
    }
}
