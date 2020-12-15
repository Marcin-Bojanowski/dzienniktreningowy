package pl.coderslab.dzienniktreningowy.dtos.exercise;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.dzienniktreningowy.entities.DefaultExercise;



@Getter
@Setter
public class NewExerciseDTO {


    private Long trainingSessionId;
    private Integer sets;
    private Integer reps;
    private Integer rpe;
    private String tempo;
    private DefaultExercise defaultExercise;
}
