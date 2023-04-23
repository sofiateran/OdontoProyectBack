package odontologoOrg.demo.patients;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.dentists.Dentist;
import odontologoOrg.demo.dentists.DentistService;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/patients")
@RestController
@AllArgsConstructor
public class PatientController {
    private final PatientService service;
    private final DentistService dentistService;

    @GetMapping("/")
    public ResponseEntity<List<Patient>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/findByDentist/{id}")
    public ResponseEntity<List<Patient>> findByDentist(@PathVariable int id)throws ResourceNotFoundException  {
        Dentist dentist = dentistService.getById(id).orElseThrow(() -> new ResourceNotFoundException("El odontologo con id: " + id + " no existe en la base de datos"));
        List<Patient> patients = service.findByDentist(dentist);
        return ResponseEntity.ok(patients);
    }

    @PostMapping("/newPatient")
    public ResponseEntity<String> save(@RequestBody PatientDTO patient) throws ResourceNotFoundException {
        service.save(patient);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modifyPatient")
    public ResponseEntity<String> modify(@RequestBody PatientDTO patient) {
        service.modify(patient);
        return ResponseEntity.ok("Se modifico el paciente");
    }

    @DeleteMapping("/deletePatient")
    public ResponseEntity<String> delete(@RequestBody int id) throws ResourceNotFoundException {
        service.delete(id);
        return ResponseEntity.ok("Se eliminó de la base de datos el paciente con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Patient>> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

}
