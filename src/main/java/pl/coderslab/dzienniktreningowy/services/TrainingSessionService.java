package pl.coderslab.dzienniktreningowy.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.dzienniktreningowy.dtos.trainingSession.NewTrainingSessionDTO;
import pl.coderslab.dzienniktreningowy.dtos.trainingSession.TrainingSessionDTO;
import pl.coderslab.dzienniktreningowy.entities.TrainingSession;
import pl.coderslab.dzienniktreningowy.entities.UserExercise;
import pl.coderslab.dzienniktreningowy.entities.UserTrainingProgram;
import pl.coderslab.dzienniktreningowy.repositories.TrainingSessionRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class TrainingSessionService {
    private final UserTrainingProgramService userTrainingProgramService;
    private final TrainingSessionRepository trainingSessionRepository;
    private final ModelMapper modelMapper;

    public TrainingSession save(NewTrainingSessionDTO newTrainingSessionDTO) {
        UserTrainingProgram userTrainingProgram=userTrainingProgramService.findById(newTrainingSessionDTO.getTrainingProgramId());
        TrainingSession trainingSession = modelMapper.map(newTrainingSessionDTO, TrainingSession.class);
        TrainingSession save=trainingSessionRepository.save(trainingSession);
        userTrainingProgramService.addTrainingSession(save,userTrainingProgram);

        return save;
    }

    public TrainingSession getById(Long id){
        return  trainingSessionRepository.getById(id);
    }

    public TrainingSession addExercise(TrainingSession trainingSession, UserExercise userExercise){
        trainingSession.getExercises().add(userExercise);
      return  trainingSessionRepository.save(trainingSession);
    }

    public TrainingSessionDTO getDtoById(Long id){
        return modelMapper.map(trainingSessionRepository.getById(id),TrainingSessionDTO.class);
    }
}
