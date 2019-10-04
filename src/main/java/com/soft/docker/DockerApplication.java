package com.soft.docker;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@EnableSwagger2
@SpringBootApplication
public class DockerApplication {

    public static void main(String[] args) {

        SpringApplication.run(DockerApplication.class, args);

//        System.out.println("main");
//
//        ThreadTest threadTest = new ThreadTest();
//        threadTest.start();
    }

}

class ThreadTest extends Thread{

//    private SenderSource senderSource;
//
//    @Autowired
//    public ThreadTest(SenderSource senderSource){
//        this.senderSource = senderSource;
//    }

    @Override
    public void run(){

        System.out.println("thread run");

//        Map<String, String> msg = new HashMap<>();
//        msg.put("Name", "sohee");
//
//        System.out.println("thread finish");

        //senderSource.send(msg);


    }
}








