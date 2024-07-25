package fr.bugo.games.loveletter.api.pojo.response;

import fr.bugo.games.loveletter.dto.gamecore.LoveLetterCardDTO;

public class ClassicLoveLetterDrawCardResponse {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    LoveLetterCardDTO cardDTO;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ClassicLoveLetterDrawCardResponse(LoveLetterCardDTO cardDTO) {
        this.cardDTO = cardDTO;
    }
}
