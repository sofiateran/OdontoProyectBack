package odontologoOrg.demo.records;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.dentists.ChangePasswordDTO;
import odontologoOrg.demo.dentists.Dentist;
import odontologoOrg.demo.dentists.DentistService;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/records")
@RestController
@AllArgsConstructor
@CrossOrigin
public class RecordController {

    private final RecordService service;

    @GetMapping("/")
    public ResponseEntity<List<Record>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/newRecord")
    public ResponseEntity<String> save(@RequestBody RecordDTO recordDTO) throws ResourceNotFoundException {
        service.save(recordDTO);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modifyRecord")
    public ResponseEntity<String> modify(@RequestBody RecordDTO recordDTO) {
        service.modify(recordDTO);
        return ResponseEntity.ok("Se modifico la ficha");
    }


    @DeleteMapping("/deleteRecord")
    public ResponseEntity<String>  delete(@RequestBody int id) throws ResourceNotFoundException {
        service.delete(id);
        return ResponseEntity.ok("Se eliminó de la base de datos la ficha con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Record>> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
