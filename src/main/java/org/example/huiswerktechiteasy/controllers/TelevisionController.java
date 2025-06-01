package org.example.huiswerktechiteasy.controllers;

import org.example.huiswerktechiteasy.exceptions.RecordNotFoundException;
import org.example.huiswerktechiteasy.models.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {
    private final List<Television> televisionList = new ArrayList<>();
    private int currentId = 1;

    @PostMapping
    public ResponseEntity<Television> createTelevision(@RequestBody Television tv) {
        tv.setId(currentId++);
        this.televisionList.add(tv);
        return ResponseEntity.status(HttpStatus.CREATED).body(tv);
    }

    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions() {
        return ResponseEntity.ok(this.televisionList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable int id) {
        for (Television tv : televisionList) {
            if (tv.getId() == id) {
                return ResponseEntity.ok(tv);
            }
        }
        throw new RecordNotFoundException("Televisie met id=" + id + " bestaat niet.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevisionById(@PathVariable int id, @RequestBody Television tv) {
        for (int i = 0; i < televisionList.size(); i++) {
            if (televisionList.get(i).getId() == id) {
                tv.setId(id);
                televisionList.set(i, tv);
                return ResponseEntity.ok(tv);
            }
        }
        throw new RecordNotFoundException("Televisie met id=" + id + " bestaat niet.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevisionById(@PathVariable int id) {
        for (int i = 0; i < televisionList.size(); i++) {
            if (televisionList.get(i).getId() == id) {
                televisionList.remove(i);
                return ResponseEntity.ok("Televisie met id=" + id + " is verwijderd.");
            }
        }
        throw new RecordNotFoundException("Televisie met id=" + id + " bestaat niet.");
    }

}
