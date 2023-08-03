package com.example.pokemonapi.repository;

import com.example.pokemonapi.model.ArenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ArenaRepository extends JpaRepository<ArenaEntity, Long> {
    ArenaEntity findFirstArenaEntityByNameContainsIgnoreCase(String key);

    @Modifying
    @Query("DELETE FROM ArenaEntity a where a.uuid = ?1")
    int deleteByUuid(UUID uuid);

}
