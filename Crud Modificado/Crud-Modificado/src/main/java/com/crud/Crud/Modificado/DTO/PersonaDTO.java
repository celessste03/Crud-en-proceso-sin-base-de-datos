package com.crud.Crud.Modificado.DTO;

import java.util.List;

public class PersonaDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private List<Long> carrosIds;  // Lista de IDs de los carros (para evitar la carga completa de los carros)

    public PersonaDTO(Long id, String nombre, String apellido, List<Long> carrosIds) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrosIds = carrosIds;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Long> getCarrosIds() {
        return carrosIds;
    }

    public void setCarrosIds(List<Long> carrosIds) {
        this.carrosIds = carrosIds;
    }
}
