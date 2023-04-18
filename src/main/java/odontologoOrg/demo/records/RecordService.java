package odontologoOrg.demo.records;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.dentists.Dentist;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;

import odontologoOrg.demo.patients.PatientService;
import odontologoOrg.demo.treatments.Treatment;
import odontologoOrg.demo.treatments.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecordService {

    private final RecordRepository repository;
    private final PatientService patientService;

    public void save(RecordDTO recordDTO) throws ResourceNotFoundException {

        var patient = patientService.getById(recordDTO.patientId()).orElseThrow();
        repository.save(new Record(recordDTO.id(),recordDTO.date(), patient, recordDTO.treatment(), recordDTO.budget()));

    }

    public List<Record> findAll()  {
        return repository.findAll();
    }

    public void modify(RecordDTO recordDTO){
        var patient = patientService.getById(recordDTO.patientId()).orElseThrow();
        repository.save(new Record(recordDTO.id(), recordDTO.date(), patient, recordDTO.treatment(), recordDTO.budget()));

    }

    public void delete(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("La ficha con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }

    public Optional<Record> getById (int id){
        return repository.findById(id);
    }
}
