package fr.bugo.games.loveletter.api.pojo.response;

import fr.bugo.games.loveletter.dto.gamecore.gamemanager.gameoptions.LoveLetterGameOptionsDTO;
import fr.bugo.games.loveletter.dto.lobbycore.UserDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LoveLetterGameInitializationRequest implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private String lobbyKey;
    private LoveLetterGameOptionsDTO gameOptionsDTO;
    private List<UserDTO> players;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LoveLetterGameInitializationRequest() {}

}
