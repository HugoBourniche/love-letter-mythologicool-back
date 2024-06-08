package fr.bugo.games.loveletter.dto.lobbycore.convertors;

import fr.bugo.games.loveletter.dto.gamecore.gamemanager.gameoptions.LoveLetterGameOptionsDTO;
import fr.bugo.games.loveletter.dto.lobbycore.LobbyDTO;
import fr.bugo.games.loveletter.dto.lobbycore.LobbyItemDTO;
import fr.bugo.games.loveletter.dto.lobbycore.LobbyUserDTO;
import fr.bugo.games.loveletter.dto.lobbycore.UserDTO;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.lobbycore.models.lobby.Lobby;
import fr.bugo.games.loveletter.lobbycore.models.lobby.LobbyItem;
import fr.bugo.games.loveletter.lobbycore.models.users.LobbyUser;
import fr.bugo.games.loveletter.shareddata.models.AGameOptions;
import fr.bugo.games.loveletter.shareddata.models.User;

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
        lobbyDTO.setOptions(convert(lobby.getGameOptions()));
        return lobbyDTO;
    }

    public static List<LobbyItemDTO> convertLobbyItemList(List<LobbyItem> lobbyItemList) {
        List<LobbyItemDTO> lobbyItemDTOList = new ArrayList<>();
        for (LobbyItem lobbyItem : lobbyItemList) {
            lobbyItemDTOList.add(convert(lobbyItem));
        }
        return lobbyItemDTOList;
    }

    public static LobbyItemDTO convert(LobbyItem lobbyItem) {
        LobbyItemDTO lobbyItemDTO = new LobbyItemDTO();
        lobbyItemDTO.setKey(lobbyItem.getKey());
        lobbyItemDTO.setOwner(convert(lobbyItem.getOwner()));
        return lobbyItemDTO;
    }

    // *****************************************************************************************************************
    // CONVERT OPTIONS
    // *****************************************************************************************************************

    public static LoveLetterGameOptionsDTO convert(AGameOptions gameOptionsDTO) {
        LoveLetterGameOptionsDTO gameOptions = new LoveLetterGameOptionsDTO();
        gameOptions.setMaxPlayers(gameOptionsDTO.getMaxPlayers());
        return gameOptions;
    }

    public static LoveLetterGameOptionsDTO convert(ClassicLoveLetterGameOptions gameOptionsDTO) {
        LoveLetterGameOptionsDTO gameOptions = convert((AGameOptions) gameOptionsDTO);
        return gameOptions;
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
