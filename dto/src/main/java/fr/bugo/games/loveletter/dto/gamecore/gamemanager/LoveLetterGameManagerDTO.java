package fr.bugo.games.loveletter.dto.gamecore.gamemanager;

import fr.bugo.games.loveletter.dto.gamecore.LoveLetterCardDTO;
import fr.bugo.games.loveletter.dto.gamecore.action.LoveLetterRequestedActionDTO;
import fr.bugo.games.loveletter.dto.gamecore.player.LoveLetterPlayerDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class LoveLetterGameManagerDTO extends AGameManagerDTO<LoveLetterPlayerDTO, LoveLetterRequestedActionDTO> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected List<LoveLetterCardDTO> cardPile;
    protected List<LoveLetterCardDTO> discardPile;
    protected List<LoveLetterCardDTO> asideCard;
    protected Integer playerTurn;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LoveLetterGameManagerDTO() {
        super();
    }

}
