package com.yibo.microservice_sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableSidecar
public class SidecarApplication 
{
    public static void main( String[] args )
    {
       SpringApplication.run(SidecarApplication.class,args);
    }
}
