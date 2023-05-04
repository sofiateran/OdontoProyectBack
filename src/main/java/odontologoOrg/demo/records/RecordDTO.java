package odontologoOrg.demo.records;

import odontologoOrg.demo.budgets.Budget;

import java.time.LocalDate;

public record RecordDTO(int id, LocalDate date, int patientId, int treatmentName,int treatmentFace,int treatmentPiece , double budget, String description) {
}
