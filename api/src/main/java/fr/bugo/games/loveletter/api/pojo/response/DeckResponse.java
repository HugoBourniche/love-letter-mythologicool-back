package fr.bugo.games.loveletter.api.pojo.response;

import fr.bugo.games.loveletter.dto.ACardDTO;
import lombok.Data;

import java.util.List;

@Data
public class DeckResponse {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    List<ACardDTO> cardStack;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public DeckResponse(List<ACardDTO> cardStack) {
        this.cardStack = cardStack;
    }
}
