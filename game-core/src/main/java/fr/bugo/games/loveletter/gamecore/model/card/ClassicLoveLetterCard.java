package fr.bugo.games.loveletter.gamecore.model.card;

public class ClassicLoveLetterCard extends ALoveLetterCard {

    @Override
    public void Play() {
        System.out.println("Play " + this.getName());
    }
}
