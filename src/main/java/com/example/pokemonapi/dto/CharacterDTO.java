package com.example.pokemonapi.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CharacterDTO {
    private Long id;
    private UUID uuid;
    private String name;
    private String family;
    private String friends;
    private String occupation;
    private String gender;
}
