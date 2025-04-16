package com.example.api_manager_tasks.DTO;

import com.example.api_manager_tasks.model.Pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDTO {

    public Pessoa toEntity(PessoaDTO pessoaDTO){
        return new Pessoa(id, nome, idade);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private Integer idade;
}
