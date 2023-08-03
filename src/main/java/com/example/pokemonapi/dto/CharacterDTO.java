package com.example.pokemonapi.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CharacterDTO extends BaseDTO{
    private String name;
    private String family;
    private String friends;
    private String occupation;
    private String gender;
}
