package com.example.asignacion_3.controllers;

import com.example.asignacion_3.models.Director;
import com.example.asignacion_3.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping("/all")
    public ArrayList<Director> getDirectors() {
        return directorService.getAllDirectors();
    }

    @PostMapping("/add")
    public boolean addDirector(@RequestBody Director director) {
        return directorService.addDirector(director);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> findDirector(@PathVariable Long id) {
        Director director = directorService.getDirectorById(id);

        if (director != null) {
            return ResponseEntity.ok(director);
        }

        return ResponseEntity.notFound().build();
    }
}
