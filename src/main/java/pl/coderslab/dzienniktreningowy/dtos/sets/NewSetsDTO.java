package pl.coderslab.dzienniktreningowy.dtos.sets;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NewSetsDTO {
    private Double weight;
    private Integer reps;
    private Integer rpe;
    private String tempo;

}
