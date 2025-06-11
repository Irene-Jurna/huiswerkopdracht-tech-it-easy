package org.example.huiswerktechiteasy.controllers;

import org.example.huiswerktechiteasy.exceptions.RecordNotFoundException;
import org.example.huiswerktechiteasy.models.Television;
import org.example.huiswerktechiteasy.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {
    private final TelevisionRepository tvRepository;

    public TelevisionController(TelevisionRepository tvRepository) {
        this.tvRepository = tvRepository;
    }

    @PostMapping
    public ResponseEntity<Television> createTelevision(@RequestBody Television tv) {
        this.tvRepository.save(tv);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + tv.getId()).toUriString());
        return ResponseEntity.created(uri).body(tv);
    }

    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions() {
        List<Television> tvList = this.tvRepository.findAll();
        return ResponseEntity.ok(tvList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable Long id) {
        var optionalTelevision = tvRepository.findById(id);
            if (optionalTelevision.isPresent()) {
                return ResponseEntity.ok(optionalTelevision.get());
            }
        throw new RecordNotFoundException("Televisie met id=" + id + " bestaat niet.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevisionById(@PathVariable Long id, @RequestBody Television tv) {
        var existingTv = this.tvRepository.findById(id);
        if (existingTv.isPresent()) {
            Television updatedTelevision = existingTv.get();
            updatedTelevision.setType(tv.getType());
            updatedTelevision.setBrand(tv.getBrand());
            updatedTelevision.setName(tv.getName());
            updatedTelevision.setPrice(tv.getPrice());
            updatedTelevision.setAvailableSize(tv.getAvailableSize());
            updatedTelevision.setRefreshRate(tv.getRefreshRate());
            updatedTelevision.setScreenType(tv.getScreenType());
            updatedTelevision.setScreenQuality(tv.getScreenQuality());
            updatedTelevision.setSmartTv(tv.getSmartTv());
            updatedTelevision.setWifi(tv.getWifi());
            updatedTelevision.setVoiceControl(tv.getVoiceControl());
            updatedTelevision.setHdr(tv.getHdr());
            updatedTelevision.setBluetooth(tv.getBluetooth());
            updatedTelevision.setAmbiLight(tv.getAmbiLight());
            updatedTelevision.setOriginalStock(tv.getOriginalStock());
            updatedTelevision.setSold(tv.getSold());
            return ResponseEntity.ok(tvRepository.save(updatedTelevision));
        }
        throw new RecordNotFoundException("Televisie met id=" + id + " bestaat niet.");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevisionById(@PathVariable Long id) {
            if (tvRepository.existsById(id)) {
                tvRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            }
        throw new RecordNotFoundException("Televisie met id=" + id + " bestaat niet.");
    }

}
