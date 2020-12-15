package pl.coderslab.dzienniktreningowy.dtos.trainingProgram;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.dzienniktreningowy.dtos.trainingSession.TrainingSessionDTO;
import pl.coderslab.dzienniktreningowy.entities.TrainingSession;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class UserTrainingProgramDTO {
    @NotBlank
    private String name;
    private Long id;
    private String description;
    private LocalDate start;
    private LocalDate end;
    private List<TrainingSession> trainingSessions;
}
