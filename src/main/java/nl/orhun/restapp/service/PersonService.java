package nl.orhun.restapp.service;

import nl.orhun.restapp.Person;
import nl.orhun.restapp.dao.PersonDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> getPersons() {
        return personDao.getPersons();
    }
}
