package fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions;

import fr.bugo.games.loveletter.gamecore.model.player.APlayer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class AGameOptions<P extends APlayer> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected List<P> players;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public AGameOptions() {
        this.players = new ArrayList<>();
    }
}
