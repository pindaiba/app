package infra.annotation;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * Created by theo on 22/09/15.
 */
@Target(FIELD)
public @interface Column {
    String nome();
    String mapeamentoAtributo() default "";
}
