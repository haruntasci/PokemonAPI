package com.example.pokemonapi.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ArenaDTO {
    private Long id;
    private UUID uuid;
    private String name;
    private String type;
    private String leaderName;
}
