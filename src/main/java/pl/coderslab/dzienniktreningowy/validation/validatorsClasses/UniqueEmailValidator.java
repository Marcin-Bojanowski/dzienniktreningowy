package pl.coderslab.dzienniktreningowy.validation.validatorsClasses;

import lombok.RequiredArgsConstructor;
import pl.coderslab.dzienniktreningowy.services.UserService;
import pl.coderslab.dzienniktreningowy.validation.validators.UniqueEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserService userService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userService.findUserByEmail(s) == null;
    }
}
