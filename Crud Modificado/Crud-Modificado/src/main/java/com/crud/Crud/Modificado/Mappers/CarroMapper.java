package com.crud.Crud.Modificado.Mappers;
import com.crud.Crud.Modificado.DTO.CarroDTO;
import com.crud.Crud.Modificado.Entities.Carro;
import org.springframework.stereotype.Component;

@Component
public class CarroMapper {

    public CarroDTO carroToCarroDTO(Carro carro) {
        return new CarroDTO(
                carro.getId(),
                carro.getMarca(),
                carro.getModelo(),
                carro.getPlaca(),
                carro.getPersona() != null ? carro.getPersona().getId() : null
        );
    }

    public Carro carroDTOToCarro(CarroDTO carroDTO) {
        Carro carro = new Carro();
        carro.setId(carroDTO.getId());
        carro.setMarca(carroDTO.getMarca());
        carro.setModelo(carroDTO.getModelo());
        carro.setPlaca(carroDTO.getPlaca());
        return carro;
    }
}