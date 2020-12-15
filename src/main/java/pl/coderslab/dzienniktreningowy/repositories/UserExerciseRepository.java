package pl.coderslab.dzienniktreningowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.dzienniktreningowy.entities.UserExercise;

public interface UserExerciseRepository extends JpaRepository<UserExercise, Long> {
    UserExercise getById(Long id);
}
