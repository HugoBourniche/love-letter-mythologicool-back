package fr.bugo.games.loveletter.gamecore.model.card;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public abstract class ALoveLetterCard extends ACard {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private String name;
    private Integer value;
    private String description;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    ALoveLetterCard(String name, Integer value, String description) {
        this.name = name;
        this.value = value;
        this.description = description;
    }

}
