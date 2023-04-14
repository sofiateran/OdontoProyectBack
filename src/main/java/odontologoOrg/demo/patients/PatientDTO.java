package odontologoOrg.demo.patients;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import odontologoOrg.demo.dentists.Dentist;

import java.util.Date;
@Getter
@Setter
public class PatientDTO{
    private int id;
    private String name,lastName,email,phoneNum,socialWork,affiliateNumber,home,location,dni;
    private int age;
    private Date birthday;
    private int dentistId;


    public PatientDTO() {
    }


}






