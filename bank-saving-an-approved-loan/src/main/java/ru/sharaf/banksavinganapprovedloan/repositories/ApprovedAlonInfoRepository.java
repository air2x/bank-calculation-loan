package ru.sharaf.banksavinganapprovedloan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sharaf.banksavinganapprovedloan.model.ApprovedAloneInfo;

@Repository
public interface ApprovedAlonInfoRepository extends JpaRepository<ApprovedAloneInfo, Long> {
}
