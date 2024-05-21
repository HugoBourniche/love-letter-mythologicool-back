package fr.bugo.games.loveletter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

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

    public LoveLetterCardDTO(String spriteId, String name, Integer value) {
        super(spriteId);
        this.name = name;
        this.value = value;
    }
}
