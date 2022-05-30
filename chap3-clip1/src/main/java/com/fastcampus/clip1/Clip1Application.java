package com.fastcampus.clip1;

import com.fastcampus.clip1.service.KafkaManager;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class Clip1Application {

    public static void main(String[] args) {
        SpringApplication.run(Clip1Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(KafkaManager kafkaManager,
                                    KafkaTemplate<String, String> kafkaTemplate,
                                    ClipConsumer clipConsumer) {
        return args -> {
            kafkaManager.describeTopicConfigs();
            kafkaManager.changeConfig();
//            kafkaManager.deleteRecords();
            kafkaManager.findAllConsumerGroup();
            try {
                kafkaManager.deleteConsumerGroup();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Thread.sleep(2000L);
            System.out.println("---- after delete consumer group ----");
            kafkaManager.findAllConsumerGroup();
            kafkaManager.findAllOffsets();

            kafkaTemplate.send("clip1-listener", "Hello, Listener.");
            clipConsumer.seek();
        };
    }

}
