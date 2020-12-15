package pl.coderslab.dzienniktreningowy.dtos.trainingSession;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.dzienniktreningowy.entities.UserExercise;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NewTrainingSessionDTO {

    private String name;
    private Long trainingProgramId;

}
