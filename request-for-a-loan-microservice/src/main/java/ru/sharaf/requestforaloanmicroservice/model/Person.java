package ru.sharaf.requestforaloanmicroservice.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    @NotEmpty(message = "First name is not be empty")
    private String firstName;

    @NotEmpty(message = "Last name is not be empty")
    private String lastName;

    @NotNull(message = "Age is not be empty")
    @Min(value = 18, message = "Age is not be less than 18 years")
    private Integer age;

    @Email
    @NotEmpty(message = "Email is not be empty")
    private String email;

    @NotNull(message = "Average monthly income is not be empty")
    @Min(value = 500)
    private Integer averageMonthlyIncome;

    @NotNull(message = "The number of months worked at the last place of work is not be empty")
    @Min(value = 0)
    @Max(value = 1200)
    private Integer numOfMonthsWorkedLastPlaceOfWork;

    private RequestedLoan requestedLoan;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", averageMonthlyIncome=" + averageMonthlyIncome +
                ", numOfMonthsWorkedLastPlaceOfWork=" + numOfMonthsWorkedLastPlaceOfWork +
                ", requestedLoan=" + requestedLoan +
                '}';
    }
}
