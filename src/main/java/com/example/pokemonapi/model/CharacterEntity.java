package com.example.pokemonapi.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "characters")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "character_uuid"
        )
)
@Data
public class CharacterEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String family;
    @Column
    private String friends;
    @Column
    private String occupation;
    @Column
    private String gender;
}
