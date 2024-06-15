package fr.bugo.games.loveletter.dto.gamecore.player;

import fr.bugo.games.loveletter.dto.gamecore.LoveLetterCardDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoveLetterPlayerDTO extends APlayerDTO {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected List<LoveLetterCardDTO> hand = new ArrayList<>();
    protected Integer position;
    protected Integer nbFavorPeace;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LoveLetterPlayerDTO() {
    }
}
