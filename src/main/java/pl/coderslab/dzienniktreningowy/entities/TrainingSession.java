package pl.coderslab.dzienniktreningowy.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.dzienniktreningowy.entities.superClasses.BaseEntity;
import pl.coderslab.dzienniktreningowy.entities.superClasses.Exercise;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "training_session")
@Getter
@Setter
@ToString
public class TrainingSession extends BaseEntity {

    private String name;
    @OneToMany
    private List<UserExercise> exercises=new ArrayList<>();
}
