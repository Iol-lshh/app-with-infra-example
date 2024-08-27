package lshh.appwithinfraexample.common.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    @Bean
    public ProducerFactory<String, Long> producerFactory() {
        Map<String, Object> producerProps = Map.of(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, LongSerializer.class
        );
        return new DefaultKafkaProducerFactory<>(producerProps);
    }

    @Bean
    public KafkaTemplate<String, Long> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
