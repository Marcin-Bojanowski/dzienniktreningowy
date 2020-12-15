package pl.coderslab.dzienniktreningowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.dzienniktreningowy.entities.TrainingSession;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TrainingSessionRepository extends JpaRepository<TrainingSession,Long> {
    TrainingSession getById(Long id);
}
