package fr.bugo.games.loveletter.gamecore.utils;

import java.util.List;

public class ToStringUtils {

    public static <T> String list(List<T> list, String prefix) {
        final StringBuffer sb = new StringBuffer(prefix);
        sb.append("=[");
        for (T card : list) {
            sb.append(card.toString()).append(", ");
        }
        sb.append(']');
        return sb.toString();
    }

}
