package habsoft.j2se.annotation.docgen;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import habsoft.j2se.annotation.math.MathUtils;

public class Main {
    public static void main(String[] args) {
        // Get a class object
        Class<?> clazz = MathUtils.class;

        Doc doc = clazz.getAnnotation(Doc.class);
        System.out.println("Class Doc : " + doc.desc());

        // Get all declared methods
        Method[] methods = clazz.getDeclaredMethods();

        // Loop over methods
        for (Method m : methods) {
            // Display method name
            System.out.printf("name: %s%n", m.getName());

            // Display parameter count
            System.out.printf("\t# params: %s%n", m.getParameterCount());

            // Display return type
            System.out.printf("\treturn type: %s%n", m.getReturnType().getSimpleName());

            // Display modifiers
            int mods = m.getModifiers();
            String modStr = Modifier.toString(mods);
            System.out.printf("\tmodifiers: %s%n", modStr);

            isDocPresent(m);
        }

        // TODO: Process the MathUtils class's annotations

    }

    private static void isDocPresent(Method m) {
        Doc doc = m.getAnnotation(Doc.class);
        if (doc == null || doc.desc().isEmpty()) {
            System.out.printf("Annotaion missing in methods : %s%n", m.getName());
        }
    }
}