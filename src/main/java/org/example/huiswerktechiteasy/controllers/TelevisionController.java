package org.example.huiswerktechiteasy.controllers;

import org.example.huiswerktechiteasy.models.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {
    private List<Television> televisionList = new ArrayList<>();
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
        return ResponseEntity.ok(this.televisionList.get(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Television> updateTelevisionById(@PathVariable int id, @RequestBody Television tv) {
        return ResponseEntity.ok(this.televisionList.get(id));
    }
}
