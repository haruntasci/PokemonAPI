package com.example.pokemonapi.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BaseDTO {
    private Long id;
    private UUID uuid;
}
