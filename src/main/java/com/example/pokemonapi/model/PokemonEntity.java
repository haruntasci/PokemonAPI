package com.example.pokemonapi.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "pokemons")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "pokemon_uuid"
        )
)
@Data
public class PokemonEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String category;
    @Column
    private String abilities;
    @Column
    private String type;
    @Column
    private String color;
    @Column
    private Double weight;
    @Column
    private Double height;
}

