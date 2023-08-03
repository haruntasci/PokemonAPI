package com.example.pokemonapi.service;

import com.example.pokemonapi.dto.PokemonDTO;
import com.example.pokemonapi.model.PokemonEntity;
import com.example.pokemonapi.repository.PokemonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
public class PokemonService {


    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public PokemonDTO getPokemonByString(String str) {
        String[] strArray = str.split("-");
        PokemonEntity pokemonEntity = pokemonRepository.findFirstPokemonEntityByNameContainsIgnoreCase(strArray[0]);
        return mapEntityToDTO(pokemonEntity);
    }

//    public PokemonDTO getPokemonByString(String str) {
//        String[] strArray = str.split("-");
//        List<PokemonDTO> pokemonDTOList = getAllPokemons();
//        PokemonDTO pokemonFindByString = pokemonDTOList
//                .stream()
//                .filter(pokemon -> pokemon.getName().equalsIgnoreCase(strArray[0]))
//                .toList().get(0);
//
//        return pokemonFindByString;
//    }

    public List<PokemonDTO> getAllPokemons() {
        List<PokemonEntity> pokemonEntities = pokemonRepository.findAll();
        List<PokemonDTO> pokemonDTOS = pokemonEntities
                .stream()
                .map(pokemonEntity -> mapEntityToDTO(pokemonEntity))
                .toList();
        return pokemonDTOS;
    }

    public PokemonDTO createPokemon(PokemonDTO pokemonDTO) {

        PokemonEntity pokemon = mapDTOTOEntity(pokemonDTO);

        PokemonEntity savedPokemon = pokemonRepository.save(pokemon);

        PokemonDTO pokemonToReturn = mapEntityToDTO(savedPokemon);

        return pokemonToReturn;

    }

    @Transactional
    public String deletePokemon(UUID uuid) {
        if (pokemonRepository.deleteByUuid(uuid) == 1) {
            return "Delete success";
        } else {
            return "Delete error";
        }
    }

    public PokemonEntity mapDTOTOEntity(PokemonDTO pokemonDTO) {
        PokemonEntity pokemonEntity = new PokemonEntity();
        pokemonEntity.setName(pokemonDTO.getName());
        pokemonEntity.setCategory(pokemonDTO.getCategory());
        pokemonEntity.setAbilities(pokemonDTO.getAbilities());
        pokemonEntity.setType(pokemonDTO.getType());
        pokemonEntity.setColor(pokemonDTO.getColor());
        pokemonEntity.setWeight(pokemonDTO.getWeight());
        pokemonEntity.setHeight(pokemonDTO.getHeight());
        return pokemonEntity;
    }

    public PokemonDTO mapEntityToDTO(PokemonEntity pokemonEntity) {
        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setUuid(pokemonEntity.getUuid());
        pokemonDTO.setId(pokemonEntity.getId());
        pokemonDTO.setName(pokemonEntity.getName());
        pokemonDTO.setCategory(pokemonEntity.getCategory());
        pokemonDTO.setAbilities(pokemonEntity.getAbilities());
        pokemonDTO.setType(pokemonEntity.getType());
        pokemonDTO.setColor(pokemonEntity.getColor());
        pokemonDTO.setHeight(pokemonEntity.getHeight());
        pokemonDTO.setWeight(pokemonEntity.getWeight());
        return pokemonDTO;
    }


}
