package pl.coderslab.dzienniktreningowy.dtos;


import lombok.Getter;
import lombok.Setter;
import pl.coderslab.dzienniktreningowy.validation.groups.Registration;
import pl.coderslab.dzienniktreningowy.validation.validators.UniqueEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDTO {

    @NotBlank
    @Email
    @UniqueEmail(groups = Registration.class)
    private String email;
    private String username;
    @NotBlank
    @Size(min = 4, max = 12)
    private String password;
    @NotBlank
    @Size(min = 4, max = 12)
    private String rePassword;
}
