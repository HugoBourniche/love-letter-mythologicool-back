package fr.bugo.games.loveletter.gamecore.factory.card;

import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.ClassicLoveLetter3BaronCard;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.ClassicLoveLetter4HandmaidCard;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.ClassicLoveLetter5PrinceCard;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.AClassicLoveLetterCard;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.ClassicLoveLetter1GuardCard;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.ClassicLoveLetter2PriestCard;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.ClassicLoveLetter0SpyCard;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.ClassicLoveLetter6ChancellorCard;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.ClassicLoveLetter7KingCard;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.ClassicLoveLetter8CountessCard;
import fr.bugo.games.loveletter.gamecore.model.card.loveletter.classic.ClassicLoveLetter9PrincessCard;
import fr.bugo.games.loveletter.gamecore.model.stack.CardStack;

public class ClassicLoveLetterCardFactory {

    private static final Integer NB_SPY = 2;
    private static final Integer NB_GUARD = 6;
    private static final Integer NB_PRIEST = 2;
    private static final Integer NB_BARON = 2;
    private static final Integer NB_HANDMAID = 2;
    private static final Integer NB_PRINCE = 2;
    private static final Integer NB_CHANCELLOR = 2;
    private static final Integer NB_KING = 1;
    private static final Integer NB_COUNTESS = 1;
    private static final Integer NB_PRINCESS = 1;

    public static CardStack<AClassicLoveLetterCard> buildInitialGameStack() {
        CardStack<AClassicLoveLetterCard> stack = new CardStack<>();
        for (int i = 0; i < NB_SPY; i++) stack.addCard(buildSpy());
        for (int i = 0; i < NB_GUARD; i++) stack.addCard(buildGuard());
        for (int i = 0; i < NB_PRIEST; i++) stack.addCard(buildPriest());
        for (int i = 0; i < NB_BARON; i++) stack.addCard(buildBaron());
        for (int i = 0; i < NB_HANDMAID; i++) stack.addCard(buildHandmaid());
        for (int i = 0; i < NB_PRINCE; i++) stack.addCard(buildPrince());
        for (int i = 0; i < NB_CHANCELLOR; i++) stack.addCard(buildChancellor());
        for (int i = 0; i < NB_KING; i++) stack.addCard(buildKing());
        for (int i = 0; i < NB_COUNTESS; i++) stack.addCard(buildCountess());
        for (int i = 0; i < NB_PRINCESS; i++) stack.addCard(buildPrincess());
        return stack;
    }

    public static AClassicLoveLetterCard buildCard(String name) {
        switch (name) {
            case "Espionne": return buildSpy();
            case "Garde": return buildGuard();
            case "Prêtre": return buildPriest();
            case "Baron": return buildBaron();
            case "Servante": return buildHandmaid();
            case "Prince": return buildPrince();
            case "Chancelier": return buildChancellor();
            case "Roi": return buildKing();
            case "Comtesse": return buildCountess();
            default: return buildPrincess();
        }
    }

    private static ClassicLoveLetter0SpyCard buildSpy() {
        return new ClassicLoveLetter0SpyCard("loveletter_classic_0_spy", "Espionne", 0, "");
    }

    private static ClassicLoveLetter1GuardCard buildGuard() {
        return new ClassicLoveLetter1GuardCard("loveletter_classic_1_guard", "Garde", 1, "");
    }

    private static ClassicLoveLetter2PriestCard buildPriest() {
        return new ClassicLoveLetter2PriestCard("loveletter_classic_2_priest", "Prêtre", 2, "");
    }

    private static ClassicLoveLetter3BaronCard buildBaron() {
        return new ClassicLoveLetter3BaronCard("loveletter_classic_3_baron", "Baron", 3, "");
    }

    private static ClassicLoveLetter4HandmaidCard buildHandmaid() {
        return new ClassicLoveLetter4HandmaidCard("loveletter_classic_4_handmaid", "Servante", 4, "");
    }

    private static ClassicLoveLetter5PrinceCard buildPrince() {
        return new ClassicLoveLetter5PrinceCard("loveletter_classic_5_prince", "Prince", 5, "");
    }

    private static ClassicLoveLetter6ChancellorCard buildChancellor() {
        return new ClassicLoveLetter6ChancellorCard("loveletter_classic_6_chancellor", "Chancelier", 6, "");
    }

    private static ClassicLoveLetter7KingCard buildKing() {
        return new ClassicLoveLetter7KingCard("loveletter_classic_7_king", "Roi", 7, "");
    }

    private static ClassicLoveLetter8CountessCard buildCountess() {
        return new ClassicLoveLetter8CountessCard("loveletter_classic_8_countess", "Comtesse", 8, "");
    }

    private static ClassicLoveLetter9PrincessCard buildPrincess() {
        return new ClassicLoveLetter9PrincessCard("loveletter_classic_9_princess", "Princesse", 9, "");
    }
}
