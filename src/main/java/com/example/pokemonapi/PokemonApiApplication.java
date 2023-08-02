package com.example.pokemonapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PokemonApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonApiApplication.class, args);
    }

}
