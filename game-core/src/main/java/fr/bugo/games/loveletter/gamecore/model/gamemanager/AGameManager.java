package fr.bugo.games.loveletter.gamecore.model.gamemanager;

import fr.bugo.games.loveletter.gamecore.model.player.APlayer;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.AGameOptions;
import fr.bugo.games.loveletter.gamecore.utils.ToStringUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class AGameManager<P extends APlayer, O extends AGameOptions<P>> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected List<P> players;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public AGameManager() {
        this.players = new ArrayList<>();
    }

    // *****************************************************************************************************************
    // ABSTRACT METHODS
    // *****************************************************************************************************************

    public abstract void initGame(O options);

    // *****************************************************************************************************************
    // OVERRIDE METHODS
    // *****************************************************************************************************************

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AGameManager{");
        sb.append(ToStringUtils.list(players, "players"));
        sb.append('}');
        return sb.toString();
    }
}
