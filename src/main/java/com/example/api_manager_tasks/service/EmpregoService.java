package com.example.api_manager_tasks.service;

import com.example.api_manager_tasks.DTO.EmpregoDTO;
import com.example.api_manager_tasks.model.Emprego;
import com.example.api_manager_tasks.repository.EmpregoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@AllArgsConstructor
public class EmpregoService {

    private final EmpregoRepository repository;

    public List<Emprego> findAll(){
        return repository.findAll();
    }

    public Emprego findById(Long id){
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("not found"));
    }

    public Emprego create(Emprego emprego){
        return repository.save(emprego);
    }

    public void update(Long id, Emprego emprego){
        Emprego foundEmprego = this.findById(id);
        foundEmprego.setEndereco(emprego.getEndereco());

        repository.save(foundEmprego);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
