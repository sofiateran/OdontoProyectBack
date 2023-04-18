package odontologoOrg.demo.treatments;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.dentists.Dentist;
import odontologoOrg.demo.dentists.DentistRepository;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import odontologoOrg.demo.treatments.face.TreatmentFaceService;
import odontologoOrg.demo.treatments.name.TreatmentNameService;
import odontologoOrg.demo.treatments.piece.TreatmentPieceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class TreamentService {
    private final TreatmentRepository repository;
    private final TreatmentNameService treatmentNameService;
    private final TreatmentFaceService treatmentFaceService;
    private final TreatmentPieceService treatmentPieceService;

    public void save(TreatmentDTO treatment) throws ResourceNotFoundException {
        var treatmentName = treatmentNameService.getById(treatment.treatmentNameId()).orElseThrow();
        var treatmentFace = treatmentFaceService.getById(treatment.treatmentFaceId()).orElseThrow();
        var treatmentPiece = treatmentPieceService.getById(treatment.treatmentPieceId()).orElseThrow();
        repository.save(new Treatment(treatment.id(), treatmentName, treatmentPiece, treatmentFace, treatment.status()));

    }

    public List<Treatment> findAll()  {
        return repository.findAll();
    }

    public void modify(TreatmentDTO treatment){
        var treatmentName = treatmentNameService.getById(treatment.treatmentNameId()).orElseThrow();
        var treatmentFace = treatmentFaceService.getById(treatment.treatmentFaceId()).orElseThrow();
        var treatmentPiece = treatmentPieceService.getById(treatment.treatmentPieceId()).orElseThrow();
        repository.save(new Treatment(treatment.id(), treatmentName, treatmentPiece, treatmentFace, treatment.status()));
    }

    public void delete(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El tratamiento con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }

    public Optional<Treatment> getById (int id){
        return repository.findById(id);
    }

}
