package fr.bugo.games.loveletter.api.pojo.response;

import fr.bugo.games.loveletter.dto.gamecore.gamemanager.gameoptions.LoveLetterGameOptionsDTO;
import fr.bugo.games.loveletter.dto.gamecore.player.LoveLetterPlayerDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LoveLetterGameInitializationRequest implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private LoveLetterGameOptionsDTO gameOptionsDTO;
    private List<LoveLetterPlayerDTO> players;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LoveLetterGameInitializationRequest() {}

}
