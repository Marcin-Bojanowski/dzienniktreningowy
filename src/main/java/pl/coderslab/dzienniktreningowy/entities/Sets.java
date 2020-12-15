package pl.coderslab.dzienniktreningowy.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.dzienniktreningowy.entities.superClasses.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "sets")
public class Sets extends BaseEntity {

    private Double weight;
    private Integer reps;
    private Integer rpe;
    private String tempo;
    @ManyToOne
    private UserExercise userExercise;
}
