package pl.coderslab.dzienniktreningowy.entities.superClasses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.dzienniktreningowy.entities.TrainingSession;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@MappedSuperclass
@Getter
@Setter
@ToString
public class TrainingProgram extends BaseEntity {

    private String name;
    private String description;
    @OneToMany
    private List<TrainingSession> trainingSessions=new ArrayList<>();
}
