package fr.bugo.games.loveletter.api.controller;

import fr.bugo.games.loveletter.api.pojo.request.LoveLetterGameInitializationRequest;
import fr.bugo.games.loveletter.api.services.ClassicLoveLetterGameManagerService;
import fr.bugo.games.loveletter.api.services.LobbyService;
import fr.bugo.games.loveletter.dto.gamecore.convertors.GCModelToDTOConverter;
import fr.bugo.games.loveletter.dto.gamecore.gamemanager.LoveLetterGameManagerDTO;
import fr.bugo.games.loveletter.api.pojo.response.ClassicLoveLetterGameInitialisationResponse;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.ClassicLoveLetterGameManager;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.lobbycore.exceptions.NoLobbyException;
import fr.bugo.games.loveletter.lobbycore.exceptions.NotReadyPlayerException;
import fr.bugo.games.loveletter.lobbycore.models.users.LobbyUser;
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
import java.util.stream.Collectors;

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
    public ResponseEntity<ClassicLoveLetterGameInitialisationResponse> initialize(@RequestBody LoveLetterGameInitializationRequest request) throws NoLobbyException, NotReadyPlayerException {
        ClassicLoveLetterGameOptions gameOptions = (ClassicLoveLetterGameOptions) lobbyService.getGameOptions(request.getLobbyKey()); // TODO Update
        List<LobbyUser> lobbyUsers = lobbyService.getUsers(request.getLobbyKey());
        for (LobbyUser lobbyUser : lobbyUsers) {
            if (!lobbyUser.isOwner() && !lobbyUser.isReady()) {
                throw new NotReadyPlayerException();
            }
        }
        List<User> players = lobbyUsers.stream().map(lobbyUser -> new User(lobbyUser.getName())).collect(Collectors.toList());
        ClassicLoveLetterGameManager gameManager = gameManagerService.initializeGame(request.getLobbyKey(), gameOptions, players);
        LoveLetterGameManagerDTO gameManagerDTO = GCModelToDTOConverter.convert(gameManager);
        return new ResponseEntity<>(new ClassicLoveLetterGameInitialisationResponse(gameManagerDTO), HttpStatus.OK);
    }

}
