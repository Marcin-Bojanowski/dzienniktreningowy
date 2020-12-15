package pl.coderslab.dzienniktreningowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.dzienniktreningowy.entities.Role;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role getByName(String name);
}
