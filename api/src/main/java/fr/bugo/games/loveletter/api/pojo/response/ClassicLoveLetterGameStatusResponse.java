package fr.bugo.games.loveletter.api.pojo.response;

import fr.bugo.games.loveletter.dto.gamecore.gamemanager.LoveLetterGameManagerDTO;
import fr.bugo.games.loveletter.dto.gamecore.player.LoveLetterPlayerDTO;
import lombok.Data;

@Data
public class ClassicLoveLetterGameStatusResponse {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    LoveLetterGameManagerDTO gameManagerDTO;
    LoveLetterPlayerDTO playerDTO;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ClassicLoveLetterGameStatusResponse(LoveLetterGameManagerDTO gameManagerDTO, LoveLetterPlayerDTO playerDTO) {
        this.gameManagerDTO = gameManagerDTO;
        this.playerDTO = playerDTO;
    }
}
