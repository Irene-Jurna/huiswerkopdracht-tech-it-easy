package org.example.huiswerktechiteasy.services;

import org.example.huiswerktechiteasy.dtos.TelevisionInputDto;
import org.example.huiswerktechiteasy.exceptions.RecordNotFoundException;
import org.example.huiswerktechiteasy.mappers.TelevisionMapper;
import org.example.huiswerktechiteasy.models.Television;
import org.example.huiswerktechiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public Television createTelevision(TelevisionInputDto tvDto) {
        return this.televisionRepository.save(TelevisionMapper.toEntity(tvDto));
    }

    public List<Television> getAllTelevisions() {
        return this.televisionRepository.findAll();
    }

    public Television getTelevisionById(Long id) {
        return this.televisionRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("Television " + id + " not found."));
    }

    public Television updateTelevisionById(Long id, TelevisionInputDto tvDto) {
        Television existingTv = this.televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found."));
        existingTv.setBrand(tvDto.getBrand());
        existingTv.setName(tvDto.getName());
        return this.televisionRepository.save(existingTv);
    }

    public void deleteTelevisionById(Long id) {
        Television tv = this.televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found."));
        this.televisionRepository.delete(tv);
    }
}
