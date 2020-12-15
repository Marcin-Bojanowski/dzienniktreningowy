package pl.coderslab.dzienniktreningowy.entities;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.dzienniktreningowy.entities.superClasses.Exercise;

import javax.persistence.*;

@Entity
@Table(name = "default_exercises")
@Getter
@Setter
public class DefaultExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private MuscleGroup muscleGroup;
    private String description;

}
