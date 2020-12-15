package pl.coderslab.dzienniktreningowy.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.dzienniktreningowy.dtos.exercise.NewExerciseDTO;
import pl.coderslab.dzienniktreningowy.dtos.trainingSession.TrainingSessionDTO;
import pl.coderslab.dzienniktreningowy.entities.DefaultExercise;
import pl.coderslab.dzienniktreningowy.entities.TrainingSession;
import pl.coderslab.dzienniktreningowy.entities.UserExercise;
import pl.coderslab.dzienniktreningowy.repositories.DefaultExerciseRepository;
import pl.coderslab.dzienniktreningowy.repositories.UserExerciseRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserExerciseService {
    private final DefaultExerciseService defaultExerciseService;
    private final UserExerciseRepository userExerciseRepository;
    private final ModelMapper modelMapper;
    private final TrainingSessionService trainingSessionService;

    public TrainingSessionDTO save(NewExerciseDTO newExerciseDTO) {
        DefaultExercise defaultExercise = defaultExerciseService.getById(newExerciseDTO.getDefaultExercise().getId());
//        UserExercise userExercise = modelMapper.map(newExerciseDTO, UserExercise.class);
        UserExercise userExercise=new UserExercise();
        userExercise.setReps(newExerciseDTO.getReps());
        userExercise.setRpe(newExerciseDTO.getRpe());
        userExercise.setSets(newExerciseDTO.getSets());
        userExercise.setTempo(newExerciseDTO.getTempo());
        System.out.println(userExercise);
        userExercise.setDefaultExercise(defaultExercise);
        userExercise.setName(defaultExercise.getName());
        userExercise.setMuscleGroup(defaultExercise.getMuscleGroup());
        UserExercise save = userExerciseRepository.save(userExercise);
        TrainingSession trainingSession = trainingSessionService.getById(newExerciseDTO.getTrainingSessionId());
        System.out.println(trainingSession);
        TrainingSession trainingSessionSave = trainingSessionService.addExercise(trainingSession, save);
        System.out.println(trainingSessionSave);
        TrainingSessionDTO trainingSessionDTO=modelMapper.map(trainingSessionSave,TrainingSessionDTO.class);
        System.out.println(trainingSessionDTO);
        return trainingSessionDTO;
    }

    public UserExercise getById(Long id){
        return userExerciseRepository.getById(id);
    }
}

