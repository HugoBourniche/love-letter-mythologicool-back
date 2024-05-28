package fr.bugo.games.loveletter.api.pojo.request;

import fr.bugo.games.loveletter.dto.lobbycore.UserDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class LobbyCreationRequest implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private UserDTO owner;
}
