package pl.coderslab.dzienniktreningowy.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.dzienniktreningowy.dtos.muscleGroup.MuscleGroupDTO;
import pl.coderslab.dzienniktreningowy.entities.MuscleGroup;
import pl.coderslab.dzienniktreningowy.repositories.MuscleGroupRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class MuscleGroupService {
    private final MuscleGroupRepository muscleGroupRepository;
    private final ModelMapper modelMapper;

    public List<MuscleGroupDTO> getAllMuscleGroupDTOS(){
        return muscleGroupRepository.findAll().stream().map(m->modelMapper.map(m,MuscleGroupDTO.class)).collect(Collectors.toList());
    }

    public List<MuscleGroup> getAllMuscleGroups() {
        return muscleGroupRepository.findAll();
    }

    public MuscleGroup findByName(String name){
        return muscleGroupRepository.findMuscleGroupByName(name);
    }

    public void save(MuscleGroup muscleGroup){
        muscleGroupRepository.save(muscleGroup);
    }
}
