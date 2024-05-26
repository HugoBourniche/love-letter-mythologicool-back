package fr.bugo.games.loveletter.api.pojo.dto.gamemanager.gameoptions;

import fr.bugo.games.loveletter.api.pojo.dto.player.APlayerDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public abstract class AGameOptionsDTO<P extends APlayerDTO> implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    List<P> players;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public AGameOptionsDTO() {}

}
