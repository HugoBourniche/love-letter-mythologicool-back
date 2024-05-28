package fr.bugo.games.loveletter.dto.gamecore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoveLetterCardDTO extends ACardDTO {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private String name;
    private Integer value;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************
    public LoveLetterCardDTO() {}

}
