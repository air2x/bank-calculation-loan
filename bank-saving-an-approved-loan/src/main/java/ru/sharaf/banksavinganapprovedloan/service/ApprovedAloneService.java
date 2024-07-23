package ru.sharaf.banksavinganapprovedloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sharaf.banksavinganapprovedloan.model.ApprovedAloneInfo;
import ru.sharaf.banksavinganapprovedloan.repositories.ApprovedAlonInfoRepository;

@Service
public class ApprovedAloneService {
    private final ApprovedAlonInfoRepository repository;

    @Autowired
    public ApprovedAloneService(ApprovedAlonInfoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void saveInfo(ApprovedAloneInfo info) {
        repository.save(info);
    }
}
