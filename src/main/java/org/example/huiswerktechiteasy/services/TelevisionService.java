package org.example.huiswerktechiteasy.services;

import org.example.huiswerktechiteasy.dtos.EmployeeTelevisionInputDto;
import org.example.huiswerktechiteasy.exceptions.RecordNotFoundException;
import org.example.huiswerktechiteasy.mappers.TelevisionMapper;
import org.example.huiswerktechiteasy.models.Television;
import org.example.huiswerktechiteasy.repositories.TelevisionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    private Television findTelevisionOrThrow(Long id, String action) {
        return televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Cannot " + action + " television with id " + id + " because it does not exist."));
    }

    public Television createTelevision(EmployeeTelevisionInputDto tvDto) {
        return this.televisionRepository.save(TelevisionMapper.toEntity(tvDto));
    }

    public List<Television> getAllTelevisions() {
        return this.televisionRepository.findAll();
    }

    public Television getTelevisionById(Long id) {
        return findTelevisionOrThrow(id, "get");
    }

    public Television updateTelevisionById(Long id, EmployeeTelevisionInputDto tvDto) {
        Television existingTv = findTelevisionOrThrow(id, "update");
        BeanUtils.copyProperties(tvDto, existingTv);
        return this.televisionRepository.save(existingTv);
    }

    public void deleteTelevisionById(Long id) {
        Television tv = findTelevisionOrThrow(id, "delete");
        this.televisionRepository.delete(tv);
    }
}
