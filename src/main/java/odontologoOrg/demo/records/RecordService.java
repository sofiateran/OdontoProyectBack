package odontologoOrg.demo.records;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.TreatmentName.TreatmentNameService;
import odontologoOrg.demo.TreatmentPiece.TreatmentPieceService;
import odontologoOrg.demo.TreatmentFace.TreatmentFaceService;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;

import odontologoOrg.demo.patients.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecordService {

    private final RecordRepository repository;
    private final PatientService patientService;

    private final TreatmentNameService treatmentNameService;
    private final TreatmentFaceService treatmentFaceService;
    private final TreatmentPieceService treatmentPieceService;

    public void save(RecordDTO recordDTO) throws ResourceNotFoundException {
        var tName = treatmentNameService.getById(recordDTO.treatmentName()).orElseThrow(()-> new ResourceNotFoundException("treatmentName no encontrado"));
        var tFace = treatmentFaceService.getById(recordDTO.treatmentFace()).orElseThrow(()-> new ResourceNotFoundException("TreatmentFace no encontrado"));
        var tPiece = treatmentPieceService.getById(recordDTO.treatmentPiece()).orElseThrow(()-> new ResourceNotFoundException("treatmentPiece no encontrado"));
        var patient = patientService.getById(recordDTO.patientId()).orElseThrow();
        repository.save(new Record(recordDTO.id(),recordDTO.date(), patient,tName,tFace,tPiece, recordDTO.budget()));
    }

    public List<Record> findAll()  {
        return repository.findAll();
    }

    public void modify(RecordDTO recordDTO){
        var tName = treatmentNameService.getById(recordDTO.treatmentName()).orElseThrow();
        var tFace = treatmentFaceService.getById(recordDTO.treatmentFace()).orElseThrow();
        var tPiece = treatmentPieceService.getById(recordDTO.treatmentPiece()).orElseThrow();
        var patient = patientService.getById(recordDTO.patientId()).orElseThrow();
        repository.save(new Record(recordDTO.id(),recordDTO.date(), patient,tName,tFace,tPiece, recordDTO.budget()));

    }

    public void delete(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("La ficha con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }

    public Optional<Record> getById (int id){
        return repository.findById(id);
    }
}
