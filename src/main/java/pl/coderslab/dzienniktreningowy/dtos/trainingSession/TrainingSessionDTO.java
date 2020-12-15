package pl.coderslab.dzienniktreningowy.dtos.trainingSession;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.dzienniktreningowy.entities.UserExercise;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class TrainingSessionDTO {
    private Long id;
    private String name;
    private List<UserExercise> exercises=new ArrayList<>();
}
