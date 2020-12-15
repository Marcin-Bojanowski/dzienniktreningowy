package pl.coderslab.dzienniktreningowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.dzienniktreningowy.entities.DefaultExercise;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DefaultExerciseRepository extends JpaRepository<DefaultExercise, Long> {
    @Query("select d from DefaultExercise d")
    List<DefaultExercise> getAll();

    DefaultExercise getById(Long id);
}
