package org.pf4j.spring.annotation;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom a ConditionalOnMissingBean annotation causing we have no dependency on spring-boot-autoconfigure
 *
 * @author Kinser
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnMissingBeanCondition.class)
public @interface ConditionalOnMissingBeanCustom {
    Class<?>[] value();
}
