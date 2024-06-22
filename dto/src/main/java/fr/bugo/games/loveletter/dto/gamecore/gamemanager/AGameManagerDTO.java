package fr.bugo.games.loveletter.dto.gamecore.gamemanager;

import fr.bugo.games.loveletter.dto.gamecore.player.APlayerDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public abstract class AGameManagerDTO<P extends APlayerDTO> implements Serializable {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected P currentPlayer;
    protected List<P> otherPlayers;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public AGameManagerDTO() {
    }

}
