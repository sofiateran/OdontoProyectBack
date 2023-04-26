package odontologoOrg.demo.shifts;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.dentists.Dentist;
import odontologoOrg.demo.dentists.DentistService;
import odontologoOrg.demo.exceptions.DentistNotFound;
import odontologoOrg.demo.exceptions.PatientNotFound;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import odontologoOrg.demo.patients.Patient;
import odontologoOrg.demo.patients.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShiftService {
    private final ShiftRepository repository;
    private final PatientService patientService;
    private final DentistService dentistService;

    public Shift save(ShiftDTO dto) throws DentistNotFound, PatientNotFound {
        var dentist = dentistService.getById(dto.dentistId()).orElseThrow(DentistNotFound::new);
        var patient = patientService.getById(dto.patientId()).orElseThrow(PatientNotFound::new);
        var turno = new Shift(dto.id(),dto.date(),dto.startTime(),dto.finishTime(), dentist, patient);
        return repository.save(turno);
    }

    public List<Shift> findAll()  {
        return repository.findAll();
    }
    public List<Shift> findByDentist(Dentist dentist)  {
        return repository.findByDentist(dentist);
    }
    public List<Shift> findByPatient(Patient patient)  {
        return repository.findByPatient(patient);
    }

    public Shift modify(ShiftDTO dto) throws DentistNotFound, PatientNotFound {
        var dentist = dentistService.getById(dto.dentistId()).orElseThrow(DentistNotFound::new);
        var patient = patientService.getById(dto.patientId()).orElseThrow(PatientNotFound::new);
        var turno = new Shift(dto.id(),dto.date(),dto.startTime(),dto.finishTime(), dentist, patient);
        return repository.save(turno);
    }
    public void delete(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El turno con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }


    public Optional<Shift> getById(int id) {
        return repository.findById(id);
    }
}
