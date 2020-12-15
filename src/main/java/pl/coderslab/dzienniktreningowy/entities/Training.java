package pl.coderslab.dzienniktreningowy.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.dzienniktreningowy.entities.superClasses.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "training")
public class Training extends BaseEntity {

    @ManyToOne
    private TrainingSession trainingSession;
    @OneToMany
    private List<Sets> sets=new ArrayList<>();
    private LocalDate performDate;

    @PrePersist
    public void setPerformDate() {
        this.performDate = LocalDate.now();
    }
}
