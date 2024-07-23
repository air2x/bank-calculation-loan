package ru.sharaf.requestforaloanmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApprovedAlone {

    private Double sum;
    private Double loanRate;
    private Double monthlyPayment;
    private Integer termInMonths;
    private Person owner;

    @Override
    public String toString() {
        return "ApprovedAlone{" +
                "sum=" + sum +
                ", loanRate=" + loanRate +
                ", monthlyPayment=" + monthlyPayment +
                ", termInMonths=" + termInMonths +
                ", owner=" + owner +
                '}';
    }
}
