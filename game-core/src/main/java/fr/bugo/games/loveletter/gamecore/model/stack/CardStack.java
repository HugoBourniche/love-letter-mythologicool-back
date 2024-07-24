package fr.bugo.games.loveletter.gamecore.model.stack;

import fr.bugo.games.loveletter.gamecore.exceptions.EmptyCardStackException;
import fr.bugo.games.loveletter.gamecore.model.card.ACard;
import fr.bugo.games.loveletter.shareddata.utils.ToStringUtils;
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
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public CardStack() {
        this.stack = new Stack<>();
    }

    // *****************************************************************************************************************
    // PUBLIC METHODS
    // *****************************************************************************************************************

    /**
     * Add a card to the stack
     * @param card Card to add
     */
    public void addCard(C card) {
        stack.add(card);
    }

    /**
     * Shuffle the card stack
     */
    public void shuffle() {
        Collections.shuffle(stack);
    }

    /**
     * Pick up a card in the stack and remove it
     * @return Card picked up
     * @throws EmptyCardStackException The stack is empty, can't fetch a card
     */
    public C drawCard() throws EmptyCardStackException {
        try {
            return stack.pop();
        } catch (EmptyStackException e) {
            throw new EmptyCardStackException("Impossible to draw from an empty stack of cards");
        }
    }

    // UTILS

    /**
     * Fetch the size of the stack
     * @return number of cards
     */
    public int size() {
        return stack.size();
    }

    /**
     * Is the stack empty
     * @return True if the stack is empty
     */
    public boolean isEmpty() {
        return stack.isEmpty();
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
