package fr.bugo.games.loveletter.api.pojo.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class LobbyUserReadyRequest implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private String userName;
    private String lobbyKey;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public LobbyUserReadyRequest() {}
}
