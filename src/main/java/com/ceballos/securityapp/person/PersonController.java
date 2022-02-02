package com.ceballos.securityapp.person;

import com.ceballos.securityapp.person.Person.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    private final List<Person> people = Arrays.asList(
            new Person(1, "John Doe"),
            new Person(2, "Jane Doe"),
            new Person(3, "G. I. Joe"),
            new Person(4, "G. I. Jane Doe")
    );

    @GetMapping(path = "/{personId}")
    public Person getPerson(@PathVariable("personId") Integer personId) {
        return people.stream()
                .filter(person -> personId.equals(person.getId()))
                .findFirst()
                .orElse(null);
    }

}
