package study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudyServer8002 {
    public static void main(String[] args) {
        SpringApplication.run(StudyServer8002.class,args);
    }
}
