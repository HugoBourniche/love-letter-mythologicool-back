package fr.bugo.games.loveletter.shareddata.models;

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
