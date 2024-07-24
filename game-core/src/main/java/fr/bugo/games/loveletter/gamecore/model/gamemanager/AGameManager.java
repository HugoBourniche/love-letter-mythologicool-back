package fr.bugo.games.loveletter.gamecore.model.gamemanager;

import fr.bugo.games.loveletter.gamecore.model.action.ARequestedAction;
import fr.bugo.games.loveletter.gamecore.model.action.EAction;
import fr.bugo.games.loveletter.shareddata.exceptions.NoUserException;
import fr.bugo.games.loveletter.gamecore.model.player.APlayer;
import fr.bugo.games.loveletter.shareddata.models.User;
import fr.bugo.games.loveletter.shareddata.models.gameoptions.AGameOptions;
import fr.bugo.games.loveletter.shareddata.utils.ToStringUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public abstract class AGameManager<P extends APlayer, A extends ARequestedAction<P>, O extends AGameOptions> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected String accessKey;
    protected List<P> players;
    protected List<A> requestedActions;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public AGameManager() {
        this.players = new ArrayList<>();
        this.requestedActions = new ArrayList<>();
    }

    // *****************************************************************************************************************
    // ABSTRACT METHODS
    // *****************************************************************************************************************

    public abstract void initGame(O options, List<User> users);
    public abstract void startTurn(P player);
    public abstract void addRequestedActions(P player, List<EAction> actions);

    // *****************************************************************************************************************
    // PUBLIC METHODS
    // *****************************************************************************************************************

    public P getPlayer(String name) throws NoUserException {
        Optional<P> optPlayer = this.players.stream().filter(p -> p.getUser().getName().equals(name)).findAny();
        if (optPlayer.isEmpty()) {
            throw new NoUserException(name);
        }
        return optPlayer.get();
    }

    // *****************************************************************************************************************
    // OVERRIDE METHODS
    // *****************************************************************************************************************

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AGameManager{");
        sb.append(ToStringUtils.list(players, "players"));
        sb.append(ToStringUtils.list(requestedActions, "requestedActions"));
        sb.append('}');
        return sb.toString();
    }
}
