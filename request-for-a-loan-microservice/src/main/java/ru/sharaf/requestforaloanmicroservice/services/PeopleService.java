package ru.sharaf.requestforaloanmicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sharaf.requestforaloanmicroservice.kafka.KafkaProducer;
import ru.sharaf.requestforaloanmicroservice.model.ApprovedAlone;
import ru.sharaf.requestforaloanmicroservice.model.Person;

@Service
public class PeopleService {

    private final KafkaProducer kafkaProducer;
    private final ApprovedAlone approvedAlone = new ApprovedAlone();

    @Autowired
    public PeopleService(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public boolean getResult(Person person) {
        if (((double) person.getAverageMonthlyIncome() / 2) < calculationOfTheMonthlyPayment(person)) {
            saveOwnerOfCredit(person);
            kafkaProducer.sendApprovedAlone(approvedAlone);
            return true;
        }
        return false;
    }

    private void saveOwnerOfCredit(Person person) {
        approvedAlone.setOwner(person);
        approvedAlone.setSum(person.getRequestedLoan().getSum());
        approvedAlone.setMonthlyPayment(calculationOfTheMonthlyPayment(person));
        approvedAlone.setTermInMonths(person.getRequestedLoan().getTermInMonth());
        approvedAlone.setLoanRate(calculationOfTheLoanRate(person));
    }

    private Double calculationOfTheMonthlyPayment(Person person) {
        double monthlyPayment;
        double loanRate = calculationOfTheLoanRate(person);
        int termInMonth = person.getRequestedLoan().getTermInMonth();
        monthlyPayment = person.getRequestedLoan().getSum() * (loanRate + (loanRate / (Math.pow((1 + loanRate), termInMonth) - 1)));
        return monthlyPayment;
    }

    private Double calculationOfTheLoanRate(Person person) {
        if (person.getAge() < 23 && person.getNumOfMonthsWorkedLastPlaceOfWork() < 6) {
            return 35.9;
        } else if (person.getAge() > 23 && person.getNumOfMonthsWorkedLastPlaceOfWork() < 6) {
            return 25.9;
        } else {
            return 20.9;
        }
    }
}
