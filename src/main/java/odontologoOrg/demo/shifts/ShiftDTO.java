package odontologoOrg.demo.shifts;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public record ShiftDTO (int id, LocalDate date, Time startTime, Time finishTime, int dentistId, int patientId){
}
