package fr.bugo.games.loveletter.api.controller;

import fr.bugo.games.loveletter.api.pojo.response.LoveLetterGameInitializationRequest;
import fr.bugo.games.loveletter.api.services.ClassicLoveLetterGameManagerService;
import fr.bugo.games.loveletter.dto.gamecore.convertors.GCDTOtoModelConverter;
import fr.bugo.games.loveletter.dto.gamecore.convertors.GCModelToDTOConverter;
import fr.bugo.games.loveletter.dto.gamecore.gamemanager.LoveLetterGameManagerDTO;
import fr.bugo.games.loveletter.api.pojo.response.ClassicLoveLetterGameInitialisationResponse;
import fr.bugo.games.loveletter.dto.lobbycore.convertors.LCDTOtoModelConverter;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.ClassicLoveLetterGameManager;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.shareddata.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassicLoveLetterGameController.class);

    // *****************************************************************************************************************
    // SERVICES
    // *****************************************************************************************************************

    @Autowired
    ClassicLoveLetterGameManagerService gameManagerService;

    // *****************************************************************************************************************
    // REQUESTS
    // *****************************************************************************************************************

    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return new ResponseEntity<>("Classic Love letter feature server is on", HttpStatus.OK);
    }

    @PostMapping("/initialize")
    public ResponseEntity<ClassicLoveLetterGameInitialisationResponse> initialize(@RequestBody LoveLetterGameInitializationRequest request) {
        ClassicLoveLetterGameOptions gameOptions = GCDTOtoModelConverter.convert(request.getGameOptionsDTO());
        List<User> players = LCDTOtoModelConverter.convertUsers(request.getPlayers());
        ClassicLoveLetterGameManager gameManager = gameManagerService.initializeGame(request.getLobbyKey(), gameOptions, players);
        LoveLetterGameManagerDTO gameManagerDTO = GCModelToDTOConverter.convert(gameManager);
        return new ResponseEntity<>(new ClassicLoveLetterGameInitialisationResponse(gameManagerDTO), HttpStatus.OK);
    }

}
