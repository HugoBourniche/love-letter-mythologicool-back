package fr.bugo.games.loveletter.dto.gamecore.action;

import lombok.Data;

@Data
public abstract class ARequestedActionDTO {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected String playerName;
    protected String action;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ARequestedActionDTO() {
    }

}
