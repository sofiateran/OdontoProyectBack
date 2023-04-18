package odontologoOrg.demo.treatments.piece;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.dentists.ChangePasswordDTO;
import odontologoOrg.demo.dentists.Dentist;
import odontologoOrg.demo.dentists.DentistService;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/treatmentPiece")
@RestController
@AllArgsConstructor
@CrossOrigin
public class TreatmentPieceController {
    private final TreatmentPieceService service;

    @GetMapping("/")
    public ResponseEntity<List<TreatmentPiece>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/newTreatmentPiece")
    public ResponseEntity<String> save(@RequestBody TreatmentPiece treatmentPiece) throws ResourceNotFoundException {
        service.save(treatmentPiece);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modifyTreatmentPiece")
    public ResponseEntity<String> modify(@RequestBody TreatmentPiece treatmentPiece) {
        service.modify(treatmentPiece);
        return ResponseEntity.ok("Se modifico la pieza del tratamiento");
    }


    @DeleteMapping("/deleteTreatmentPiece")
    public ResponseEntity<String>  delete(@RequestBody int id) throws ResourceNotFoundException {
        service.delete(id);
        return ResponseEntity.ok("Se eliminó de la base de datos la pieza del tratamiento con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TreatmentPiece>> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
