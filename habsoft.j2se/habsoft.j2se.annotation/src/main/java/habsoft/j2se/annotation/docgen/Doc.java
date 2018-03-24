package habsoft.j2se.annotation.docgen;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Doc {

    /** Description of class or method */
    String desc() default "";

    /**
     * Description of parameters, if annotated element is a method & has
     * parameters
     */
    String[] params() default {};

    /**
     * Description of return value, if annotated element is a method & isn't
     * void
     */
    String returnVal() default "";
}