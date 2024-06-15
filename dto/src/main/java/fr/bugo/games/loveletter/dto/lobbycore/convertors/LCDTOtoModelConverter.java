package fr.bugo.games.loveletter.dto.lobbycore.convertors;

import fr.bugo.games.loveletter.dto.gamecore.gamemanager.gameoptions.GameOptionsRangesDTO;
import fr.bugo.games.loveletter.dto.gamecore.gamemanager.gameoptions.LoveLetterGameOptionsDTO;
import fr.bugo.games.loveletter.dto.lobbycore.LobbyUserDTO;
import fr.bugo.games.loveletter.dto.lobbycore.UserDTO;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.lobbycore.models.users.LobbyUser;
import fr.bugo.games.loveletter.shareddata.models.User;
import fr.bugo.games.loveletter.shareddata.models.gameoptions.GameOptionsRanges;

import java.util.ArrayList;
import java.util.List;

public class LCDTOtoModelConverter {

    // *****************************************************************************************************************
    // CONVERT USERS
    // *****************************************************************************************************************

    public static User convert(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        return user;
    }

    public static List<User> convertUsers(List<UserDTO> usersDTO) {
        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : usersDTO) {
            users.add(convert(userDTO));
        }
        return users;
    }

    public static List<LobbyUser> convert(List<LobbyUserDTO> usersDTO) {
        List<LobbyUser> lobbyUsers = new ArrayList<>();
        for (LobbyUserDTO userDTO : usersDTO) {
            lobbyUsers.add(convert(userDTO));
        }
        return lobbyUsers;
    }

    public static LobbyUser convert(LobbyUserDTO userDTO) {
        LobbyUser lobbyUser = new LobbyUser();
        lobbyUser.setName(userDTO.getName());
        lobbyUser.setReady(userDTO.isReady());
        lobbyUser.setOwner(userDTO.isOwner());
        return lobbyUser;
    }

    // *****************************************************************************************************************
    // CONVERT OPTIONS
    // *****************************************************************************************************************

    public static ClassicLoveLetterGameOptions convert(LoveLetterGameOptionsDTO gameOptionsDTO) {
        ClassicLoveLetterGameOptions gameOptions = new ClassicLoveLetterGameOptions();
        gameOptions.setMaxPlayers(gameOptionsDTO.getMaxPlayers());
        gameOptions.setRanges(convert(gameOptionsDTO.getRanges()));
        return gameOptions;
    }

    public static GameOptionsRanges convert(GameOptionsRangesDTO rangesDTO) {
        GameOptionsRanges gameOptionsRanges = new GameOptionsRanges();
        int min = 10000;
        int max = -10000;
        for (String count : rangesDTO.getNbPlayersChoices()) {
            int countValue = Integer.parseInt(count);
            if (countValue < min) {
                min = countValue;
            } else if (countValue > max) {
                max = countValue;
            }
        }
        gameOptionsRanges.setMinPlayersChoice(min);
        gameOptionsRanges.setMaxPlayersChoice(max);
        return gameOptionsRanges;
    }
}
