package com.example.pokemonapi.service;

import com.example.pokemonapi.dto.ArenaDTO;
import com.example.pokemonapi.model.ArenaEntity;
import com.example.pokemonapi.repository.ArenaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
public class ArenaService {
    private final ArenaRepository arenaRepository;

    public ArenaService(ArenaRepository arenaRepository) {
        this.arenaRepository = arenaRepository;
    }

    public ArenaDTO createArena(ArenaDTO arenaDTO) {

        ArenaEntity arena = mapDTOToEntity(arenaDTO);
        ArenaEntity savedArena = arenaRepository.save(arena);
        ArenaDTO arenaToReturn = mapEntityToDTO(savedArena);
        return arenaToReturn;

    }

    public ArenaDTO getArenaByString(String str) {
        String[] strArray = str.split("-");
        ArenaEntity arenaEntity = arenaRepository.findFirstArenaEntityByNameContainsIgnoreCase(strArray[0]);
        return mapEntityToDTO(arenaEntity);
    }

    public List<ArenaDTO> getAllArenas() {
        List<ArenaEntity> arenaEntities = arenaRepository.findAll();
        List<ArenaDTO> arenaDTOS = arenaEntities
                .stream()
                .map(arenaEntity -> mapEntityToDTO(arenaEntity))
                .toList();
        return arenaDTOS;
    }

    @Transactional
    public String deleteArena(UUID uuid) {
        if (arenaRepository.deleteByUuid(uuid) == 1) {
            return "Delete success";
        } else {
            return "Delete error";
        }
    }

    private ArenaDTO mapEntityToDTO(ArenaEntity arenaEntity) {
        ArenaDTO arenaDTO = new ArenaDTO();
        arenaDTO.setId(arenaEntity.getId());
        arenaDTO.setUuid(arenaEntity.getUuid());
        arenaDTO.setName(arenaEntity.getName());
        arenaDTO.setLeaderName(arenaEntity.getLeaderName());
        arenaDTO.setType(arenaEntity.getType());
        return arenaDTO;
    }

    private ArenaEntity mapDTOToEntity(ArenaDTO arenaDTO) {
        ArenaEntity arenaEntity = new ArenaEntity();
        arenaEntity.setName(arenaDTO.getName());
        arenaEntity.setType(arenaDTO.getType());
        arenaEntity.setLeaderName(arenaDTO.getLeaderName());
        return arenaEntity;
    }


}
