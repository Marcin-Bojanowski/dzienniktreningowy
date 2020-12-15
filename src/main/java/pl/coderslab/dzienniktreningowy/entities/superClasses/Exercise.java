package pl.coderslab.dzienniktreningowy.entities.superClasses;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.dzienniktreningowy.entities.MuscleGroup;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
//    @JoinColumn(name = "muscle_group_id")
    private MuscleGroup muscleGroup;
}
