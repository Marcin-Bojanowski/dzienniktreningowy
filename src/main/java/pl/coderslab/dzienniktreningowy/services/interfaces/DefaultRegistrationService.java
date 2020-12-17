package pl.coderslab.dzienniktreningowy.services.interfaces;

import lombok.RequiredArgsConstructor;
import pl.coderslab.dzienniktreningowy.entities.User;
import pl.coderslab.dzienniktreningowy.repositories.UserRepository;

@RequiredArgsConstructor
public class DefaultRegistrationService implements RegistrationService {

    private final UserRepo userRepo;

    @Override
    public RegisterUSerResponse registerUser(RegisterUserRequest request) {

        validate(request);

        User user = createUser(request);


        return createResponse(user);
    }

    private void validate(RegisterUserRequest request) {
        if (userRepo.existsByUsername(request.getUsername())) {
            throw new IllegalStateException("Username with " + request.getUsername() + " already exists");

        }
    }

    private RegisterUSerResponse createResponse(User user) {
        return new RegisterUSerResponse(user.getId());
    }

    private User createUser(RegisterUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        userRepo.save(user);
        return user;
    }


}
