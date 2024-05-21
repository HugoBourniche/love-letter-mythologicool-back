package fr.bugo.games.loveletter.gamecore.model.player;

import fr.bugo.games.loveletter.gamecore.model.card.ClassicLoveLetterCard;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public abstract class ClassicLoveLetterPlayer extends ALoveLetterPlayer<ClassicLoveLetterCard> {

}
