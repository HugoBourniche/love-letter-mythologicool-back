package fr.bugo.games.loveletter.api.controller;

import fr.bugo.games.loveletter.api.pojo.request.LobbyCreationRequest;
import fr.bugo.games.loveletter.api.pojo.response.LobbyCreationResponse;
import fr.bugo.games.loveletter.api.pojo.response.LobbyJoinRequest;
import fr.bugo.games.loveletter.api.pojo.response.LobbyJoinedResponse;
import fr.bugo.games.loveletter.api.services.LobbyService;
import fr.bugo.games.loveletter.dto.lobbycore.convertors.LCDTOtoModelConverter;
import fr.bugo.games.loveletter.dto.lobbycore.convertors.LCModelToDTOConverter;
import fr.bugo.games.loveletter.dto.lobbycore.LobbyDTO;
import fr.bugo.games.loveletter.lobbycore.exceptions.UniqueNameException;
import fr.bugo.games.loveletter.lobbycore.exceptions.NoLobbyException;
import fr.bugo.games.loveletter.lobbycore.models.lobby.Lobby;
import fr.bugo.games.loveletter.shareddata.enums.GameToPlay;
import fr.bugo.games.loveletter.shareddata.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/create")
    public ResponseEntity<LobbyCreationResponse> create(@RequestBody LobbyCreationRequest request) {
        User owner = LCDTOtoModelConverter.convert(request.getOwner());
        GameToPlay currentGame = GameToPlay.convert(request.getGame());
        Lobby lobby = lobbyService.createLobby(owner, currentGame);
        LobbyDTO lobbyDTO = LCModelToDTOConverter.convert(lobby);
        return new ResponseEntity<>(new LobbyCreationResponse(lobbyDTO), HttpStatus.OK);
    }

    @GetMapping("/join")
    public ResponseEntity<?> join(@RequestBody LobbyJoinRequest request) {
        LOGGER.info("/lobby/"+ request.getLobbyKey() +"/join/" + request.getUser().getName());
        Lobby lobby;
        try {
            User user = LCDTOtoModelConverter.convert(request.getUser());
            lobby = lobbyService.joinLobby(request.getLobbyKey(), user);
        } catch (NoLobbyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (UniqueNameException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }

        LobbyDTO lobbyDTO = LCModelToDTOConverter.convert(lobby);
        return new ResponseEntity<>(new LobbyJoinedResponse(lobbyDTO), HttpStatus.OK);
    }

}
