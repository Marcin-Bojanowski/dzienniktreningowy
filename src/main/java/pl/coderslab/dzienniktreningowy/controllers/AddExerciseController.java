package pl.coderslab.dzienniktreningowy.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.dzienniktreningowy.dtos.defaultExerciseDTO.DefaultExerciseDTO;
import pl.coderslab.dzienniktreningowy.dtos.exercise.NewExerciseDTO;
import pl.coderslab.dzienniktreningowy.dtos.trainingSession.TrainingSessionDTO;
import pl.coderslab.dzienniktreningowy.entities.TrainingSession;
import pl.coderslab.dzienniktreningowy.services.DefaultExerciseService;
import pl.coderslab.dzienniktreningowy.services.UserExerciseService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user/addExercise")
public class AddExerciseController {

    private final UserExerciseService userExerciseService;
    private final ModelMapper modelMapper;
    private final DefaultExerciseService defaultExerciseService;

    @ModelAttribute("defaultExercise")
    public List<DefaultExerciseDTO> defaultExerciseList() {
        return defaultExerciseService.getAllDefaultExercisesDTO();
    }

    @GetMapping("{id}")
    public String addExercise(Model model, @PathVariable Long id) {
        NewExerciseDTO newExerciseDTO = new NewExerciseDTO();
        newExerciseDTO.setTrainingSessionId(id);
        model.addAttribute("newExerciseDTO", newExerciseDTO);
        return "exercise/create";
    }

    @PostMapping("{id}")
    public String saveExercise(@ModelAttribute NewExerciseDTO newExerciseDTO, @PathVariable Long id, RedirectAttributes redirectAttributes){
        TrainingSessionDTO save = userExerciseService.save(newExerciseDTO);
        redirectAttributes.addFlashAttribute("trainingSessionDTO",save);
        return "redirect:/user/trainingSession";
    }
}
