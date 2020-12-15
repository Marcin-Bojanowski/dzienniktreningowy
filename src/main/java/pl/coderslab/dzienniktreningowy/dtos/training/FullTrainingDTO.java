package pl.coderslab.dzienniktreningowy.dtos.training;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.dzienniktreningowy.dtos.exercise.UserExerciseDTO;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class FullTrainingDTO {
    private Long id;
    private String trainingSessionName;
    private LocalDate performDate;
    private List<UserExerciseDTO> listOfSets=new ArrayList<>();
}
