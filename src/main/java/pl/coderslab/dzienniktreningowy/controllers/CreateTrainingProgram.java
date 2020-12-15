package pl.coderslab.dzienniktreningowy.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.dzienniktreningowy.dtos.trainingProgram.NewUserTrainingProgramDTO;
import pl.coderslab.dzienniktreningowy.dtos.trainingProgram.UserTrainingProgramDTO;
import pl.coderslab.dzienniktreningowy.entities.UserTrainingProgram;
import pl.coderslab.dzienniktreningowy.services.UserTrainingProgramService;

import javax.validation.Valid;
import java.time.LocalDate;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class CreateTrainingProgram {

    private final UserTrainingProgramService userTrainingProgramService;
    private final ModelMapper modelMapper;

    @GetMapping("/createTrainingProgram")
    public String createTrainingProgram(Model model) {
        model.addAttribute("newUserTrainingProgramDTO", new NewUserTrainingProgramDTO());
        return "trainingProgram/create";
    }

    @PostMapping("/createTrainingProgram")
    public String saveTrainingProgram(@Valid NewUserTrainingProgramDTO newUserTrainingProgramDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "trainingProgram/create";
        }
        UserTrainingProgram save = userTrainingProgramService.save(newUserTrainingProgramDTO);
        UserTrainingProgramDTO saveDTO = modelMapper.map(save, UserTrainingProgramDTO.class);
        redirectAttributes.addFlashAttribute("userTrainingProgramDTO", saveDTO);
        return "redirect:trainingProgram";
    }
//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.registerCustomEditor(       Date.class,
//                new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
//    }
}
