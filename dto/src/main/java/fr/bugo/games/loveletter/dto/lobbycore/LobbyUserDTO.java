package fr.bugo.games.loveletter.dto.lobbycore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LobbyUserDTO extends UserDTO {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private boolean isReady;
    private boolean isOwner;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LobbyUserDTO() {}

}
