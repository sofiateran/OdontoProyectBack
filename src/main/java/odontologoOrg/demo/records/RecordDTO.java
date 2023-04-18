package odontologoOrg.demo.records;

import odontologoOrg.demo.budgets.Budget;
import odontologoOrg.demo.treatments.Treatment;

import java.time.LocalDate;

public record RecordDTO(int id, LocalDate date, int patientId, Treatment treatment, Budget budget) {
}
