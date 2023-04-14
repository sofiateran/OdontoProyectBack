package odontologoOrg.demo.shifts;

import java.sql.Date;
import java.sql.Time;

public record ShiftDTO (int id, Date date, Time time, int dentistId, int patientId){
}
