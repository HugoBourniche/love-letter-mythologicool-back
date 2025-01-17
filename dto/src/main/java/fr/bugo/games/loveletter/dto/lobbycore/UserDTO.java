package fr.bugo.games.loveletter.dto.lobbycore;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    private String name;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public UserDTO() {}

}
