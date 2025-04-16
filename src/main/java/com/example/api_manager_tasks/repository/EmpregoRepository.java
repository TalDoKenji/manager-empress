package com.example.api_manager_tasks.repository;

import com.example.api_manager_tasks.model.Emprego;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpregoRepository extends JpaRepository<Emprego, Long> {

}
