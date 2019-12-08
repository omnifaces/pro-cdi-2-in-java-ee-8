package org.omnifaces.procdi.decorators.greeting.qualified.multiple;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Repeatable(Languages.class)
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {FIELD, PARAMETER, METHOD, TYPE})
public @interface Language {
	String value();
}
