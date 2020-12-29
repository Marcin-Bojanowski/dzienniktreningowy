package pl.coderslab.dzienniktreningowy.startup;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.coderslab.dzienniktreningowy.entities.User;

import pl.coderslab.dzienniktreningowy.services.UserService;

@Component
@RequiredArgsConstructor
public class SetupDataCreator implements ApplicationRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;


//
@Override
public void run(ApplicationArguments args) throws Exception {
//    createMainUsers();
}
//    private void createMainUsers() {
//        createUserIfNotExists("admin", "admin", "admin@gmail.com", "ROLE_ADMIN");
//    }
//
//    public void createUserIfNotExists(String username, String password, String email, String role) {
//        if (userService.findByUsername(username) == null) {
//            User user = new User();
//            user.setUsername(username);
//            user.setPassword(passwordEncoder.encode(password));
//            user.setEmail(email);
//            user.getRoles().add(role);
//            userService.save(user);
//        }
//    }
}
