package pl.coderslab.dzienniktreningowy.dtos.defaultExerciseDTO;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.dzienniktreningowy.entities.MuscleGroup;

import javax.persistence.ManyToOne;
@Getter
@Setter
public class DefaultExerciseDTO {
    private Long id;
    private String name;
    private MuscleGroup muscleGroup;
    private String description;
}
