package odontologoOrg.demo.dentists;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/dentists")
@RestController
@AllArgsConstructor
@CrossOrigin
public class DentistController {
    private final DentistService service;

    @GetMapping("/")
    public ResponseEntity<List<Dentist>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/newDentist")
    public ResponseEntity<String> save(@RequestBody Dentist dentist) throws ResourceNotFoundException {
        service.save(dentist);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modifyDentist")
    public ResponseEntity<String> modify(@RequestBody Dentist dentist) {
        service.modify(dentist);
        return ResponseEntity.ok("Se modifico el odontologo");
    }

    @PutMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) throws ResourceNotFoundException {
        service.changePassword(changePasswordDTO);
        return ResponseEntity.ok("Se cambio la contraseña del odontologo");
    }


    @DeleteMapping("/deleteDentist")
    public ResponseEntity<String>  delete(@RequestBody int id) throws ResourceNotFoundException {
        service.delete(id);
        return ResponseEntity.ok("Se eliminó de la base de datos el odontologo con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Dentist>> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
