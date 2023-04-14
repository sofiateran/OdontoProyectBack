package odontologoOrg.demo.patients;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.dentists.Dentist;
import odontologoOrg.demo.dentists.DentistService;
import odontologoOrg.demo.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class PatientService {
    private final PatientRepository repository;
    private final DentistService dentistService;

    public void save(PatientDTO patient) throws ResourceNotFoundException {
        var dentist = dentistService.getById(patient.getDentistId()).orElseThrow();
        repository.save(new Patient(
                patient.getId(),
                patient.getName(),
                patient.getLastName(),
                patient.getEmail(),
                patient.getPhoneNum(),
                patient.getSocialWork(),
                patient.getAffiliateNumber(),
                patient.getHome(),
                patient.getLocation(),
                patient.getDni(),
                patient.getAge(),
                patient.getBirthday(),
                dentist
                ));
    }

    public List<Patient> findAll()  {
        return repository.findAll();
    }

    public List<Patient> findByDentist(Dentist dentist)  {
        return repository.findByDentist(dentist);
    }

    public void modify(PatientDTO patient) {
        var dentist = dentistService.getById(patient.getDentistId()).orElseThrow();
        repository.save(new Patient(
                patient.getId(),
                patient.getName(),
                patient.getLastName(),
                patient.getEmail(),
                patient.getPhoneNum(),
                patient.getSocialWork(),
                patient.getAffiliateNumber(),
                patient.getHome(),
                patient.getLocation(),
                patient.getDni(),
                patient.getAge(),
                patient.getBirthday(),
                dentist
        ));
    }

    public void delete(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El paciente con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }
    public Optional<Patient> getById (int id){
        return repository.findById(id);
    }
}
