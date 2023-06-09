package odontologoOrg.demo.patients;

import odontologoOrg.demo.dentists.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByDentist(Dentist dentist);

    @Query("SELECT p FROM Patient p WHERE LOWER(p.name) like %:name%")
    List<Patient> findByName(String name);
}
