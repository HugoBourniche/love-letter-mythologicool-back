package fr.bugo.games.loveletter.api.pojo.dto.gamemanager;

import fr.bugo.games.loveletter.api.pojo.dto.LoveLetterCardDTO;
import fr.bugo.games.loveletter.api.pojo.dto.player.LoveLetterPlayerDTO;
import lombok.Data;

import java.util.List;

@Data
public class LoveLetterGameManagerDTO extends AGameManagerDTO<LoveLetterPlayerDTO> {

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
