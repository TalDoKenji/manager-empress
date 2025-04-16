package com.example.api_manager_tasks.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "table_emprego")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emprego {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "endereço")
    private String endereco;

}
