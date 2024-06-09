package fr.bugo.games.loveletter.api.pojo.response;

import fr.bugo.games.loveletter.dto.lobbycore.UserDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class LobbyJoinRequest implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private UserDTO user;
    private String lobbyKey;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LobbyJoinRequest() {}
}
