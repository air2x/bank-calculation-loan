package ru.sharaf.requestforaloanmicroservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestedLoan {
    @NotNull
    @Min(value = 10000)
    private Double sum;
    @NotNull
    @Min(value = 2)
    private Integer termInMonth;

    @Override
    public String toString() {
        return "RequestedLoan{" +
                "sum=" + sum +
                ", termInMonth=" + termInMonth +
                '}';
    }
}
