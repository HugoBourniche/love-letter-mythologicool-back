package fr.bugo.games.loveletter.api.pojo.response;

import fr.bugo.games.loveletter.api.pojo.dto.gamemanager.LoveLetterGameManagerDTO;
import lombok.Data;

@Data
public class InitialisationResponse {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    LoveLetterGameManagerDTO gameManagerDTO;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public InitialisationResponse(LoveLetterGameManagerDTO gameManagerDTO) {
        this.gameManagerDTO = gameManagerDTO;
    }
}
