package org.example.huiswerktechiteasy.services;

import org.example.huiswerktechiteasy.dtos.TelevisionInputDto;
import org.example.huiswerktechiteasy.mappers.TelevisionMapper;
import org.example.huiswerktechiteasy.models.Television;
import org.example.huiswerktechiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public Television createTelevision(TelevisionInputDto tvDto) {
        return this.televisionRepository.save(TelevisionMapper.toEntity(tvDto));
    }
}
