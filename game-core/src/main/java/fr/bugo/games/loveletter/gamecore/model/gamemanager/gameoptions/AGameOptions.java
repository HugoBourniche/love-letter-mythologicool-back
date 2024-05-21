package fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions;

import fr.bugo.games.loveletter.gamecore.model.player.APlayer;
import fr.bugo.games.loveletter.gamecore.factory.LoveLetterGame;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public abstract class AGameOptions<P extends APlayer> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    LoveLetterGame gameType;
    List<P> players;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

}
