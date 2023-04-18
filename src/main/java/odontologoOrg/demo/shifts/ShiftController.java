package odontologoOrg.demo.shifts;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.dentists.Dentist;
import odontologoOrg.demo.dentists.DentistService;
import odontologoOrg.demo.exceptions.DentistNotFound;
import odontologoOrg.demo.exceptions.PatientNotFound;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import odontologoOrg.demo.patients.Patient;
import odontologoOrg.demo.patients.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/shifts")
@CrossOrigin
public class ShiftController {

    private final ShiftService service;
    private final DentistService dentistService;
    private final PatientService patientService;

    private final static Logger logger = LoggerFactory.getLogger(ShiftController.class);

//
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/")
    public ResponseEntity<List<Shift>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/findByDentist/{id}")
    public ResponseEntity<List<Shift>> findByDentist(@PathVariable int id) throws ResourceNotFoundException{
        Dentist dentist = dentistService.getById(id).orElseThrow(() -> new ResourceNotFoundException("El odontologo con id: " + id + " no existe en la base de datos"));
        List<Shift> shifts = service.findByDentist(dentist);
        return ResponseEntity.ok(shifts);
    }

    @GetMapping("/findByPatient/{id}")
    public ResponseEntity<List<Shift>> findByPatient(@PathVariable int id) throws ResourceNotFoundException {
        Patient patient = patientService.getById(id).orElseThrow(() -> new ResourceNotFoundException("El paciente con id: " + id + " no existe en la base de datos"));
        List<Shift> shifts = service.findByPatient(patient);
        return ResponseEntity.ok(shifts);
    }

    @PostMapping("/newShift")
    public ResponseEntity<?> save(@RequestBody ShiftDTO shiftRequest) {
        try {
            return ResponseEntity.ok(service.save(
                    shiftRequest));
        } catch (DentistNotFound | PatientNotFound e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/modifyShift")
    public ResponseEntity<String> modify(@RequestBody ShiftDTO shiftDTO) throws DentistNotFound, PatientNotFound {
        service.modify(shiftDTO);
        return ResponseEntity.ok("Se modifico el turno");
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/deleteShift")
    public ResponseEntity<String> delete(@RequestBody int id) throws ResourceNotFoundException {
        service.delete(id);
        return ResponseEntity.ok("Se eliminó de la base de datos el turno con id: " + id);
    }
//
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/shift/{id}")
    public ResponseEntity<Optional<Shift>> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }
}