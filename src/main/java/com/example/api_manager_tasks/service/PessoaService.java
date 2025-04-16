package com.example.api_manager_tasks.service;

import com.example.api_manager_tasks.model.Pessoa;
import com.example.api_manager_tasks.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;

    public List<Pessoa> findAll(){
        return repository.findAll();
    }

    public Pessoa findById(Long id){
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("not found"));
    }

    public Pessoa create(Pessoa pessoa){
        return repository.save(pessoa);
    }

    public void update(Long id, Pessoa pessoa){
        Pessoa foundPessoa = this.findById(id);

        foundPessoa.setNome(pessoa.getNome());
        foundPessoa.setIdade(pessoa.getIdade());
        repository.save(foundPessoa);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
