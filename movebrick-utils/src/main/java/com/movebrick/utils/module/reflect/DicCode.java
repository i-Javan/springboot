package com.movebrick.utils.module.reflect;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.FIELD;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * 字典Code
 * @author Javan
 *
 */
@Target({METHOD,PARAMETER,FIELD}) 
@Retention(RUNTIME)
@Documented
public @interface DicCode {
	String value() default "";
}
