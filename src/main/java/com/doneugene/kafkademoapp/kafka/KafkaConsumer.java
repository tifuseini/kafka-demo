package com.doneugene.kafkademoapp.kafka;

import com.doneugene.kafkademoapp.dto.EmployeeDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/*
* * @Author: Don Eugene
* Implementation to Consume JSON and String Data that have been sent through Kafka and are listening on same topics.
* */

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "${com.kafka.kafkaInfo.topicName}", groupId = "${com.kafka.kafkaInfo.groupId}", containerFactory = "${com.kafka.kafkaInfo.kafkaListenerContainerFactory}")
    public void receivedMessage(EmployeeDTO message) throws JsonProcessingException {
        log.info("Json message received using Kafka listener -> {}",
                new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(message));
    }


    @KafkaListener(topics = "${com.kafka.kafkaInfo.stringTopicName}", groupId = "${com.kafka.kafkaInfo.groupId}", containerFactory = "${com.kafka.kafkaInfo.kafkaListenerContainerFactory}")
    public void receivedStringMessage(String message) throws JsonProcessingException {
        log.info("String message received using Kafka listener -> {}",
                new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(message));
    }
}