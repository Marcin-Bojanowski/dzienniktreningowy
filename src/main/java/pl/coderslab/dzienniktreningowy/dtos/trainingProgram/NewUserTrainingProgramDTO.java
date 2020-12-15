package pl.coderslab.dzienniktreningowy.dtos.trainingProgram;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class NewUserTrainingProgramDTO {
    @NotBlank
    private String name;
    private String description;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate start;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
}
