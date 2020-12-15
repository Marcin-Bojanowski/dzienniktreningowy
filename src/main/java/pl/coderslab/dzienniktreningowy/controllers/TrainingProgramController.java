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
import pl.coderslab.dzienniktreningowy.dtos.trainingSession.NewTrainingSessionDTO;
import pl.coderslab.dzienniktreningowy.services.UserTrainingProgramService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user/trainingProgram")
public class TrainingProgramController {

    private final UserTrainingProgramService userTrainingProgramService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getTrainingProgram(Model model,@ModelAttribute UserTrainingProgramDTO userTrainingProgramDTO) {
        model.addAttribute("trainingProgramDTO",  userTrainingProgramDTO);
        return "trainingProgram/concreteTrainingProgram";
    }
    @GetMapping("{id}")
    public String getTrainingProgramById(Model model, @PathVariable Long id) {
        model.addAttribute("trainingProgramDTO",modelMapper.map(userTrainingProgramService.findById(id),UserTrainingProgramDTO.class));
        return "trainingProgram/concreteTrainingProgram";
    }
}
