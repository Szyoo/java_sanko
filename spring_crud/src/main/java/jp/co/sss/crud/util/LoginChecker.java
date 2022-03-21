package jp.co.sss.crud.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { LoginValidator.class })
public @interface LoginChecker {
    String message() default "社員ID、またはパスワードが間違っています。";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldEmpId() default "empId";

    String fieldEmpPass() default "empPass";
}
