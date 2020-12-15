package pl.coderslab.dzienniktreningowy.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.dzienniktreningowy.entities.superClasses.BaseEntity;
import pl.coderslab.dzienniktreningowy.entities.superClasses.Exercise;

import javax.persistence.*;

@Entity
@Table(name = "user_exercises")
@Getter
@Setter
@ToString
public class UserExercise extends BaseEntity {

    private String name;
    @ManyToOne
    private MuscleGroup muscleGroup;
    private Integer sets;
    private Integer reps;
    private Integer rpe;
    private String tempo;
    @ManyToOne
    private DefaultExercise defaultExercise;
}
