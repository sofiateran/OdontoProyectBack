package odontologoOrg.demo.records;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.dentists.ChangePasswordDTO;
import odontologoOrg.demo.dentists.Dentist;
import odontologoOrg.demo.dentists.DentistService;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import odontologoOrg.demo.patients.Patient;
import odontologoOrg.demo.patients.PatientService;
import odontologoOrg.demo.shifts.Shift;
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
    private final PatientService patientService;
    @GetMapping("/")
    public ResponseEntity<List<Record>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/newRecord")
    public ResponseEntity<String> save(@RequestBody RecordDTO recordDTO) throws ResourceNotFoundException {
        service.save(recordDTO);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @GetMapping("/findByPatient/{id}")
    public ResponseEntity<List<Record>> findByPatient(@PathVariable int id) throws ResourceNotFoundException {
        Patient patient = patientService.getById(id).orElseThrow(() -> new ResourceNotFoundException("El paciente con id: " + id + " no existe en la base de datos"));
        List<Record> records = service.findByPatient(patient);
        return ResponseEntity.ok(records);
    }


    @PutMapping("/modifyRecord")
    public ResponseEntity<String> modify(@RequestBody RecordDTO recordDTO) {
        service.modify(recordDTO);
        return ResponseEntity.ok("Se modifico la ficha");
    }

    @PutMapping("/modifyMoneyRecord")
    public ResponseEntity<String> modifyMoney(@RequestBody RecordDTO recordDTO) {
        service.modifyMoney(recordDTO);
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
