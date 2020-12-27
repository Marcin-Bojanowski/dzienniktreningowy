package pl.coderslab.dzienniktreningowy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.coderslab.dzienniktreningowy.dtos.UserDTO;
import pl.coderslab.dzienniktreningowy.entities.Role;
import pl.coderslab.dzienniktreningowy.entities.User;

import pl.coderslab.dzienniktreningowy.validation.groups.Registration;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
@Transactional
@RequiredArgsConstructor
@Validated
public class RegistrationService {

    private final UserService userService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Validated(Registration.class)
    public void register(@Valid UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        Role role = roleService.getRoleByName("ROLE_USER");
        System.out.println(role.toString());
        user.getRoles().add(role);
        userService.save(user);
    }
}
