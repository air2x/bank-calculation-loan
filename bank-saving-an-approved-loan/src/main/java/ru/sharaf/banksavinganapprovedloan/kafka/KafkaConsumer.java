package ru.sharaf.banksavinganapprovedloan.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.sharaf.banksavinganapprovedloan.model.ApprovedAloneInfo;
import ru.sharaf.banksavinganapprovedloan.service.ApprovedAloneService;

import java.time.LocalDateTime;


@Service
public class KafkaConsumer {

    private final ApprovedAloneService service;

    @Autowired
    public KafkaConsumer(ApprovedAloneService service) {
        this.service = service;
    }

    @KafkaListener(topics = "bank-credit", groupId = "consumer_bank")
    public void listen(String approvedAlone) {
        ApprovedAloneInfo approvedAloneInfo = new ApprovedAloneInfo(approvedAlone, LocalDateTime.now());
        service.saveInfo(approvedAloneInfo);
        System.out.println(approvedAloneInfo);
    }
}
