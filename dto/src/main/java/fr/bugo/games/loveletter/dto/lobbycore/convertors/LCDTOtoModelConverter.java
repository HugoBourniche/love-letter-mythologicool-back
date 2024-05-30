package fr.bugo.games.loveletter.dto.lobbycore.convertors;

import fr.bugo.games.loveletter.dto.gamecore.gamemanager.gameoptions.LoveLetterGameOptionsDTO;
import fr.bugo.games.loveletter.dto.lobbycore.LobbyUserDTO;
import fr.bugo.games.loveletter.dto.lobbycore.UserDTO;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.lobbycore.models.users.LobbyUser;
import fr.bugo.games.loveletter.shareddata.models.User;

public class LCDTOtoModelConverter {

    // *****************************************************************************************************************
    // CONVERT USERS
    // *****************************************************************************************************************

    public static User convert(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        return user;
    }

    public static LobbyUser convert(LobbyUserDTO userDTO) {
        LobbyUser lobbyUser = new LobbyUser();
        lobbyUser.setName(userDTO.getName());
        lobbyUser.setReady(userDTO.isReady());
        return lobbyUser;
    }

    // *****************************************************************************************************************
    // CONVERT OPTIONS
    // *****************************************************************************************************************

    public static ClassicLoveLetterGameOptions convert(LoveLetterGameOptionsDTO gameOptionsDTO) {
        ClassicLoveLetterGameOptions gameOptions = new ClassicLoveLetterGameOptions();
        gameOptions.setMaxPlayers(gameOptionsDTO.getMaxPlayers());
        return gameOptions;
    }


}
