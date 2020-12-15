package pl.coderslab.dzienniktreningowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.dzienniktreningowy.entities.User;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    User findUserByUsername(String username);

    User findUserById(Long id);

//    @Query("select u from User u  where u.username=:username")
//    User findUserByUsernameWithTrainingProgram(String username);
}
