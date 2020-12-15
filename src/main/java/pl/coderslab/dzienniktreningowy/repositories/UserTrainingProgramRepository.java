package pl.coderslab.dzienniktreningowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.dzienniktreningowy.entities.UserTrainingProgram;


import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserTrainingProgramRepository extends JpaRepository<UserTrainingProgram,Long> {

    UserTrainingProgram findUserTrainingProgramById(Long id);


}
