package com.example.pokemonapi.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ArenaDTO extends BaseDTO{
    private String name;
    private String type;
    private String leaderName;
}
