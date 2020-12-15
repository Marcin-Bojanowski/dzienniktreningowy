package pl.coderslab.dzienniktreningowy.entities.superClasses;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import pl.coderslab.dzienniktreningowy.entities.classes.CurrentUser;
import pl.coderslab.dzienniktreningowy.services.UserService;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;

    @PrePersist
    public void setUserId() {
        CurrentUser currentUser =(CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.userId = currentUser.getUser().getId();
    }

}
