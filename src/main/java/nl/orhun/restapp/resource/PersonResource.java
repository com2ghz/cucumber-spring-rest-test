package nl.orhun.restapp.resource;


import nl.orhun.restapp.Person;
import nl.orhun.restapp.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class PersonResource {

    private PersonService personService;

    @Inject
    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/persons")
    public List<Person> getPersons() {
        return personService.getPersons();
    }
}
