package fr.bugo.games.loveletter.api.controller;

import fr.bugo.games.loveletter.api.pojo.request.ApplyGameOptionsRequest;
import fr.bugo.games.loveletter.api.pojo.request.LobbyCreationRequest;
import fr.bugo.games.loveletter.api.pojo.request.LobbyUserReadyRequest;
import fr.bugo.games.loveletter.api.pojo.response.LobbyItemListResponse;
import fr.bugo.games.loveletter.api.pojo.response.LobbyCreationResponse;
import fr.bugo.games.loveletter.api.pojo.request.LobbyJoinRequest;
import fr.bugo.games.loveletter.api.pojo.response.LobbyJoinedResponse;
import fr.bugo.games.loveletter.api.pojo.response.LobbyUpdateResponse;
import fr.bugo.games.loveletter.api.services.LobbyService;
import fr.bugo.games.loveletter.dto.lobbycore.LobbyItemDTO;
import fr.bugo.games.loveletter.dto.lobbycore.convertors.LCDTOtoModelConverter;
import fr.bugo.games.loveletter.dto.lobbycore.convertors.LCModelToDTOConverter;
import fr.bugo.games.loveletter.dto.lobbycore.LobbyDTO;
import fr.bugo.games.loveletter.gamecore.model.gamemanager.gameoptions.ClassicLoveLetterGameOptions;
import fr.bugo.games.loveletter.lobbycore.exceptions.InvalidNameException;
import fr.bugo.games.loveletter.lobbycore.exceptions.NoUserInLobbyException;
import fr.bugo.games.loveletter.lobbycore.exceptions.UniqueNameException;
import fr.bugo.games.loveletter.lobbycore.exceptions.NoLobbyException;
import fr.bugo.games.loveletter.lobbycore.models.lobby.Lobby;
import fr.bugo.games.loveletter.lobbycore.models.lobby.LobbyItem;
import fr.bugo.games.loveletter.shareddata.enums.GameToPlay;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lobby")
public class SimpleLobbyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleLobbyController.class);

    // *****************************************************************************************************************
    // SERVICES
    // *****************************************************************************************************************

    @Autowired
    private LobbyService lobbyService;

    // *****************************************************************************************************************
    // REQUESTS
    // *****************************************************************************************************************

    @GetMapping("/info")
    public ResponseEntity<String> info() {
        LOGGER.info("/lobby/info");
        return new ResponseEntity<>("Lobby feature in server is on", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<LobbyCreationResponse> create(@RequestBody LobbyCreationRequest request) {
        LOGGER.info("/create/" + request.getGame() + "/" + request.getOwner().getName());
        User owner = LCDTOtoModelConverter.convert(request.getOwner());
        GameToPlay currentGame = GameToPlay.convert(request.getGame());
        Lobby lobby = lobbyService.createLobby(owner, currentGame);
        LobbyDTO lobbyDTO = LCModelToDTOConverter.convert(lobby);
        LOGGER.info("Lobby [" + lobbyDTO + "] created by " + owner.getName());
        return new ResponseEntity<>(new LobbyCreationResponse(lobbyDTO, owner.getName()), HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody LobbyJoinRequest request) {
        LOGGER.info("/lobby/"+ request.getLobbyKey() +"/join/" + request.getUser().getName());
        Lobby lobby;
        try {
            User user = LCDTOtoModelConverter.convert(request.getUser());
            lobby = lobbyService.joinLobby(request.getLobbyKey(), user);
        } catch (NoLobbyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (UniqueNameException | InvalidNameException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }

        LobbyDTO lobbyDTO = LCModelToDTOConverter.convert(lobby);
        return new ResponseEntity<>(new LobbyJoinedResponse(lobbyDTO, request.getUser().getName()), HttpStatus.OK);
    }

    @PostMapping("/ready")
    public ResponseEntity<?> ready(@RequestBody LobbyUserReadyRequest request) {
        LOGGER.info("/lobby/ready/" + request.getLobbyKey() + "/" + request.getUserName());
        Lobby lobby;
        try {
            lobby = lobbyService.userSwitchReady(request.getLobbyKey(), request.getUserName());
        } catch (NoLobbyException | NoUserInLobbyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        LobbyDTO lobbyDTO = LCModelToDTOConverter.convert(lobby);
        return new ResponseEntity<>(new LobbyUpdateResponse(lobbyDTO), HttpStatus.OK);
    }

    @GetMapping("/update")
    public ResponseEntity<?> update(@RequestParam String lobbyKey) {
        LOGGER.debug("/lobby/update/" + lobbyKey); // This request is call lot of times
        Lobby lobby;
        try {
            lobby = lobbyService.getLobby(lobbyKey);
        } catch (NoLobbyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        LobbyDTO lobbyDTO = LCModelToDTOConverter.convert(lobby);
        return new ResponseEntity<>(new LobbyUpdateResponse(lobbyDTO), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        LOGGER.info("/list");
        List<LobbyItem> lobbies = lobbyService.getLobbyItemList();
        List<LobbyItemDTO> lobbyItemDTO = LCModelToDTOConverter.convertLobbyItemList(lobbies);
        return new ResponseEntity<>(new LobbyItemListResponse(lobbyItemDTO), HttpStatus.OK);
    }

    @PostMapping("/apply-game-options")
    public ResponseEntity<?> applyGameOptions(@RequestBody ApplyGameOptionsRequest optionsRequest) {
        ClassicLoveLetterGameOptions gameOptions = LCDTOtoModelConverter.convert(optionsRequest.getGameOptions());
        try {
            lobbyService.updateLobbyGameOptions(optionsRequest.getLobbyKey(), gameOptions);
        } catch (NoLobbyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
