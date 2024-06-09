package fr.bugo.games.loveletter.api.services;

import fr.bugo.games.loveletter.lobbycore.exceptions.MultipleOwnerException;
import fr.bugo.games.loveletter.lobbycore.exceptions.NoOwnerException;
import fr.bugo.games.loveletter.lobbycore.exceptions.UniqueNameException;
import fr.bugo.games.loveletter.lobbycore.exceptions.NoLobbyException;
import fr.bugo.games.loveletter.lobbycore.models.lobby.Lobby;
import fr.bugo.games.loveletter.lobbycore.models.users.LobbyUser;
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
        LobbyUser lobbyOwner = new LobbyUser(owner, true);
        Lobby lobby = lobbyService.createLobby(owner, GameToPlay.CLASSIC);
        try {
            Assertions.assertEquals(lobby.getOwner(), lobbyOwner);
        } catch (NoOwnerException | MultipleOwnerException e) {
            Assertions.fail(e.getMessage());
        }
        Assertions.assertEquals(1, lobby.getUsers().size());
    }

    @Test
    public void validLobbyJoinTest() {
        User owner = users.get(0);
        LobbyUser lobbyOwner = new LobbyUser(owner, true);
        Lobby lobby = lobbyService.createLobby(owner, GameToPlay.CLASSIC);
        try {
            Assertions.assertEquals(lobby.getOwner(), lobbyOwner);
        } catch (NoOwnerException | MultipleOwnerException e) {
            Assertions.fail(e.getMessage());
        }
        Assertions.assertEquals(1, lobby.getUsers().size());
        try {
            lobbyService.joinLobby(lobby.getKey(), users.get(1));
        } catch (NoLobbyException e) {
            Assertions.fail("The lobby should exist");
        } catch (UniqueNameException e) {
            Assertions.fail("Should not have the same name");
        }
        Assertions.assertEquals(2, lobby.getUsers().size());
    }

    @Test
    public void invalidLobbyJoinExistingNameTest() {
        Lobby lobby = lobbyService.createLobby(users.get(0), GameToPlay.CLASSIC);
        try {
            lobbyService.joinLobby(lobby.getKey(), users.get(1));
            lobbyService.joinLobby(lobby.getKey(), users.get(1));
            Assertions.fail("The lobby should not be valid");
        } catch (NoLobbyException e) {
            Assertions.fail("Lobby should exists");
        } catch (UniqueNameException ignore) {}
        Assertions.assertEquals(2, lobby.getUsers().size());
    }

    @Test
    public void invalidLobbyJoinWrongKeyTest() {
        Lobby lobby = lobbyService.createLobby(users.get(0), GameToPlay.CLASSIC);
        try {
            lobbyService.joinLobby("WRONGKEY", users.get(1));
            Assertions.fail("The lobby should not ne valid");
        } catch (NoLobbyException ignore) {
        } catch (UniqueNameException e) {
            Assertions.fail("Should not have the same name");
        }
        Assertions.assertEquals(1, lobby.getUsers().size());

    }
}
