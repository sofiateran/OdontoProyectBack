package odontologoOrg.demo.treatments.piece;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentPieceRepository extends JpaRepository<TreatmentPiece, Integer> {
}
