package odontologoOrg.demo.TreatmentFace;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentFaceRepository extends JpaRepository<TreatmentFace, Integer> {
}
