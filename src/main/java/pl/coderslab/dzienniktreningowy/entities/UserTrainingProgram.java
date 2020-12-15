package pl.coderslab.dzienniktreningowy.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.dzienniktreningowy.entities.superClasses.TrainingProgram;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users_training_programs")
@Getter
@Setter
@ToString
public class UserTrainingProgram extends TrainingProgram {
    private LocalDate start;
    private LocalDate end;

}
