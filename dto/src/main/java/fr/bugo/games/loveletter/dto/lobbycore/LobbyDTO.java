package fr.bugo.games.loveletter.dto.lobbycore;

import fr.bugo.games.loveletter.dto.gamecore.gamemanager.gameoptions.AGameOptionsDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LobbyDTO implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private String key;
    private List<LobbyUserDTO> users;
    private AGameOptionsDTO options;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LobbyDTO() {}

}
