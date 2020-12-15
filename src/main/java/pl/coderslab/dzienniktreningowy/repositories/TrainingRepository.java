package pl.coderslab.dzienniktreningowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.dzienniktreningowy.entities.Training;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TrainingRepository extends JpaRepository<Training,Long> {
    @Query("select t from Training t where t.userId=:userId")
    List<Training> getAllByUserId(Long userId);

    Training getById(Long id);
}
