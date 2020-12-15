package pl.coderslab.dzienniktreningowy.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.coderslab.dzienniktreningowy.dtos.exercise.UserExerciseDTO;
import pl.coderslab.dzienniktreningowy.dtos.sets.NewSetsDTO;
import pl.coderslab.dzienniktreningowy.dtos.training.FullTrainingDTO;
import pl.coderslab.dzienniktreningowy.dtos.training.TrainingDTO;
import pl.coderslab.dzienniktreningowy.entities.Sets;
import pl.coderslab.dzienniktreningowy.entities.Training;
import pl.coderslab.dzienniktreningowy.entities.UserExercise;
import pl.coderslab.dzienniktreningowy.repositories.TrainingRepository;
import pl.coderslab.dzienniktreningowy.utilities.LoggedUser;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private final ModelMapper modelMapper;
    private final UserExerciseService userExerciseService;
    private final LoggedUser loggedUser;

    public void save(Training training) {
        trainingRepository.save(training);
    }

    public List<TrainingDTO> getDTOList() {
        List<TrainingDTO> dtoList = new ArrayList<>();
        for (Training training : trainingRepository.getAllByUserId(loggedUser.getLoggedUserId())) {
            dtoList.add(modelMapper.map(training, TrainingDTO.class));

        }
        return dtoList;
    }

    public FullTrainingDTO getTrainingDTOById(Long id) {
        Training training = trainingRepository.getById(id);
        Set<Long> idList = new HashSet<>();
        for (Sets sets : training.getSets()) {
            idList.add(sets.getUserExercise().getId());
        }
        System.out.println(idList);
        List<UserExerciseDTO> userExerciseDTOS = new ArrayList<>();
        for (Long userExerciseId : idList) {
            userExerciseDTOS.add(modelMapper.map(userExerciseService.getById(userExerciseId), UserExerciseDTO.class));
        }
        FullTrainingDTO fullTrainingDTO = modelMapper.map(training, FullTrainingDTO.class);
        System.out.println(userExerciseDTOS.toString());
        for (int i = 0; i < userExerciseDTOS.size(); i++) {
            for (Sets sets : training.getSets()) {
                if (userExerciseDTOS.get(i).getName().equals(sets.getUserExercise().getName())) {
                    userExerciseDTOS.get(i).getSets().add(modelMapper.map(sets, NewSetsDTO.class));
                }
            }
            fullTrainingDTO.getListOfSets().add(userExerciseDTOS.get(i));
        }
        return fullTrainingDTO;
    }
}
