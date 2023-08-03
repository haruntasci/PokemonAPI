package com.example.pokemonapi.repository;

import com.example.pokemonapi.model.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {
    PokemonEntity findFirstPokemonEntityByNameContainsIgnoreCase(String key);

    @Modifying
    @Query("DELETE FROM PokemonEntity p WHERE p.uuid = ?1")
    int deleteByUuid(UUID uuid);

}
