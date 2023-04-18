package odontologoOrg.demo.treatments.name;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentNameRepository extends JpaRepository<TreatmentName, Integer> {
}
