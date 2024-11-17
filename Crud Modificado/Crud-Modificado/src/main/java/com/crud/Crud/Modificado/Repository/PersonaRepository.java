package com.crud.Crud.Modificado.Repository;
import com.crud.Crud.Modificado.Entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}