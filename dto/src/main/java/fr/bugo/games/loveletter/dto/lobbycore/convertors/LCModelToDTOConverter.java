package fr.bugo.games.loveletter.dto.lobbycore.convertors;

import fr.bugo.games.loveletter.dto.lobbycore.LobbyDTO;
import fr.bugo.games.loveletter.dto.lobbycore.LobbyUserDTO;
import fr.bugo.games.loveletter.dto.lobbycore.UserDTO;
import fr.bugo.games.loveletter.lobbycore.models.Lobby;
import fr.bugo.games.loveletter.lobbycore.models.users.LobbyUser;
import fr.bugo.games.loveletter.lobbycore.models.users.User;

import java.util.ArrayList;
import java.util.List;

public class LCModelToDTOConverter {

    // *****************************************************************************************************************
    // CONVERT LOBBY
    // *****************************************************************************************************************

    public static LobbyDTO convert(Lobby lobby) {
        LobbyDTO lobbyDTO = new LobbyDTO();
        lobbyDTO.setKey(lobby.getKey());
        lobbyDTO.setUsers(convert(lobby.getUsers()));
        lobbyDTO.setOwner(convert(lobby.getOwner()));
        return lobbyDTO;
    }

    // *****************************************************************************************************************
    // CONVERT USERS
    // *****************************************************************************************************************

    public static List<LobbyUserDTO> convert(List<LobbyUser> users) {
        List<LobbyUserDTO> usersDTO = new ArrayList<>();
        for (LobbyUser user : users) {
            usersDTO.add(convert(user));
        }
        return usersDTO;
    }

    public static LobbyUserDTO convert(LobbyUser user) {
        LobbyUserDTO userDTO = new LobbyUserDTO();
        userDTO.setName(user.getName());
        userDTO.setReady(user.isReady());
        return userDTO;
    }

    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        return userDTO;
    }
}
