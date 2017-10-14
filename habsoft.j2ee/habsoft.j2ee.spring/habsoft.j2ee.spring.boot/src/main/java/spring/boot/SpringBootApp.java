package spring.boot;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class SpringBootApp {

    @Bean
    public PropertyPlaceholderConfigurer getPropertyConfigurer() {
        // this will resolve expressions @Value("${property.name}")
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("application.properties"));
        configurer.setNullValue("@null");
        return configurer;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootApp.class, args);

        // This ensure gracefully shutdown and calls the relevant destroy
        // methods.
        ctx.registerShutdownHook();

        // System.out.println("Obj ; " + ctx.getBean(MyConfigurations.class));

        // System.out.println("Let's inspect the beans provided by Spring
        // Boot:");
        //
        // String[] beanNames = ctx.getBeanDefinitionNames();
        // Arrays.sort(beanNames);
        // for (String beanName : beanNames) {
        // System.out.println(beanName);
        // }
    }

}