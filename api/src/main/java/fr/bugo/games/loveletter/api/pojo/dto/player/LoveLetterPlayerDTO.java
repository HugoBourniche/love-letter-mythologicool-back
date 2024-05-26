package fr.bugo.games.loveletter.api.pojo.dto.player;

import fr.bugo.games.loveletter.api.pojo.dto.LoveLetterCardDTO;
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

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LoveLetterPlayerDTO() {
    }
}
