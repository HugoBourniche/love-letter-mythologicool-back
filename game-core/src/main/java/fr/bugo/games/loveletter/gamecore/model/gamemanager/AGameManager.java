package fr.bugo.games.loveletter.gamecore.model.gamemanager;

import fr.bugo.games.loveletter.gamecore.model.card.ACard;
import fr.bugo.games.loveletter.gamecore.model.player.APlayer;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.AGameOptions;
import fr.bugo.games.loveletter.gamecore.model.stack.CardStack;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public abstract class AGameManager<C extends ACard, P extends APlayer, S extends CardStack<C>> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    S cardStack;
    List<P> players;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    // *****************************************************************************************************************
    // PUBLIC METHODS
    // *****************************************************************************************************************

    public abstract void InitGame(AGameOptions<P> options);
}
