package org.habsoft.j2ee.spring.boot.thymeleaf;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootThymeleafApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}