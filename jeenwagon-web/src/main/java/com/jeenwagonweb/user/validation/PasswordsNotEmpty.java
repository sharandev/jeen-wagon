/**
 * 
 */
package com.jeenwagonweb.user.validation;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author sharanabasava.d
 *
 */
@Target( { TYPE, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordsNotEmptyValidator.class)
@Documented
public @interface PasswordsNotEmpty {

    String message() default "PasswordsNotEmpty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String triggerFieldName() default "";

    String passwordFieldName() default "";

    String passwordVerificationFieldName() default "";
}
