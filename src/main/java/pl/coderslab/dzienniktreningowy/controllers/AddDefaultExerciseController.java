package pl.coderslab.dzienniktreningowy.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dzienniktreningowy.dtos.defaultExerciseDTO.NewDefaultExerciseDTO;
import pl.coderslab.dzienniktreningowy.dtos.muscleGroup.MuscleGroupDTO;
import pl.coderslab.dzienniktreningowy.entities.MuscleGroup;
import pl.coderslab.dzienniktreningowy.services.DefaultExerciseService;
import pl.coderslab.dzienniktreningowy.services.MuscleGroupService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/addExercise")
public class AddDefaultExerciseController {
    private final ModelMapper modelMapper;
    private final DefaultExerciseService defaultExerciseService;
    private final MuscleGroupService muscleGroupService;

    @ModelAttribute("muscleGroups")
    public List<MuscleGroup> muscleGroup() {
        return muscleGroupService.getAllMuscleGroups();
    }


    @GetMapping
    public String addExercise(Model model) {
        model.addAttribute("newDefaultExerciseDTO", new NewDefaultExerciseDTO());
        return "defaultExercise/create";
    }

    @PostMapping
    public String saveExercise(@Valid NewDefaultExerciseDTO newDefaultExerciseDTO, BindingResult result){
        if (result.hasErrors()){
            return "defaultExercise/create";
        }
        defaultExerciseService.save(newDefaultExerciseDTO);
        return "redirect:/admin";
    }
}
