package fr.bugo.games.loveletter.gamecore.model.stack;

import fr.bugo.games.loveletter.gamecore.exceptions.EmptyCardStackException;
import fr.bugo.games.loveletter.gamecore.model.card.ACard;
import fr.bugo.games.loveletter.gamecore.utils.ToStringUtils;
import lombok.Data;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

@Data
public class CardStack<C extends ACard> {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected Stack<C> stack;

    // *****************************************************************************************************************
    // METHODS
    // *****************************************************************************************************************

    public CardStack() {
        this.stack = new Stack<>();
    }

    // *****************************************************************************************************************
    // METHODS
    // *****************************************************************************************************************

    public void addCard(C card) {
        stack.add(card);
    }

    public int size() {
        return stack.size();
    }

    public void shuffle() {
        Collections.shuffle(stack);
    }

    public C drawCard() throws EmptyCardStackException {
        try {
            return stack.pop();
        } catch (EmptyStackException e) {
            throw new EmptyCardStackException("Impossible to draw from an empty stack of cards");
        }
    }

    // *****************************************************************************************************************
    // OVERRIDE METHODS
    // *****************************************************************************************************************

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CardStack{");
        sb.append(ToStringUtils.list(stack, "stack"));
        sb.append('}');
        return sb.toString();
    }
}
