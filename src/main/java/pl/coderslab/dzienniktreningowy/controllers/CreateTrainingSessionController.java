package pl.coderslab.dzienniktreningowy.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.dzienniktreningowy.dtos.trainingSession.NewTrainingSessionDTO;
import pl.coderslab.dzienniktreningowy.dtos.trainingSession.TrainingSessionDTO;
import pl.coderslab.dzienniktreningowy.entities.TrainingSession;
import pl.coderslab.dzienniktreningowy.entities.UserTrainingProgram;
import pl.coderslab.dzienniktreningowy.services.TrainingSessionService;
import pl.coderslab.dzienniktreningowy.services.UserTrainingProgramService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user/addTrainingSession")
public class CreateTrainingSessionController {

    private final TrainingSessionService trainingSessionService;
    private final ModelMapper modelMapper;

    @GetMapping("{id}")
    public String addTrainingSession(Model model, @PathVariable Long id) {
        NewTrainingSessionDTO newTrainingSessionDTO = new NewTrainingSessionDTO();
        newTrainingSessionDTO.setTrainingProgramId(id);
        model.addAttribute("newTrainingSessionDTO", newTrainingSessionDTO);
        return "trainingSession/create";
    }

    @PostMapping("{id}")
    public String saveTrainingSession(@ModelAttribute NewTrainingSessionDTO newTrainingSessionDTO, RedirectAttributes redirectAttributes, @PathVariable Long id) {
        TrainingSession trainingSession = trainingSessionService.save(newTrainingSessionDTO);
        TrainingSessionDTO trainingSessionDTO =modelMapper.map(trainingSession,TrainingSessionDTO.class);
        redirectAttributes.addFlashAttribute("trainingSessionDTO", trainingSessionDTO);
        return "redirect:/user/trainingSession";
    }
}
