package fr.bugo.games.loveletter.api.pojo.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoveLetterGameInitializationRequest implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private String lobbyKey;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LoveLetterGameInitializationRequest() {}

}
