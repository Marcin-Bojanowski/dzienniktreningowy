package pl.coderslab.dzienniktreningowy.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dzienniktreningowy.dtos.trainingProgram.UserTrainingProgramDTO;
import pl.coderslab.dzienniktreningowy.entities.User;
import pl.coderslab.dzienniktreningowy.entities.UserTrainingProgram;
import pl.coderslab.dzienniktreningowy.services.UserService;
import pl.coderslab.dzienniktreningowy.services.UserTrainingProgramService;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserPanelController {
private final UserService userService;
private final UserTrainingProgramService userTrainingProgramService;
private final ModelMapper modelMapper;
    @GetMapping
    public String getUserPanel(Model model, HttpSession session) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        session.setAttribute("role","user");
        model.addAttribute("userTrainingProgramsDTO",userService.getUserTrainingProgramDTOs(username));
        return "user/userPanel";
    }
}
