package fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic;

public class ClassicLoveLetter7KingCard extends AClassicLoveLetterCard {

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public ClassicLoveLetter7KingCard(String spriteId, String name, Integer value, String description) {
        super(spriteId, true, name, value, description);
    }

    // *****************************************************************************************************************
    // OVERRIDE
    // *****************************************************************************************************************

    @Override
    public void Play() {
        System.out.println("Play " + name);
    }
}
