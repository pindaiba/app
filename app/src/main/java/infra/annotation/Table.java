package infra.annotation;

import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Target;

/**
 * Created by theo on 22/09/15.
 */
@Target(TYPE)
public @interface Table {
    String nome();
}
