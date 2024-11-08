package com.zero.grpc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ZeroGrpcEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeroGrpcEurekaApplication.class, args);
    }

}
