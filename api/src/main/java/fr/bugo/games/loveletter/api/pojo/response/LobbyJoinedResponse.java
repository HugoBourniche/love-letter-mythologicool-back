package fr.bugo.games.loveletter.api.pojo.response;

import fr.bugo.games.loveletter.dto.lobbycore.LobbyDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class LobbyJoinedResponse implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    LobbyDTO lobbyDTO;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LobbyJoinedResponse() {}

    public LobbyJoinedResponse(LobbyDTO lobbyDTO) {
        this.lobbyDTO = lobbyDTO;
    }
}
