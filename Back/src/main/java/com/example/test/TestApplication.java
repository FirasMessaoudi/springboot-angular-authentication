package com.example.test;

import com.example.test.model.Role;
import com.example.test.model.User;
import com.example.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2

public class TestApplication implements CommandLineRunner {
@Autowired
private PasswordEncoder passwordEncoder;
@Autowired
private UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.test")).build();
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("admin");
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.getRoles().add(Role.ROLE_ADMIN);
        userRepository.save(user);

    }

}


