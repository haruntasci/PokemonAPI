package com.example.pokemonapi.repository;

import com.example.pokemonapi.model.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {
    PokemonEntity findFirstPokemonEntityByNameContainsIgnoreCase(String key);
}
