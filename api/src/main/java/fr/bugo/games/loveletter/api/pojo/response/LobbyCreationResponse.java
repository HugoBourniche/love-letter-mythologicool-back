package fr.bugo.games.loveletter.api.pojo.response;

import fr.bugo.games.loveletter.dto.lobbycore.LobbyDTO;
import fr.bugo.games.loveletter.dto.lobbycore.UserDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class LobbyCreationResponse implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private LobbyDTO lobby;
    private String currentUserName;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LobbyCreationResponse(LobbyDTO lobby, String currentUserName) {
        this.lobby = lobby;
        this.currentUserName = currentUserName;
    }

}
