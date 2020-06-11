package classes;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author zzq
 * @creat 2020-05-27 16:47
 */
@Inherited
@Target({TYPE, FIELD, METHOD, PARAMETER, LOCAL_VARIABLE, MODULE, TYPE_PARAMETER,TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "hello";
}
