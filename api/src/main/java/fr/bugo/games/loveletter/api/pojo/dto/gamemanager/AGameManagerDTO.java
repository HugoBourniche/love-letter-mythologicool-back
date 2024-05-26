package fr.bugo.games.loveletter.api.pojo.dto.gamemanager;

import fr.bugo.games.loveletter.api.pojo.dto.player.APlayerDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public abstract class AGameManagerDTO<P extends APlayerDTO> implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected List<P> players;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public AGameManagerDTO() {
    }

}
