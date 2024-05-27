package fr.bugo.games.loveletter.gamecore.model.card.loveletter;

import fr.bugo.games.loveletter.gamecore.model.card.ACard;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class ALoveLetterCard extends ACard {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected String name;
    protected Integer value;
    protected String description;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ALoveLetterCard(String spriteId, boolean isHidden, String name, Integer value, String description) {
        super(UUID.randomUUID(), spriteId, isHidden);
        this.name = name;
        this.value = value;
        this.description = description;
    }

    // *****************************************************************************************************************
    // OVERRIDE METHODS
    // *****************************************************************************************************************

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ALoveLetterCard{");
        sb.append(super.toString());
        sb.append(", name='").append(name).append('\'');
        sb.append(", value=").append(value);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
