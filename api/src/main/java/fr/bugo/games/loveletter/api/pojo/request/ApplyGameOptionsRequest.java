package fr.bugo.games.loveletter.api.pojo.request;

import fr.bugo.games.loveletter.dto.gamecore.gamemanager.gameoptions.LoveLetterGameOptionsDTO;
import lombok.Data;

@Data
public class ApplyGameOptionsRequest {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private String lobbyKey;
    private LoveLetterGameOptionsDTO gameOptions;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ApplyGameOptionsRequest() {}

}
