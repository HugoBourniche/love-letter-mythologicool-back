package fr.bugo.games.loveletter.api.controller;

import fr.bugo.games.loveletter.api.pojo.response.DeckResponse;
import fr.bugo.games.loveletter.dto.ACardDTO;
import fr.bugo.games.loveletter.dto.LoveLetterCardDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LoveLetterController {


    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return new ResponseEntity<>("Love letter server is on", HttpStatus.OK);
    }

    @GetMapping("/deck")
    public ResponseEntity<DeckResponse> deck() {
        List<ACardDTO> cards = new ArrayList<>();
        cards.add(new LoveLetterCardDTO("loverletter_classic_0_spy", "Espionne", 0));
        cards.add(new LoveLetterCardDTO("loverletter_classic_1_guard", "Garde", 1));
        return new ResponseEntity<>(new DeckResponse(cards), HttpStatus.OK);
    }
}
