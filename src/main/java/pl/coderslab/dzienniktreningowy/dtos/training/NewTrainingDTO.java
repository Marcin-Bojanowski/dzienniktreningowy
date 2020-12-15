package pl.coderslab.dzienniktreningowy.dtos.training;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.dzienniktreningowy.dtos.exercise.UserExerciseDTO;
import pl.coderslab.dzienniktreningowy.dtos.sets.NewSetsDTO;
import pl.coderslab.dzienniktreningowy.dtos.trainingSession.TrainingSessionDTO;
import pl.coderslab.dzienniktreningowy.entities.Sets;
import pl.coderslab.dzienniktreningowy.entities.TrainingSession;
import pl.coderslab.dzienniktreningowy.entities.UserExercise;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class NewTrainingDTO {
    private Long trainingSessionId;
    private List<UserExerciseDTO> listOfSets=new ArrayList<>();
//    private Map<String, List<NewSetsDTO>> sets=new HashMap<>();
//    private List<Sets> sets;
}
