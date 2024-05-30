package fr.bugo.games.loveletter.api.services;

import fr.bugo.games.loveletter.lobbycore.exceptions.NoLobbyException;
import fr.bugo.games.loveletter.lobbycore.models.lobby.Lobby;
import fr.bugo.games.loveletter.shareddata.enums.GameToPlay;
import fr.bugo.games.loveletter.shareddata.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LobbyServiceTest {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private final List<User> users = new ArrayList<User>();
    LobbyService lobbyService;
    // *****************************************************************************************************************
    // BEFORE
    // *****************************************************************************************************************

    @BeforeEach
    public void beforeEach() {
        users.add(new User("Théo"));
        users.add(new User("Mélanie"));
        users.add(new User("Thomas"));
        users.add(new User("Lilian"));
        users.add(new User("Rémy"));
        users.add(new User("Quentin"));
        users.add(new User("Lysiane"));
        users.add(new User("Clément"));
        users.add(new User("Christophe"));
        users.add(new User("Matthieu"));
        users.add(new User("Hugo"));
        lobbyService = new LobbyService();
        Assertions.assertNotNull(lobbyService);
    }

    // *****************************************************************************************************************
    // TESTS
    // *****************************************************************************************************************

    @Test
    public void lobbyCreationTest() {
        User owner = users.get(0);
        Lobby lobby = lobbyService.createLobby(owner, GameToPlay.CLASSIC);
        Assertions.assertEquals(lobby.getOwner(), owner);
        Assertions.assertTrue(lobby.getUsers().isEmpty());
    }

    @Test
    public void validLobbyJoinTest() {
        User owner = users.get(0);
        Lobby lobby = lobbyService.createLobby(owner, GameToPlay.CLASSIC);
        Assertions.assertEquals(lobby.getOwner(), owner);
        Assertions.assertTrue(lobby.getUsers().isEmpty());
        try {
            lobbyService.joinLobby(lobby.getKey(), users.get(1));
        } catch (NoLobbyException e) {
            Assertions.fail("The lobby should exist");
        }
        Assertions.assertEquals(1, lobby.getUsers().size());
    }

    @Test
    public void invalidLobbyJoinTest() {
        Lobby lobby = lobbyService.createLobby(users.get(0), GameToPlay.CLASSIC);
        try {
            lobbyService.joinLobby("WRONGKEY", users.get(1));
            Assertions.fail("The lobby should not");
        } catch (NoLobbyException ignore) {}
    }
}
