import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;


public class BeanUtils {
    public static void assign(Object to, Object from) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Method[] methods = from.getClass().getMethods();

        for (Method methodFrom : methods) {
            String name = methodFrom.getClass().getName();

            for (Method methodTo : to.getClass().getMethods()) {

                if (methodTo.getName().startsWith("set") && Modifier.isPublic(methodTo.getModifiers())) {
                    String nameCheck = "get" + methodTo.getClass().getName().substring(3);

                    if (name.equals(nameCheck) && methodFrom.getReturnType().equals(methodTo.getParameterTypes())) {
                        Object param = methodFrom.invoke(from);

                        try {
                            methodTo.invoke(to, param);

                        } catch (IllegalArgumentException e) {

                        } catch (IllegalAccessException e) {

                        } catch (InvocationTargetException e) {

                        }
                    }

                }
            }
        }

    }
}
