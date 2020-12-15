package pl.coderslab.dzienniktreningowy.utilities;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.coderslab.dzienniktreningowy.entities.classes.CurrentUser;
@Component
public class LoggedUser {
    public Long getLoggedUserId() {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return currentUser.getUser().getId();
    }
}
