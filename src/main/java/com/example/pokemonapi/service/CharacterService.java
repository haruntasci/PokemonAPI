package com.example.pokemonapi.service;

import com.example.pokemonapi.dto.BaseDTO;
import com.example.pokemonapi.dto.CharacterDTO;
import com.example.pokemonapi.dto.PokemonDTO;
import com.example.pokemonapi.model.CharacterEntity;
import com.example.pokemonapi.model.PokemonEntity;
import com.example.pokemonapi.repository.CharacterRepository;
import com.example.pokemonapi.repository.PokemonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final PokemonRepository pokemonRepository;
    private final PokemonService pokemonService;

    public CharacterService(CharacterRepository characterRepository, PokemonRepository pokemonRepository, PokemonService pokemonService) {
        this.characterRepository = characterRepository;
        this.pokemonRepository = pokemonRepository;
        this.pokemonService = pokemonService;
    }

    public CharacterDTO createCharacter(CharacterDTO characterDTO) {
        CharacterEntity character = mapDTOToEntity(characterDTO);

        CharacterEntity savedCharacter = characterRepository.save(character);

        CharacterDTO characterToReturn = mapEntityToDTO(savedCharacter);
        return characterToReturn;
    }

    public List<BaseDTO> getCharacterAndPokemonByString(String str) {
        CharacterDTO character = new CharacterDTO();
        PokemonDTO pokemon = new PokemonDTO();
        String[] strArray = str.split("-");
        for (String key : strArray) {
            if (pokemonRepository.findFirstPokemonEntityByNameContainsIgnoreCase(key) != null) {
                pokemon =
                        pokemonService
                                .mapEntityToDTO(pokemonRepository.findFirstPokemonEntityByNameContainsIgnoreCase(key));
            }
            if (characterRepository.findFirstCharacterEntityByNameContainsIgnoreCase(key) != null) {
                character = mapEntityToDTO(characterRepository.findFirstCharacterEntityByNameContainsIgnoreCase(key));
            }
        }
        List<BaseDTO> baseDTOS = new ArrayList<>();
        baseDTOS.add(character);
        baseDTOS.add(pokemon);
        return baseDTOS;
    }

    public CharacterDTO getCharacterByString(String str) {
        String[] strArray = str.split("-");
        CharacterEntity characterEntity = characterRepository
                .findFirstCharacterEntityByNameContainsIgnoreCase(strArray[0]);
        return mapEntityToDTO(characterEntity);
    }

    public List<CharacterDTO> getAllCharacters() {
        List<CharacterEntity> characterEntities = characterRepository.findAll();
        List<CharacterDTO> characterDTOS = characterEntities
                .stream()
                .map(characterEntity -> mapEntityToDTO(characterEntity))
                .toList();
        return characterDTOS;
    }

    @Transactional
    public String deleteCharacter(UUID uuid) {
        if (characterRepository.deleteByUuid(uuid) == 1) {
            return "Delete successful";
        } else {
            return "Error";
        }
    }

    private CharacterDTO mapEntityToDTO(CharacterEntity savedCharacter) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(savedCharacter.getId());
        characterDTO.setUuid(savedCharacter.getUuid());
        characterDTO.setName(savedCharacter.getName());
        characterDTO.setFamily(savedCharacter.getFamily());
        characterDTO.setFriends(savedCharacter.getFriends());
        characterDTO.setOccupation(savedCharacter.getOccupation());
        characterDTO.setGender(savedCharacter.getGender());
        return characterDTO;
    }

    private CharacterEntity mapDTOToEntity(CharacterDTO characterDTO) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setName(characterDTO.getName());
        characterEntity.setFamily(characterDTO.getFamily());
        characterEntity.setFriends(characterDTO.getFriends());
        characterEntity.setOccupation(characterDTO.getOccupation());
        characterEntity.setGender(characterDTO.getGender());
        return characterEntity;
    }


}
