package com.crud.Crud.Modificado.Servicios;
import com.crud.Crud.Modificado.DTO.CarroDTO;
import com.crud.Crud.Modificado.Entities.Carro;
import com.crud.Crud.Modificado.Entities.Persona;
import com.crud.Crud.Modificado.Mappers.CarroMapper;
import com.crud.Crud.Modificado.Mappers.PersonaMapper;
import com.crud.Crud.Modificado.Repository.CarroRepository;
import com.crud.Crud.Modificado.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicioCarro {

    private final CarroRepository carroRepository;
    private final PersonaRepository personaRepository;
    private final CarroMapper carroMapper;
    private final PersonaMapper personaMapper;

    @Autowired
    public ServicioCarro(CarroRepository carroRepository, PersonaRepository personaRepository,
                         CarroMapper carroMapper, PersonaMapper personaMapper) {
        this.carroRepository = carroRepository;
        this.personaRepository = personaRepository;
        this.carroMapper = carroMapper;
        this.personaMapper = personaMapper;
    }

    public List<CarroDTO> getCarros() {
        return carroRepository.findAll().stream()
                .map(carroMapper::carroToCarroDTO)
                .collect(Collectors.toList());
    }

    public Optional<CarroDTO> getCarroById(Long id) {
        Optional<Carro> carro = carroRepository.findById(id);
        return carro.map(carroMapper::carroToCarroDTO);
    }

    public CarroDTO crearCarro(CarroDTO carroDTO) {
        Carro carro = carroMapper.carroDTOToCarro(carroDTO);
        Optional<Persona> persona = personaRepository.findById(carroDTO.getPersonaId());
        if (persona.isPresent()) {
            carro.setPersona(persona.get());
            Carro carroGuardado = carroRepository.save(carro);
            return carroMapper.carroToCarroDTO(carroGuardado);
        } else {
            throw new IllegalArgumentException("Persona no encontrada.");
        }
    }

    public Optional<CarroDTO> actualizarCarro(Long id, CarroDTO detallesCarroDTO) {
        Optional<Carro> carroExistente = carroRepository.findById(id);
        if (carroExistente.isPresent()) {
            Carro carro = carroExistente.get();
            carro.setMarca(detallesCarroDTO.getMarca());
            carro.setModelo(detallesCarroDTO.getModelo());
            carro.setPlaca(detallesCarroDTO.getPlaca());
            Optional<Persona> persona = personaRepository.findById(detallesCarroDTO.getPersonaId());
            persona.ifPresent(carro::setPersona);
            Carro carroActualizado = carroRepository.save(carro);
            return Optional.of(carroMapper.carroToCarroDTO(carroActualizado));
        } else {
            return Optional.empty();
        }
    }

    public boolean EliminarCarro(Long id) {
        if (carroRepository.existsById(id)) {
            carroRepository.deleteById(id);
            return true;
        }
        return false;
    }
}