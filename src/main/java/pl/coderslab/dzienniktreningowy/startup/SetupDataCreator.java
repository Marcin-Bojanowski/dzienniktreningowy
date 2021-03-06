package pl.coderslab.dzienniktreningowy.startup;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.coderslab.dzienniktreningowy.entities.DefaultExercise;
import pl.coderslab.dzienniktreningowy.entities.MuscleGroup;
import pl.coderslab.dzienniktreningowy.entities.User;

import pl.coderslab.dzienniktreningowy.services.DefaultExerciseService;
import pl.coderslab.dzienniktreningowy.services.MuscleGroupService;
import pl.coderslab.dzienniktreningowy.services.UserService;

@Component
@RequiredArgsConstructor
public class SetupDataCreator implements ApplicationRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final MuscleGroupService muscleGroupService;
private final DefaultExerciseService defaultExerciseService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createMainUsers();
        createMuscleGroups();
        createDefaultExercises();
    }

    private void createMainUsers() {
        createUserIfNotExists("admin", "admin", "admin@gmail.com", "ROLE_ADMIN");
        createUserIfNotExists("root", "root", "root@gmail.com", "ROLE_USER");
    }

    private void createMuscleGroups() {
        createMuscleGroupIfNotExists("Chest");
        createMuscleGroupIfNotExists("Core");
        createMuscleGroupIfNotExists("Arms");
        createMuscleGroupIfNotExists("Back");
        createMuscleGroupIfNotExists("Legs");
        createMuscleGroupIfNotExists("Shoulders");

    }

    private void createDefaultExercises(){
        createDefaultExerciseIfNotExist("Bench press","Chest","Bench press");
        createDefaultExerciseIfNotExist("Incline bench press","Chest","Incline bench press");
        createDefaultExerciseIfNotExist("Dumbbell bench press","Chest","Dumbbell bench press");
        createDefaultExerciseIfNotExist("Poliquin flys","Chest","Poliquin flys");
        createDefaultExerciseIfNotExist("Ab wheel","Core","Ab wheel");
        createDefaultExerciseIfNotExist("Plank","Core","Plank");
        createDefaultExerciseIfNotExist("Tate press","Arms","Tate press");
        createDefaultExerciseIfNotExist("Skull crushers","Arms","Skull crushers");
        createDefaultExerciseIfNotExist("Incline dumbbell curl","Arms","Incline dumbbell curl");
        createDefaultExerciseIfNotExist("Hummer curl","Arms","Hummer curl");
        createDefaultExerciseIfNotExist("Row","Back","Row");
        createDefaultExerciseIfNotExist("Deadlift","Back","Deadlift");
        createDefaultExerciseIfNotExist("Pull up","Back","Pull up");
        createDefaultExerciseIfNotExist("Lat pulldown","Back","Lat pulldown");
        createDefaultExerciseIfNotExist("Squat","Legs","Squat");
        createDefaultExerciseIfNotExist("Lying leg curl","Legs","Lying leg curl");
        createDefaultExerciseIfNotExist("Romanian deadlift","Legs","Romanian deadlift");
        createDefaultExerciseIfNotExist("Bulgarian split squat","Legs","Bulgarian split squat");
        createDefaultExerciseIfNotExist("External rotation","Shoulders","External rotation");
        createDefaultExerciseIfNotExist("Powell raise","Shoulders","Powell raise");
        createDefaultExerciseIfNotExist("OHP","Shoulders","OHP");
        createDefaultExerciseIfNotExist("Dumbbell lateral raise","Shoulders","Dumbbell lateral raise");
    }

    public void createUserIfNotExists(String username, String password, String email, String role) {
        if (userService.findByUsername(username) == null) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setEmail(email);
            user.getRoles().add(role);
            userService.save(user);
        }
    }

    public void createMuscleGroupIfNotExists(String name) {
        if (muscleGroupService.findByName(name) == null) {
            MuscleGroup muscleGroup = new MuscleGroup();
            muscleGroup.setName(name);
            muscleGroupService.save(muscleGroup);
        }
    }

    public void createDefaultExerciseIfNotExist(String name,String muscleGroupName, String description){
        if (defaultExerciseService.findByName(name)==null){
            MuscleGroup muscleGroup=muscleGroupService.findByName(muscleGroupName);
            DefaultExercise defaultExercise=new DefaultExercise();
            defaultExercise.setName(name);
            defaultExercise.setMuscleGroup(muscleGroup);
            defaultExercise.setDescription(description);
            defaultExerciseService.save(defaultExercise);
        }
    }
}
