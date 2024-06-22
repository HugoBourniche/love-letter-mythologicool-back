package fr.bugo.games.loveletter.api.pojo.response;

import fr.bugo.games.loveletter.dto.gamecore.gamemanager.LoveLetterGameManagerDTO;
import lombok.Data;

@Data
public class ClassicLoveLetterGameStatusResponse {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    LoveLetterGameManagerDTO gameManagerDTO;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ClassicLoveLetterGameStatusResponse(LoveLetterGameManagerDTO gameManagerDTO) {
        this.gameManagerDTO = gameManagerDTO;
    }
}
