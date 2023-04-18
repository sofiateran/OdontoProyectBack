package odontologoOrg.demo.patients;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import odontologoOrg.demo.dentists.Dentist;
import odontologoOrg.demo.shifts.Shift;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Patient{
    public Patient() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name,lastName,email,phoneNumber,socialWork,affiliateNumber,home,location,dni;
    private int age;
    private LocalDate birthday;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Dentist dentist;
}



