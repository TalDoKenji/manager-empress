package com.example.api_manager_tasks.controller;

import com.example.api_manager_tasks.DTO.PessoaDTO;
import com.example.api_manager_tasks.model.Emprego;
import com.example.api_manager_tasks.model.Pessoa;
import com.example.api_manager_tasks.service.EmpregoService;
import com.example.api_manager_tasks.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
@AllArgsConstructor
public class PessoaController {

    private final PessoaService service;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> pessoas = service.findAll();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        Pessoa pessoa = service.findById(id);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa foundPessoa = service.create(pessoaDTO.toEntity(pessoaDTO));

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(foundPessoa.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
        service.update(id, pessoaDTO.toEntity(pessoaDTO));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
