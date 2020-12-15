package pl.coderslab.dzienniktreningowy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dzienniktreningowy.entities.User;
import pl.coderslab.dzienniktreningowy.services.UserService;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
//    @GetMapping("/login")
//    public String login(){
//        return "page/login";
//    }
//
//    @PostMapping("/logout")
//    public String logout(){
//        return "page/logout";
//    }

//    @RequestMapping("/default")
//    public String getHomePanel(HttpSecurity http){
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        User user=userService.findByUsername(username);
//        if (http.authorizeRequests().antMatchers("fsdf").)
//        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains("ADMIN"))
//    }
}
