package com.example.api_manager_tasks.controller;

import com.example.api_manager_tasks.DTO.EmpregoDTO;
import com.example.api_manager_tasks.model.Emprego;
import com.example.api_manager_tasks.service.EmpregoService;
import com.example.api_manager_tasks.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("/empregos")
@AllArgsConstructor
public class EmpregoController {

    private final EmpregoService service;

    @GetMapping
    public ResponseEntity<List<Emprego>> findAll(){
        List<Emprego> empregos = service.findAll();
        return ResponseEntity.ok(empregos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprego> findById(@PathVariable Long id){
        Emprego emprego = service.findById(id);
        return ResponseEntity.ok(emprego);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody EmpregoDTO empregoDTO){
        Emprego foundEmprego = service.create(empregoDTO.toEntity(empregoDTO));

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(foundEmprego.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody EmpregoDTO empregoDTO){
        service.update(id, empregoDTO.toEntity(empregoDTO));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
