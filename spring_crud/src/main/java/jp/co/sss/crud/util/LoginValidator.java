package jp.co.sss.crud.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginValidator implements ConstraintValidator<LoginChecker, Object> {

    @Override
    public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
        return false;
    }
    
}
