package ru.sharaf.requestforaloanmicroservice.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sharaf.requestforaloanmicroservice.model.Person;
import ru.sharaf.requestforaloanmicroservice.services.PeopleService;

@RestController
public class PersonController {

    private final PeopleService peopleService;

    @Autowired
    public PersonController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @PostMapping("/recordingHumanData")
    public boolean getResult(@RequestBody @Valid Person person,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException("Error create person");
        }
        return peopleService.getResult(person);
    }
}
