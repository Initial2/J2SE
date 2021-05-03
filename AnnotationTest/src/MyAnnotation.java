import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

/**
 * @author initial
 * @create 2021-03-01 15:20
 */


@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    String value() default "hello";
}
