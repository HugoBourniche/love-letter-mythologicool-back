package fr.bugo.games.loveletter.api.services;

import fr.bugo.games.loveletter.gamecore.factory.GameOptionFactory;
import fr.bugo.games.loveletter.lobbycore.exceptions.MultipleOwnerException;
import fr.bugo.games.loveletter.lobbycore.exceptions.NoOwnerException;
import fr.bugo.games.loveletter.lobbycore.exceptions.NoUserInLobbyException;
import fr.bugo.games.loveletter.lobbycore.exceptions.NotReadyPlayerException;
import fr.bugo.games.loveletter.lobbycore.exceptions.UniqueNameException;
import fr.bugo.games.loveletter.lobbycore.exceptions.NoLobbyException;
import fr.bugo.games.loveletter.lobbycore.models.lobby.Lobby;
import fr.bugo.games.loveletter.lobbycore.models.lobby.LobbyItem;
import fr.bugo.games.loveletter.lobbycore.models.users.LobbyUser;
import fr.bugo.games.loveletter.shareddata.enums.GameToPlay;
import fr.bugo.games.loveletter.shareddata.models.User;
import fr.bugo.games.loveletter.lobbycore.utils.LobbyKeyCreator;
import fr.bugo.games.loveletter.shareddata.models.gameoptions.AGameOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        try {
            lobby.addNewUser(new LobbyUser(owner, true));
        } catch (UniqueNameException ignore) {}
        lobby.setGameOptions(GameOptionFactory.createGameOptions(game));
        this.lobbiesMap.put(lobby.getKey(), lobby);
        return lobby;
    }

    public Lobby joinLobby(String key, User user) throws NoLobbyException, UniqueNameException {
        Lobby lobby = getLobby(key);
        LobbyUser lobbyUser = new LobbyUser(user);
        lobby.addNewUser(lobbyUser);
        return lobby;
    }

    public Lobby userSwitchReady(String key, String userName) throws NoLobbyException, NoUserInLobbyException {
        Lobby lobby = getLobby(key);
        LobbyUser lobbyUser = getUser(key, userName);
        lobbyUser.setReady(!lobbyUser.isReady());
        return lobby;
    }

    public boolean updateLobbyGameOptions(String lobbyKey, AGameOptions gameOptions) throws NoLobbyException {
        Lobby lobby = this.getLobby(lobbyKey);
        lobby.setGameOptions(gameOptions);
        return true;
    }

    public List<User> startGame(String lobbyKey) throws NoLobbyException, NotReadyPlayerException {
        Lobby lobby = this.getLobby(lobbyKey);
        for (LobbyUser lobbyUser : lobby.getUsers()) {
            if (!lobbyUser.isOwner() && !lobbyUser.isReady()) {
                throw new NotReadyPlayerException();
            }
        }
        lobby.setInGame(true);
        return lobby.getUsers().stream().map(lobbyUser -> new User(lobbyUser.getName())).collect(Collectors.toList());
    }

    // GETTERS

    public Lobby getLobby(String key) throws NoLobbyException {
        if (!lobbiesMap.containsKey(key)) {
            throw new NoLobbyException(key);
        }
        return lobbiesMap.get(key);
    }

    public List<LobbyItem> getLobbyItemList() {
        List<LobbyItem> lobbyItemList = new ArrayList<>();
        for (Lobby lobby : this.lobbiesMap.values()) {
            LobbyItem item;
            try {
                item = new LobbyItem(lobby.getKey(), lobby.getOwner());
                lobbyItemList.add(item);
            } catch (NoOwnerException | MultipleOwnerException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return lobbyItemList;
    }

    public List<LobbyUser> getUsers(String lobbyKey) throws NoLobbyException {
        Lobby lobby = this.getLobby(lobbyKey);
        return lobby.getUsers();
    }

    public LobbyUser getUser(String lobbyKey, String userName) throws NoLobbyException, NoUserInLobbyException {
        Lobby lobby = this.getLobby(lobbyKey);
        Optional<LobbyUser> opLobbyUser = lobby.getUsers().stream().filter(u -> u.getName().equals(userName)).findFirst();
        if (opLobbyUser.isEmpty()) {
            throw new NoUserInLobbyException(lobbyKey, userName);
        }
        return opLobbyUser.get();
    }

    public AGameOptions getGameOptions(String lobbyKey) throws NoLobbyException {
        Lobby lobby = this.getLobby(lobbyKey);
        return lobby.getGameOptions();
    }
}
