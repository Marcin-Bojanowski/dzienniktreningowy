package pl.coderslab.dzienniktreningowy.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.dzienniktreningowy.dtos.trainingProgram.UserTrainingProgramDTO;
import pl.coderslab.dzienniktreningowy.entities.User;
import pl.coderslab.dzienniktreningowy.entities.UserTrainingProgram;
import pl.coderslab.dzienniktreningowy.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

//    public User findWithTrainingProgram(String username) {
//        return userRepository.findUserByUsernameWithTrainingProgram(username);
//    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<UserTrainingProgramDTO> getUserTrainingProgramDTOs(String username) {
        User user = findByUsername(username);
        List<UserTrainingProgramDTO> userTrainingProgramDTOS = new ArrayList<>();
        for (UserTrainingProgram utp : user.getUserTrainingPrograms()) {
            userTrainingProgramDTOS.add(modelMapper.map(utp, UserTrainingProgramDTO.class));
        }
        return userTrainingProgramDTOS;
    }
}