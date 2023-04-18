package odontologoOrg.demo.treatments.face;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import odontologoOrg.demo.treatments.piece.TreatmentPiece;
import odontologoOrg.demo.treatments.piece.TreatmentPieceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/treatmentFace")
@RestController
@AllArgsConstructor
@CrossOrigin
public class TreatmentFaceController {

        private final TreatmentFaceService service;

        @GetMapping("/")
        public ResponseEntity<List<TreatmentFace>> findAll() {
            return ResponseEntity.ok(service.findAll());
        }

        @PostMapping("/newTreatmentFace")
        public ResponseEntity<String> save(@RequestBody TreatmentFace treatmentFace) throws ResourceNotFoundException {
            service.save(treatmentFace);
            return ResponseEntity.ok("Se agregó a la base de datos");
        }

        @PutMapping("/modifyTreatmentFace")
        public ResponseEntity<String> modify(@RequestBody TreatmentFace treatmentFace) {
            service.modify(treatmentFace);
            return ResponseEntity.ok("Se modifico la cara del diente");
        }


        @DeleteMapping("/deleteTreatmentFace")
        public ResponseEntity<String>  delete(@RequestBody int id) throws ResourceNotFoundException {
            service.delete(id);
            return ResponseEntity.ok("Se eliminó de la base de datos la cara del diente con id: " + id);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Optional<TreatmentFace>> getById(@PathVariable int id) {
            return ResponseEntity.ok(service.getById(id));
        }


}
