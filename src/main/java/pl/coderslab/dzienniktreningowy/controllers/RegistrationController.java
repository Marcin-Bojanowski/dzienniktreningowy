package pl.coderslab.dzienniktreningowy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dzienniktreningowy.dtos.UserDTO;
import pl.coderslab.dzienniktreningowy.services.RegistrationService;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final RegistrationService registrationService;

    @GetMapping
    public String registrationForm(Model model){
        model.addAttribute("userDTO",new UserDTO());
        return "page/registration";
    }

    @PostMapping
    public String registrationProcess(@Valid UserDTO userDTO, BindingResult result, Model model){
        if (result.hasErrors()){
            return "page/registration";
        }
        try {
            registrationService.register(userDTO);
        } catch (ConstraintViolationException exception){
            model.addAttribute("violations",exception.getConstraintViolations());
            exception.printStackTrace();
            return "page/registration";
        }
        return "page/home";
    }

}
