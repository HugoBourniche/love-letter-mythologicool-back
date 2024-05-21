package fr.bugo.games.loveletter.gamecore.model.stack;

import fr.bugo.games.loveletter.gamecore.model.card.ACard;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CardStack<C extends ACard> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    List<C> stack;
}
