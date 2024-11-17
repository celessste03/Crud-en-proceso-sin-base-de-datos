package com.crud.Crud.Modificado.Mappers;
import com.crud.Crud.Modificado.DTO.PersonaDTO;
import com.crud.Crud.Modificado.Entities.Persona;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonaMapper {

    public PersonaDTO personaToPersonaDTO(Persona persona) {
        List<Long> carrosIds = persona.getCarros().stream()
                .map(carro -> carro.getId())
                .collect(Collectors.toList());

        return new PersonaDTO(
                persona.getId(),
                persona.getNombre(),
                persona.getApellido(),
                carrosIds
        );
    }

    public Persona personaDTOToPersona(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setId(personaDTO.getId());
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        return persona;
    }
}