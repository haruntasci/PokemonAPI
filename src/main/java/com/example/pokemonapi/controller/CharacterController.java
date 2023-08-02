package com.example.pokemonapi.controller;

import com.example.pokemonapi.dto.CharacterDTO;
import com.example.pokemonapi.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("character")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public ResponseEntity<List<CharacterDTO>> getAllCharacters() {
        return new ResponseEntity<>(characterService.getAllCharacters(), HttpStatus.OK);
    }

    @GetMapping("/{specificString}")
    public ResponseEntity<CharacterDTO> getCharacterBySpecificString(@PathVariable String specificString) {
        return new ResponseEntity<>(characterService.getCharacterByString(specificString), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CharacterDTO> createOneCharacter(@RequestBody CharacterDTO characterDTO) {
        return new ResponseEntity<>(characterService.createCharacter(characterDTO), HttpStatus.OK);
    }
}
