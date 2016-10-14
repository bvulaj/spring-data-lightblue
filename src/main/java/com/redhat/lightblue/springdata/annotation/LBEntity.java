/**
 *
 */
package com.redhat.lightblue.springdata.annotation;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author bvulaj
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { TYPE })
public @interface LBEntity {

    String entity();

    String version() default "";

}
