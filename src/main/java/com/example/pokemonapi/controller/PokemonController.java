package com.example.pokemonapi.controller;


import com.example.pokemonapi.dto.PokemonDTO;
import com.example.pokemonapi.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public ResponseEntity<List<PokemonDTO>> getAllPokemons() {
        return new ResponseEntity<>(pokemonService.getAllPokemons(), HttpStatus.OK);
    }

    @GetMapping("/{specificString}")
    public ResponseEntity<PokemonDTO> getPokemonBySpecificString(@PathVariable String specificString) {
        return new ResponseEntity<>(pokemonService.getPokemonByString(specificString), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<PokemonDTO> createOnePokemon(@RequestBody PokemonDTO pokemonDTO) {
        return new ResponseEntity<>(pokemonService.createPokemon(pokemonDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteOnePokemon(@PathVariable UUID uuid) {
        return new ResponseEntity<>(pokemonService.deletePokemon(uuid), HttpStatus.OK);
    }


}
