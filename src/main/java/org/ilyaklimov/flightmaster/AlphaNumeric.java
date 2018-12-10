package org.ilyaklimov.flightmaster;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NotNull
@Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]{1,19}")
@Constraint(validatedBy={})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@ReportAsSingleViolation
public @interface AlphaNumeric {
	String message() default "Not a valid value";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
