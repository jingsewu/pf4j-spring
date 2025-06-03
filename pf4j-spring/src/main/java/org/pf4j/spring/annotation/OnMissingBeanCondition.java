package org.pf4j.spring.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * @author Kinser
 */
public class OnMissingBeanCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // Get the target bean type from the annotation attributes
        Class<?>[] beanTypes = (Class<?>[]) Objects.requireNonNull(metadata.getAnnotationAttributes(
            ConditionalOnMissingBeanCustom.class.getName())).get("value");

        for (Class<?> beanType : beanTypes) {
            // Check if a bean of this type exists
            if (!Objects.requireNonNull(context.getBeanFactory()).getBeansOfType(beanType).isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
