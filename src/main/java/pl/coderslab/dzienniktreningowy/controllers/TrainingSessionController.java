package pl.coderslab.dzienniktreningowy.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dzienniktreningowy.dtos.trainingProgram.UserTrainingProgramDTO;
import pl.coderslab.dzienniktreningowy.dtos.trainingSession.TrainingSessionDTO;
import pl.coderslab.dzienniktreningowy.services.TrainingSessionService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user/trainingSession")
public class TrainingSessionController {
private final TrainingSessionService trainingSessionService;
private final ModelMapper modelMapper;
    @GetMapping
    public String getTrainingProgram(Model model, @ModelAttribute TrainingSessionDTO trainingSessionDTO) {
        model.addAttribute("trainingSessionDTO",  trainingSessionDTO);
        return "trainingSession/concreteTrainingSession";
    }

    @GetMapping("{id}")
    public String getTrainingProgramById(Model model, @PathVariable Long id) {
        model.addAttribute("trainingSessionDTO",  modelMapper.map(trainingSessionService.getById(id),TrainingSessionDTO.class));
        return "trainingSession/concreteTrainingSession";
    }
}
