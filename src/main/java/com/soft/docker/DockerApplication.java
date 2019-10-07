package com.soft.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class DockerApplication implements ApplicationRunner {

    @Autowired
    TestSource testSource;

    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        testSource.messageOutput();
    }
}







