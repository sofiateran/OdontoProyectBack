package odontologoOrg.demo.treatments.name;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import odontologoOrg.demo.treatments.piece.TreatmentPiece;
import odontologoOrg.demo.treatments.piece.TreatmentPieceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/treatmentName")
@RestController
@AllArgsConstructor
@CrossOrigin
public class TreatmentNameController {


        private final TreatmentNameService service;

        @GetMapping("/")
        public ResponseEntity<List<TreatmentName>> findAll() {
            return ResponseEntity.ok(service.findAll());
        }

        @PostMapping("/newTreatmentName")
        public ResponseEntity<String> save(@RequestBody TreatmentName treatmentName) throws ResourceNotFoundException {
            service.save(treatmentName);
            return ResponseEntity.ok("Se agregó a la base de datos");
        }

        @PutMapping("/modifyTreatmentName")
        public ResponseEntity<String> modify(@RequestBody TreatmentName treatmentName) {
            service.modify(treatmentName);
            return ResponseEntity.ok("Se modifico el nombre del tratamiento");
        }


        @DeleteMapping("/deleteTreatmentName")
        public ResponseEntity<String>  delete(@RequestBody int id) throws ResourceNotFoundException {
            service.delete(id);
            return ResponseEntity.ok("Se eliminó de la base de datos el nombre del tratamiento con id: " + id);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Optional<TreatmentName>> getById(@PathVariable int id) {
            return ResponseEntity.ok(service.getById(id));
        }


}
