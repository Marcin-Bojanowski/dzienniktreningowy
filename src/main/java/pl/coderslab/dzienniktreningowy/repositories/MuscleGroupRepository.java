package pl.coderslab.dzienniktreningowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.dzienniktreningowy.entities.MuscleGroup;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {



    MuscleGroup findMuscleGroupByName(String name);
}
