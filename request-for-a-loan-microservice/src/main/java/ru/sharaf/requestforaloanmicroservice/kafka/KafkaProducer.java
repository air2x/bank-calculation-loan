package ru.sharaf.requestforaloanmicroservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.sharaf.requestforaloanmicroservice.model.ApprovedAlone;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendApprovedAlone(ApprovedAlone approvedAlone) {
        kafkaTemplate.send("bank-credit", approvedAlone.toString());
    }
}
