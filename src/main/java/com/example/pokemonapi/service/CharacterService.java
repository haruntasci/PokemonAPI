package com.example.pokemonapi.service;

import com.example.pokemonapi.dto.CharacterDTO;
import com.example.pokemonapi.model.CharacterEntity;
import com.example.pokemonapi.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public CharacterDTO createCharacter(CharacterDTO characterDTO) {
        CharacterEntity character = mapDTOToEntity(characterDTO);

        CharacterEntity savedCharacter = characterRepository.save(character);

        CharacterDTO characterToReturn = mapEntityToDTO(savedCharacter);
        return characterToReturn;
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
