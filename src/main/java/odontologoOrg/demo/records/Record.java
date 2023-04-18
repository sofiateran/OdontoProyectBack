package odontologoOrg.demo.records;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import odontologoOrg.demo.budgets.Budget;

import odontologoOrg.demo.patients.Patient;
import odontologoOrg.demo.treatments.Treatment;

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

    @OneToOne(cascade = CascadeType.ALL)
    private Treatment treatment;

    @OneToOne(cascade = CascadeType.ALL)
    private Budget budget;

}
