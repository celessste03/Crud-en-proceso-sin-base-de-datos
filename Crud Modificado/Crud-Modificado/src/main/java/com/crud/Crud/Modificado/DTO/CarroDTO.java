package com.crud.Crud.Modificado.DTO;


public class CarroDTO {

    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private Long personaId;  // Solo el ID de la persona (relación con Persona)

    public CarroDTO(Long id, String marca, String modelo, String placa, Long personaId) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.personaId = personaId;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }
}