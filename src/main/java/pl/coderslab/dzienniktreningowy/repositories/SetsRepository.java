package pl.coderslab.dzienniktreningowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.dzienniktreningowy.entities.Sets;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SetsRepository extends JpaRepository<Sets,Long> {
}
