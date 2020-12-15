package pl.coderslab.dzienniktreningowy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dzienniktreningowy.entities.Role;
import pl.coderslab.dzienniktreningowy.repositories.RoleRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class RoleService {

    private final RoleRepository repository;

    public Role getRoleByName(String name){
        return repository.getByName(name);
    }
}
