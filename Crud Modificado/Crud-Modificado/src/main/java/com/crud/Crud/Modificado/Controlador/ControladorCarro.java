package com.crud.Crud.Modificado.Controlador;
import com.crud.Crud.Modificado.DTO.CarroDTO;
import com.crud.Crud.Modificado.Servicios.ServicioCarro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class ControladorCarro {

    private final ServicioCarro servicioCarro;

    @Autowired
    public ControladorCarro(ServicioCarro servicioCarro) {
        this.servicioCarro = servicioCarro;
    }

    @GetMapping
    public List<CarroDTO> getAllCarros() {
        return servicioCarro.getCarros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> getCarroById(@PathVariable Long id) {
        return servicioCarro.getCarroById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CarroDTO> crearCarro(@RequestBody CarroDTO carroDTO) {
        try {
            CarroDTO nuevoCarroDTO = servicioCarro.crearCarro(carroDTO);
            return ResponseEntity.ok(nuevoCarroDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> actualizarCarro(@PathVariable Long id, @RequestBody CarroDTO carroDTO) {
        return servicioCarro.actualizarCarro(id, carroDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarro(@PathVariable Long id) {
        return servicioCarro.EliminarCarro(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}