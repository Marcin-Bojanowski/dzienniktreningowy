package pl.coderslab.dzienniktreningowy.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.dzienniktreningowy.dtos.defaultExerciseDTO.DefaultExerciseDTO;
import pl.coderslab.dzienniktreningowy.dtos.defaultExerciseDTO.NewDefaultExerciseDTO;
import pl.coderslab.dzienniktreningowy.entities.DefaultExercise;
import pl.coderslab.dzienniktreningowy.repositories.DefaultExerciseRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class DefaultExerciseService {
    private final DefaultExerciseRepository defaultExerciseRepository;
    private final ModelMapper modelMapper;

    public List<DefaultExerciseDTO> getAllDefaultExercisesDTO() {
        return defaultExerciseRepository.getAll().stream().map(d -> modelMapper.map(d, DefaultExerciseDTO.class)).collect(Collectors.toList());
    }

    public DefaultExercise getById(Long id){
        return defaultExerciseRepository.getById(id);
    }

    public void save(NewDefaultExerciseDTO newDefaultExerciseDTO) {
        DefaultExercise defaultExercise=modelMapper.map(newDefaultExerciseDTO, DefaultExercise.class);
        defaultExerciseRepository.save(defaultExercise);

    }
}
