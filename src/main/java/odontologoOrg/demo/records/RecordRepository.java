package odontologoOrg.demo.records;

import odontologoOrg.demo.patients.Patient;
import odontologoOrg.demo.shifts.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {

    List<Record> findByPatient(Patient patient);
}
