package pl.coderslab.dzienniktreningowy.services.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.dzienniktreningowy.entities.User;

public interface UserRepo extends JpaRepository<User,Long> {


    boolean existsByUsername(String username);
}
