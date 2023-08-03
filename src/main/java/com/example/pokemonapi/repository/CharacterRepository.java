package com.example.pokemonapi.repository;

import com.example.pokemonapi.model.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
    CharacterEntity findFirstCharacterEntityByNameContainsIgnoreCase(String key);

    @Modifying
    @Query("DELETE FROM CharacterEntity c WHERE c.uuid = ?1")
    int deleteByUuid(UUID uuid);
}
