package com.example.pokemonapi.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "arenas")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "arena_uuid"
        )
)
@Data
public class ArenaEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private String leaderName;
}
