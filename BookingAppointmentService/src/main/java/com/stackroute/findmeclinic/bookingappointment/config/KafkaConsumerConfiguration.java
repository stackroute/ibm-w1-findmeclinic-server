package com.stackroute.findmeclinic.bookingappointment.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.stackroute.findmeclinic.bookingappointment.model.Schedule;

@EnableKafka
@Configuration
public class KafkaConsumerConfiguration {


	@Bean
    public ConsumerFactory<String, Schedule> consumerFactory() {
        Map<String, Object> map = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.23.239.228:9092");
        map.put(ConsumerConfig.GROUP_ID_CONFIG, "groupjson");
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(map, new StringDeserializer(), new JsonDeserializer<>(Schedule.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Schedule> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String,Schedule> KafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        KafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
        return KafkaListenerContainerFactory;
    }
}
