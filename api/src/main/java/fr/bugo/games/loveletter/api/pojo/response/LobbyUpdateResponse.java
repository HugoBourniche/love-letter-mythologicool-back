package fr.bugo.games.loveletter.api.pojo.response;

import fr.bugo.games.loveletter.dto.lobbycore.LobbyDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class LobbyUpdateResponse implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    LobbyDTO lobby;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LobbyUpdateResponse(LobbyDTO lobby) {
        this.lobby = lobby;
    }

}
