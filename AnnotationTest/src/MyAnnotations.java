import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author initial
 * @create 2021-03-01 16:14
 */

public @interface MyAnnotations {

    //表明value()的类型是 MyAnnotation的
    MyAnnotation[] value();
}
