package fr.bugo.games.loveletter.dto.gamecore.gamemanager.gameoptions;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class AGameOptionsDTO implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private int maxPlayers;
    private GameOptionsRangesDTO ranges;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public AGameOptionsDTO() {}

}
