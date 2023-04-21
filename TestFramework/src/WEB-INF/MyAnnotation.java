package annotation;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MonAnnotation{
    String Filename();
    String content();
    String url();

}
