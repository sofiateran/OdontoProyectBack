package odontologoOrg.demo.treatments;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import odontologoOrg.demo.treatments.face.TreatmentFace;
import odontologoOrg.demo.treatments.name.TreatmentName;
import odontologoOrg.demo.treatments.piece.TreatmentPiece;


@Entity
@Getter
@Setter
@AllArgsConstructor
public class Treatment {
    public Treatment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private TreatmentName name;
    @ManyToOne(cascade = CascadeType.ALL)
    private TreatmentPiece piece;
    @ManyToOne(cascade = CascadeType.ALL)
    private TreatmentFace face;

    private String status;




}
