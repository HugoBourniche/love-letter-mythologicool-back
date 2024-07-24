package fr.bugo.games.loveletter.shareddata.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final Integer MIN_PLAYERS = 2;
    public static final Integer MAX_PLAYERS = 6;

    // Nb tokens to Win
    public static final Map<Integer, Integer> NB_TOKENS_PER_NB_PLAYERS = new HashMap<>() {{
       put(2, 6);
        put(3, 5);
        put(4, 4);
        put(5, 3);
        put(6, 3);
    }};
}
