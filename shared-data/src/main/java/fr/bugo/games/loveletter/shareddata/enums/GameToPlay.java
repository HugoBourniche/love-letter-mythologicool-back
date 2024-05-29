package fr.bugo.games.loveletter.shareddata.enums;

public enum GameToPlay {
    CLASSIC; // STARWARS, PRINCESSPRINCESS, MARVEL, MYTHOLOGICAL, ORIGINAL;

    public static GameToPlay convert(String name) {
        switch (name) {
            default:return GameToPlay.CLASSIC;
        }
    }
}
