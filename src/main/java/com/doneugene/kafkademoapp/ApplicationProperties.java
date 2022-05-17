package com.doneugene.kafkademoapp;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ConfigurationProperties("com.kafka")
public class ApplicationProperties {

    @NestedConfigurationProperty
    private final @Valid KafkaInfo kafkaInfo = new KafkaInfo();

    @Data
    public static class KafkaInfo {
        @NotNull
        private String bootstrapServer;
        private String topicName;
        private String stringTopicName;
        private String groupName;
        private String kafkaListenerContainerFactory;
        private String groupId;
    }

}