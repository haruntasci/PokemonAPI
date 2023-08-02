package com.example.pokemonapi.repository;

import com.example.pokemonapi.model.ArenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArenaRepository extends JpaRepository<ArenaEntity, Long> {
    ArenaEntity findFirstArenaEntityByNameContainsIgnoreCase(String key);
}
