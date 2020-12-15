package pl.coderslab.dzienniktreningowy.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.dzienniktreningowy.dtos.exercise.UserExerciseDTO;
import pl.coderslab.dzienniktreningowy.dtos.sets.NewSetsDTO;
import pl.coderslab.dzienniktreningowy.dtos.training.NewTrainingDTO;
import pl.coderslab.dzienniktreningowy.dtos.trainingSession.TrainingSessionDTO;
import pl.coderslab.dzienniktreningowy.entities.Sets;
import pl.coderslab.dzienniktreningowy.entities.Training;
import pl.coderslab.dzienniktreningowy.entities.TrainingSession;
import pl.coderslab.dzienniktreningowy.entities.UserExercise;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Transactional
public class PerformTrainingService {
    private final TrainingSessionService trainingSessionService;
    private final ModelMapper modelMapper;
    private final SetsService setsService;
    private final UserExerciseService userExerciseService;
    private final TrainingService trainingService;


    public NewTrainingDTO newTraining(Long id) {
        TrainingSessionDTO trainingSessionDTO = trainingSessionService.getDtoById(id);
        NewTrainingDTO newTrainingDTO = new NewTrainingDTO();
        newTrainingDTO.setTrainingSessionId(id);
        for (UserExercise userExercise : trainingSessionDTO.getExercises()) {
            UserExerciseDTO userExerciseDTO = new UserExerciseDTO();
            userExerciseDTO = modelMapper.map(userExercise, UserExerciseDTO.class);

//            List<NewSetsDTO> newSetsDTOSList = new ArrayList<>();
            for (int i = 0; i < userExercise.getSets(); i++) {
                NewSetsDTO newSetsDTO = modelMapper.map(userExercise, NewSetsDTO.class);
                userExerciseDTO.getSets().add(newSetsDTO);
//                newSetsDTOSList.add(newSetsDTO);
            }
            newTrainingDTO.getListOfSets().add(userExerciseDTO);
//            newTrainingDTO.getSets().put(userExercise.getName(), newSetsDTOSList);
        }
//        System.out.println(newTrainingDTO);
        return newTrainingDTO;
    }

    public void save(NewTrainingDTO newTrainingDTO) {
        Training training = new Training();
        TrainingSession trainingSession = trainingSessionService.getById(newTrainingDTO.getTrainingSessionId());
        training.setTrainingSession(trainingSession);
        for (UserExerciseDTO userExerciseDTO : newTrainingDTO.getListOfSets()) {
            for (NewSetsDTO newSetsDTO : userExerciseDTO.getSets()) {
                Sets set = modelMapper.map(newSetsDTO, Sets.class);
                set.setUserExercise(userExerciseService.getById(userExerciseDTO.getId()));
                Sets save = setsService.save(set);
                training.getSets().add(save);
            }
        }
        trainingService.save(training);
    }
}