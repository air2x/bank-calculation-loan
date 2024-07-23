package ru.sharaf.banksavinganapprovedloan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "bank")
public class ApprovedAloneInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "alone_info")
    private String alone_info;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public ApprovedAloneInfo(String info, LocalDateTime createdAt) {
        this.alone_info = info;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ApprovedAloneInfo{" +
                "id=" + id +
                ", info='" + alone_info + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
