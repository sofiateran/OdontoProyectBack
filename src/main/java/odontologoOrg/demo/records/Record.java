package odontologoOrg.demo.records;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import odontologoOrg.demo.TreatmentName.TreatmentName;
import odontologoOrg.demo.TreatmentPiece.TreatmentPiece;
import odontologoOrg.demo.TreatmentFace.TreatmentFace;
import odontologoOrg.demo.budgets.Budget;

import odontologoOrg.demo.patients.Patient;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Record {
    public Record() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "treatment_name_id")
    private TreatmentName treatmentName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "treatment_face_id")
    private TreatmentFace treatmentFace;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "treatment_piece_id")
    private TreatmentPiece treatmentPiece;

    @OneToOne(cascade = CascadeType.ALL)
    private Budget budget;

}
