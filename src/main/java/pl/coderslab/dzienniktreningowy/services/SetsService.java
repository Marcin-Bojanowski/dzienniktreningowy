package pl.coderslab.dzienniktreningowy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dzienniktreningowy.entities.Sets;
import pl.coderslab.dzienniktreningowy.repositories.SetsRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class SetsService {

    private final SetsRepository setsRepository;

    public Sets save(Sets set){
        return setsRepository.save(set);
    }
}
