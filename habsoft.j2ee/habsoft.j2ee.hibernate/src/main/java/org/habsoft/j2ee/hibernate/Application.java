package org.habsoft.j2ee.hibernate;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

@EnableAutoConfiguration
@ComponentScan("org.habsoft.j2ee.hibernate.*")
public class Application {

    @Bean
    public PropertyPlaceholderConfigurer getPropertyConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("application.properties"));
        configurer.setNullValue("@null");
        return configurer;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        UserController obj = ctx.getBean(UserController.class);
        System.out.println(obj.create("fb@email.com", "FB"));

        // This ensure gracefully shutdown and calls the relevant destroy
        // methods.
        ctx.registerShutdownHook();
    }
}