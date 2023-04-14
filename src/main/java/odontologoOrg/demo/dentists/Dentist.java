package odontologoOrg.demo.dentists;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import odontologoOrg.demo.patients.Patient;
import odontologoOrg.demo.shifts.Shift;

import java.util.ArrayList;
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Dentist {
    public Dentist() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name, lastName, email, password;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private ArrayList<Shift> shifts;
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private ArrayList<Patient> patients;
}
