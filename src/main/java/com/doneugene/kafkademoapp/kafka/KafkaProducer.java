package com.doneugene.kafkademoapp.kafka;

import com.doneugene.kafkademoapp.ApplicationProperties;
import com.doneugene.kafkademoapp.dto.EmployeeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

/*
 * * @Author: Don Eugene
 * Implementation to Trigger send of data from Online to Web Portal and
 * String Data that have been sent through Kafka and are listening on same topics.
 * */

@RestController
@RequestMapping("/kafka/produce")
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private ApplicationProperties applicationProperties;

    @GetMapping("/message")
    public void sendMessage() {

        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .id(UUID.randomUUID())
                .firstName("Don")
                .otherName("Qweku")
                .lastName("Eugene")
                .username("kwakuKiller")
                .employeeCode(UUID.randomUUID().toString())
                .departmentId(UUID.randomUUID())
                .build();

        try {
            kafkaTemplate.send(applicationProperties.getKafkaInfo().getTopicName(), employeeDTO);
            kafkaTemplate.send(applicationProperties.getKafkaInfo().getStringTopicName(), employeeDTO.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception occurred while getting EmployeeDTO. Do a better job and find what's causing it!!");
        }

        log.info("EmployeeDTO successfully received and sent to the consumer, let's get some -> {}", employeeDTO);
    }

}
