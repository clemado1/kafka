package com.fastcampus.clip1;

import com.fastcampus.clip1.service.KafkaManager;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Clip1Application {

    public static void main(String[] args) {
        SpringApplication.run(Clip1Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(KafkaManager kafkaManager) {
        return args -> {
            kafkaManager.describeTopicConfigs();
        };
    }

}
