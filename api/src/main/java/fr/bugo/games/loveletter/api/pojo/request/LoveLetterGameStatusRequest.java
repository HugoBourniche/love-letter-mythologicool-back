package fr.bugo.games.loveletter.api.pojo.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoveLetterGameStatusRequest implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private String lobbyKey;
    private String playerName;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LoveLetterGameStatusRequest() {}
}
