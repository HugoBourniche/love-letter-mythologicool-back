package fr.bugo.games.loveletter.api.controller;

import fr.bugo.games.loveletter.api.pojo.response.LoveLetterGameInitializationRequest;
import fr.bugo.games.loveletter.dto.gamecore.convertors.GCDTOtoModelConverter;
import fr.bugo.games.loveletter.dto.gamecore.convertors.GCModelToDTOConverter;
import fr.bugo.games.loveletter.dto.gamecore.gamemanager.LoveLetterGameManagerDTO;
import fr.bugo.games.loveletter.api.pojo.response.InitialisationResponse;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.ClassicLoveLetterGameManager;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/loveletter/classic")
public class ClassicLoveLetterGameController {

    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return new ResponseEntity<>("Classic Love letter feature server is on", HttpStatus.OK);
    }

    @PostMapping("/initialize")
    public ResponseEntity<InitialisationResponse> initialize(@RequestBody LoveLetterGameInitializationRequest request) {
        ClassicLoveLetterGameOptions gameOptions = GCDTOtoModelConverter.convert(request.getGameOptionsDTO());
        List<ClassicLoveLetterPlayer> players = GCDTOtoModelConverter.convertPlayers(request.getPlayers());
        ClassicLoveLetterGameManager gameManager = new ClassicLoveLetterGameManager();
        gameManager.initGame(gameOptions, players);
        LoveLetterGameManagerDTO gameManagerDTO = GCModelToDTOConverter.convert(gameManager);
        return new ResponseEntity<>(new InitialisationResponse(gameManagerDTO), HttpStatus.OK);
    }

}
