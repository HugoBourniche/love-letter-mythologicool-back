package fr.bugo.games.loveletter.dto.lobbycore;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LobbyDTO implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private String key;
    private UserDTO owner;
    private List<LobbyUserDTO> users;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LobbyDTO() {}

}
