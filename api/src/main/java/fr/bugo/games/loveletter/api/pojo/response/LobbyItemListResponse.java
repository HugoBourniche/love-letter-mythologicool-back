package fr.bugo.games.loveletter.api.pojo.response;

import fr.bugo.games.loveletter.dto.lobbycore.LobbyItemDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LobbyItemListResponse implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    List<LobbyItemDTO> lobbyItemDTOList;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LobbyItemListResponse() {}

    public LobbyItemListResponse(List<LobbyItemDTO> lobbyItemDTO) {
        this.lobbyItemDTOList = lobbyItemDTO;
    }
}
