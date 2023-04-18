package odontologoOrg.demo.treatments;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.dentists.ChangePasswordDTO;
import odontologoOrg.demo.dentists.Dentist;
import odontologoOrg.demo.dentists.DentistService;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/treatments")
@CrossOrigin
public class TreatmentController {
    private final TreamentService service;

    @GetMapping("/")
    public ResponseEntity<List<Treatment>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/newTreatment")
    public ResponseEntity<String> save(@RequestBody TreatmentDTO treatment) throws ResourceNotFoundException {
        service.save(treatment);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modifyTreatment")
    public ResponseEntity<String> modify(@RequestBody TreatmentDTO treatment) {
        service.modify(treatment);
        return ResponseEntity.ok("Se modifico el tratamiento");
    }


    @DeleteMapping("/deleteDentist")
    public ResponseEntity<String>  delete(@RequestBody int id) throws ResourceNotFoundException {
        service.delete(id);
        return ResponseEntity.ok("Se eliminó de la base de datos el tratamiento con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Treatment>> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
