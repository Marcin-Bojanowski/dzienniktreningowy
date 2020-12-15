package pl.coderslab.dzienniktreningowy.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.coderslab.dzienniktreningowy.dtos.trainingProgram.NewUserTrainingProgramDTO;
import pl.coderslab.dzienniktreningowy.entities.TrainingSession;
import pl.coderslab.dzienniktreningowy.entities.User;
import pl.coderslab.dzienniktreningowy.entities.UserTrainingProgram;
import pl.coderslab.dzienniktreningowy.repositories.UserTrainingProgramRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserTrainingProgramService {

    private final UserTrainingProgramRepository userTrainingProgramRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserTrainingProgram save(NewUserTrainingProgramDTO newUserTrainingProgramDTO) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);
        UserTrainingProgram userTrainingProgram = modelMapper.map(newUserTrainingProgramDTO,UserTrainingProgram.class);
//        userTrainingProgram.setName(trainingProgramDTO.getName());
//        user.getUserTrainingPrograms().add(userTrainingProgram);
        UserTrainingProgram save = userTrainingProgramRepository.save(userTrainingProgram);
        user.getUserTrainingPrograms().add(save);
        userService.save(user);
        return save;
    }

    public UserTrainingProgram findById(Long id) {
        return userTrainingProgramRepository.findUserTrainingProgramById(id);
    }

    public void addTrainingSession(TrainingSession trainingSession, UserTrainingProgram userTrainingProgram){
        userTrainingProgram.getTrainingSessions().add(trainingSession);
        userTrainingProgramRepository.save(userTrainingProgram);
    }
}
