package fr.bugo.games.loveletter.dto.gamecore.gamemanager.gameoptions;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GameOptionsRangesDTO {


    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private List<String> nbPlayersChoices;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public GameOptionsRangesDTO() {
        this.nbPlayersChoices = new ArrayList<>();
    }
}
