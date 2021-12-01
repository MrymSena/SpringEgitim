package tr.gov.adalet.demo.mappers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.*;

public class EnAzBirDegerValidator implements ConstraintValidator<EnAzBirDeger, Object> {

    private Set<String> targetFields;

    @Override
    public void initialize(EnAzBirDeger constraintAnnotation) {
        targetFields = Set.of(constraintAnnotation.fields());
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        List<Field> fields = getUniqueFields(o.getClass());
        if (fields.isEmpty()) {
            return true;
        }

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object fieldValue = field.get(o);
                if (!isBlank(fieldValue)) {
                    return true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private List<Field> getUniqueFields(Class<?> aClass) {
        Map<String, Field> fields = new HashMap<>();
        while (aClass != null) {
            for (Field field : aClass.getDeclaredFields()) {
                if (fields.containsKey(field.getName())) {
                    continue;
                }

                if (targetFields.contains(field.getName())) {
                    fields.put(field.getName(), field);
                }
            }
            aClass = aClass.getSuperclass();
        }

        return new ArrayList<>(fields.values());
    }



    private boolean  isBlank(Object o){
        if(o==null){
            return true;
        }

        if(o instanceof String){
            return ((String)o).isBlank();
        }
        return false;
    }
}
