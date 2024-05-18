package fr.bugo.games.loveletter.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LoveLetterController {


    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return new ResponseEntity<>("Love letter server is on", HttpStatus.OK);
    }
}
