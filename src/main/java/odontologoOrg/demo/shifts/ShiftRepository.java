package odontologoOrg.demo.shifts;

import odontologoOrg.demo.dentists.Dentist;
import odontologoOrg.demo.patients.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Integer> {


    List<Shift> findByDentist(Dentist dentist);
    List<Shift> findByPatient(Patient patient);
}
