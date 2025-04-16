package com.example.api_manager_tasks.DTO;

import com.example.api_manager_tasks.model.Emprego;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmpregoDTO {

    public Emprego toEntity(EmpregoDTO dto){
        return new Emprego(id, endereco);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "endereço")
    private String endereco;
}
