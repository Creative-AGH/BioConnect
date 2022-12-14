package com.example.bioconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BioConnectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BioConnectApplication.class, args);
//        context.getBean(AccountRepository.class).
//                save(new Account("adam", context.getBean(BCryptPasswordEncoder.class).encode("123"),Role.ADMIN));
        context.getBean(StartAndTestThingsSeed.class).fillData();
    }

}
