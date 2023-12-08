package PasswordManager.Utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;

@UtilityClass
public class BeanUtil {
    @SneakyThrows
    public void copyNonNullProperties(Object source, Object destination)  {
        Class<?> claSs = source.getClass();
        Field[] fields = claSs.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(source);
            if (value != null) {
                field.set(destination, value);
            }
        }
    }
}





