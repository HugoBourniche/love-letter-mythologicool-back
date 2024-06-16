package fr.bugo.games.loveletter.api.controller;

import fr.bugo.games.loveletter.api.pojo.request.LoveLetterGameInitializationRequest;
import fr.bugo.games.loveletter.api.pojo.request.LoveLetterGameStatusRequest;
import fr.bugo.games.loveletter.api.services.ClassicLoveLetterGameManagerService;
import fr.bugo.games.loveletter.api.services.LobbyService;
import fr.bugo.games.loveletter.dto.gamecore.convertors.GCModelToDTOConverter;
import fr.bugo.games.loveletter.dto.gamecore.gamemanager.LoveLetterGameManagerDTO;
import fr.bugo.games.loveletter.api.pojo.response.ClassicLoveLetterGameStatusResponse;
import fr.bugo.games.loveletter.dto.gamecore.player.LoveLetterPlayerDTO;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.ClassicLoveLetterGameManager;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.gamecore.model.player.ClassicLoveLetterPlayer;
import fr.bugo.games.loveletter.lobbycore.exceptions.NoLobbyException;
import fr.bugo.games.loveletter.lobbycore.exceptions.NotReadyPlayerException;
import fr.bugo.games.loveletter.shareddata.exceptions.NoUserException;
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
    @Autowired
    LobbyService lobbyService;

    // *****************************************************************************************************************
    // REQUESTS
    // *****************************************************************************************************************

    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return new ResponseEntity<>("Classic Love letter feature server is on", HttpStatus.OK);
    }

    @PostMapping("/initialize")
    public ResponseEntity<?> initialize(@RequestBody LoveLetterGameInitializationRequest request) throws NoLobbyException, NotReadyPlayerException {
        LOGGER.info("/loveletter/classic/initialize/" + request.getLobbyKey());
        ClassicLoveLetterGameOptions gameOptions = (ClassicLoveLetterGameOptions) lobbyService.getGameOptions(request.getLobbyKey()); // TODO Update
        List<User> players = lobbyService.startGame(request.getLobbyKey());
        gameManagerService.initializeGame(request.getLobbyKey(), gameOptions, players);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/status")
    public ResponseEntity<ClassicLoveLetterGameStatusResponse> status(@RequestBody LoveLetterGameStatusRequest request) throws NoLobbyException, NoUserException {
        LOGGER.info("/loveletter/classic/status/" + request.getLobbyKey() + "/" + request.getPlayerName());
        ClassicLoveLetterGameManager gameManager = gameManagerService.getGameManager(request.getLobbyKey());
        ClassicLoveLetterPlayer currentPlayer = gameManager.getPlayer(request.getPlayerName());
        LoveLetterGameManagerDTO gameManagerDTO = GCModelToDTOConverter.convert(gameManager);
        LoveLetterPlayerDTO playerDTO = GCModelToDTOConverter.convert(currentPlayer);
        return new ResponseEntity<>(new ClassicLoveLetterGameStatusResponse(gameManagerDTO, playerDTO), HttpStatus.OK);
    }
}
