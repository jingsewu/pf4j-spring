package org.pf4j.spring;

import org.pf4j.spring.annotation.ConditionalOnMissingBeanCustom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Defined a configuration class to create SpringPluginManager bean
 *
 * @author Kinser
 */
@Configuration
public class SpringPluginConfiguration {

    /**
     * create  SpringPluginManager bean and avoid duplicate bean creation
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBeanCustom(SpringPluginManager.class)
    public SpringPluginManager pluginManager() {
        return new SpringPluginManager();
    }
}
