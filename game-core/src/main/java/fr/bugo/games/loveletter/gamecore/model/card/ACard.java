package fr.bugo.games.loveletter.gamecore.model.card;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class ACard {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected UUID id;
    protected String spriteId;
    protected boolean facingDown;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ACard() {}

    public ACard(UUID id, String spriteId, boolean facingDown) {
        this.id = id;
        this.spriteId = spriteId;
        this.facingDown = facingDown;
    }

    // *****************************************************************************************************************
    // ABSTRACT METHODS
    // *****************************************************************************************************************

    public abstract void Play();

    // *****************************************************************************************************************
    // OVERRIDE METHODS
    // *****************************************************************************************************************

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ACard{");
        sb.append("spriteId='").append(spriteId).append('\'');
        sb.append("id='").append(id).append('\'');
        sb.append(", facingDown=").append(facingDown);
        sb.append('}');
        return sb.toString();
    }
}
