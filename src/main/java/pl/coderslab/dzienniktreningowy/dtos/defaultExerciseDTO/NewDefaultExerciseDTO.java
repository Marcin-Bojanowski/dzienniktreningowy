package pl.coderslab.dzienniktreningowy.dtos.defaultExerciseDTO;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.dzienniktreningowy.dtos.muscleGroup.MuscleGroupDTO;
import pl.coderslab.dzienniktreningowy.entities.MuscleGroup;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class NewDefaultExerciseDTO {
    @NotBlank
    private String name;
    @NotNull
    private MuscleGroup muscleGroup;
    @NotBlank
    private String description;
}
