package fr.bugo.games.loveletter.dto.gamecore.gamemanager.gameoptions;

import fr.bugo.games.loveletter.dto.gamecore.player.LoveLetterPlayerDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoveLetterGameOptionsDTO extends AGameOptionsDTO<LoveLetterPlayerDTO> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LoveLetterGameOptionsDTO() {}

}
