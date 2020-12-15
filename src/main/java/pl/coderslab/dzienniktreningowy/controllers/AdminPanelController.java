package pl.coderslab.dzienniktreningowy.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminPanelController {
    @GetMapping
    public String getAdminPanel(HttpSession session) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        session.setAttribute("role", "admin");

        return "admin/adminPanel";
    }
}
