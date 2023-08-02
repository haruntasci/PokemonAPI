package com.example.pokemonapi.dto;

import lombok.Data;

import java.util.UUID;


@Data
public class PokemonDTO {
    private Long id;
    private UUID uuid;
    private String name;
    private String category;
    private String abilities;
    private String type;
    private String color;
    private Double weight;
    private Double height;
}
