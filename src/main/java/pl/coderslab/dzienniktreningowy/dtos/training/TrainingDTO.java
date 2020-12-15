package pl.coderslab.dzienniktreningowy.dtos.training;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class TrainingDTO {
    private Long id;
    private String trainingSessionName;
    private LocalDate performDate;
}
