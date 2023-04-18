package odontologoOrg.demo.patients;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import odontologoOrg.demo.dentists.Dentist;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
public class PatientDTO{
    private int id;
    private String name,lastName,email,phoneNum,socialWork,affiliateNumber,home,location,dni;
    private int age;
    private LocalDate birthday;
    private int dentistId;


    public PatientDTO() {
    }


}






