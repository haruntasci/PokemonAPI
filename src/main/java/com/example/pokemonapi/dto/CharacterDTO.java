package com.example.pokemonapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class CharacterDTO {
    private String name;
    private String family;
    private List<String> friends;
    private String occupation;
    private String gender;
}
