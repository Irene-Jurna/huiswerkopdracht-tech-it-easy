package org.example.huiswerktechiteasy.controllers;

import jakarta.validation.Valid;
import org.example.huiswerktechiteasy.dtos.TelevisionDto;
import org.example.huiswerktechiteasy.dtos.TelevisionInputDto;
import org.example.huiswerktechiteasy.exceptions.RecordNotFoundException;
import org.example.huiswerktechiteasy.mappers.TelevisionMapper;
import org.example.huiswerktechiteasy.models.Television;
import org.example.huiswerktechiteasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {
    private final TelevisionService tvService;

    public TelevisionController(TelevisionService tvService) {
        this.tvService = tvService;
    }

    @PostMapping
    public ResponseEntity<TelevisionDto> createTelevision(@Valid @RequestBody TelevisionInputDto tvDto) {
        Television tv = this.tvService.createTelevision(tvDto);
        TelevisionDto tvResponseDto = TelevisionMapper.toDto(tv);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + tv.getId()).toUriString());
        return ResponseEntity.created(uri).body(tvResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
        List<Television> tvList = this.tvService.getAllTelevisions();
        List<TelevisionDto> tvResponseList  = tvList.stream().map(TelevisionMapper::toDto).toList();
        return ResponseEntity.ok(tvResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevisionById(@PathVariable Long id) {
        return ResponseEntity.ok(TelevisionMapper.toDto(this.tvService.getTelevisionById(id)));
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Television> updateTelevisionById(@PathVariable Long id, @RequestBody Television tv) {
//        var existingTv = this.tvRepository.findById(id);
//        if (existingTv.isPresent()) {
//            Television updatedTelevision = existingTv.get();
//            updatedTelevision.setType(tv.getType());
//            updatedTelevision.setBrand(tv.getBrand());
//            updatedTelevision.setName(tv.getName());
//            updatedTelevision.setPrice(tv.getPrice());
//            updatedTelevision.setAvailableSize(tv.getAvailableSize());
//            updatedTelevision.setRefreshRate(tv.getRefreshRate());
//            updatedTelevision.setScreenType(tv.getScreenType());
//            updatedTelevision.setScreenQuality(tv.getScreenQuality());
//            updatedTelevision.setSmartTv(tv.getSmartTv());
//            updatedTelevision.setWifi(tv.getWifi());
//            updatedTelevision.setVoiceControl(tv.getVoiceControl());
//            updatedTelevision.setHdr(tv.getHdr());
//            updatedTelevision.setBluetooth(tv.getBluetooth());
//            updatedTelevision.setAmbiLight(tv.getAmbiLight());
//            updatedTelevision.setOriginalStock(tv.getOriginalStock());
//            updatedTelevision.setSold(tv.getSold());
//            return ResponseEntity.ok(tvRepository.save(updatedTelevision));
//        }
//        throw new RecordNotFoundException("Televisie met id=" + id + " bestaat niet.");
//    }
//
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteTelevisionById(@PathVariable Long id) {
//            if (tvRepository.existsById(id)) {
//                tvRepository.deleteById(id);
//                return ResponseEntity.noContent().build();
//            }
//        throw new RecordNotFoundException("Televisie met id=" + id + " bestaat niet.");
//    }

}
