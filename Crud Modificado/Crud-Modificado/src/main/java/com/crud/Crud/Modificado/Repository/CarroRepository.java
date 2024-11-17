package com.crud.Crud.Modificado.Repository;
import com.crud.Crud.Modificado.Entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}