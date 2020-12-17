package pl.coderslab.dzienniktreningowy.services.interfaces;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import pl.coderslab.dzienniktreningowy.entities.User;
import pl.coderslab.dzienniktreningowy.repositories.UserRepository;

import java.util.Random;

@DisplayName("Unit test for DefaultRegistrationService")
class DefaultRegistrationServiceTest {
    private UserRepo userRepo;
    private DefaultRegistrationService service;

    @BeforeEach
    public void prepare() {
        UserRepo userRepo = Mockito.mock(UserRepo.class);
        service = new DefaultRegistrationService(userRepo);
    }

    @Nested
    @DisplayName("Unit tests for DefaultRegistrationService::registerUser")
    class RegisterUser {
        @Test
        @DisplayName("Response should not be null")
        public void responseShouldNotBeNull() {
            //org.assertj.core.api.Assertions<-główna klasa z asercjami
            //org.mockito.Mockito<-Tworzy mocki
            //org.mockito.ArgumentMatchers<-Tworzy mocki argumentów
            //org.mockito.ArgumentCaptor<-do przechowywania argumentów
            RegisterUserRequest request = new RegisterUserRequest();
            RegisterUSerResponse response = service.registerUser(request);
            Assertions.assertThat(response).isNotNull();
        }

        @Test
        @DisplayName("Should use UserRepository")
        public void shouldUseUserRepository() {
            Mockito.when(userRepo.save(ArgumentMatchers.any(User.class))).thenReturn(new User());
            RegisterUserRequest request = new RegisterUserRequest();
            RegisterUSerResponse response = service.registerUser(request);
            Mockito.verify(userRepo, Mockito.times(1)).save(ArgumentMatchers.any(User.class));
        }

        @Test
        @DisplayName("Should use username and password from request")
        public void shouldUserUsernameAndPasswordFromRequest() {
            ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
            Mockito.when(userRepo.save(userCaptor.capture())).thenReturn(new User());
            RegisterUserRequest request = new RegisterUserRequest("joesmith", "s3cr3t");
            RegisterUSerResponse response = service.registerUser(request);
            User user = userCaptor.getValue();
            Assertions.assertThat(user).isNotNull();
            Assertions.assertThat(user)
                    .extracting(User::getUsername)
                    .isNotNull()
                    .isEqualTo(request.getUsername());
            Assertions.assertThat(user)
                    .extracting(User::getPassword)
                    .isNotNull()
                    .isEqualTo(request.getPassword());
        }

        @Test
        @DisplayName("Response should contains registered User id")
        public void responseShouldContainsRegisteredUserId() {
            Long id = new Random().nextLong();
            Mockito.when(userRepo.save(ArgumentMatchers.any(User.class)))
                    .then(invocation -> {
                        invocation.getArgument(0, User.class).setId(id);
                        return invocation.getArgument(0, User.class);
                    });
            RegisterUserRequest request = new RegisterUserRequest("joesmith", "s3cr3t");
            RegisterUSerResponse response = service.registerUser(request);

            Assertions.assertThat(response.getUserId())
                    .isNotNull()
                    .isEqualTo(id);
        }

        @Test
        @DisplayName("Should throw RuntimeXeception when username already exists")
        public void shouldThrowRuntimeExceptionWhenUsernameAlreadyExists() {
            Mockito.when(userRepo.existsByUsername("joesmith"))
                    .thenReturn(true);
            RegisterUserRequest request = new RegisterUserRequest("joesmith", "s3cr3t");
            RegisterUSerResponse response = service.registerUser(request);
            Assertions.assertThatThrownBy(() -> service.registerUser(request))
                    .hasNoCause()
                    .hasMessageContaining("joesmith")
                    .hasMessageContaining("already existing")
                    .isInstanceOf(RuntimeException.class);
        }
    }


}