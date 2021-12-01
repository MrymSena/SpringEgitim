package tr.gov.adalet.demo.mappers;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.TYPE})
@Documented  //herşey public
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=EnAzBirDegerValidator.class)
public @interface EnAzBirDeger {

    String[] fields();
    String errorMessage() default "En az bir değer dolu olmalı";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
