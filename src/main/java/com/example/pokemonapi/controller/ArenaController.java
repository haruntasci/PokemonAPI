package com.example.pokemonapi.controller;

import com.example.pokemonapi.dto.ArenaDTO;
import com.example.pokemonapi.service.ArenaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("arena")
public class ArenaController {

    private final ArenaService arenaService;

    public ArenaController(ArenaService arenaService) {
        this.arenaService = arenaService;
    }

    @GetMapping
    public ResponseEntity<List<ArenaDTO>> getAllArenas() {
        return new ResponseEntity<>(arenaService.getAllArenas(), HttpStatus.OK);
    }

    @GetMapping("/{specificString}")
    public ResponseEntity<ArenaDTO> getArenaBySpecificString(@PathVariable String specificString) {
        return new ResponseEntity<>(arenaService.getArenaByString(specificString), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ArenaDTO> createOneArena(@RequestBody ArenaDTO arenaDTO) {
        return new ResponseEntity<>(arenaService.createArena(arenaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteOneArena(@PathVariable UUID uuid) {
        return new ResponseEntity<>(arenaService.deleteArena(uuid), HttpStatus.OK);
    }

}
