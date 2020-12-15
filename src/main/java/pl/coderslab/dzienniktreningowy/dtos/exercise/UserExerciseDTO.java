package pl.coderslab.dzienniktreningowy.dtos.exercise;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.dzienniktreningowy.dtos.sets.NewSetsDTO;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class UserExerciseDTO {
    private Long id;
    private String name;
    private List<NewSetsDTO> sets=new ArrayList<>();
}
