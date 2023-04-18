package odontologoOrg.demo.treatments.face;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class TreatmentFace {
    public TreatmentFace() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String face;
}
