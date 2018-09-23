package nl.orhun.restapp.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.orhun.restapp.Person;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PersonDaoTest {

    @Test
    public void getPerson() {
        ObjectMapper objectMapper = new ObjectMapper();
        PersonDao personDao = new PersonDao(objectMapper);
        List<Person> persons = personDao.getPersons();

        assertEquals(4, persons.size());

        Person person = persons.get(0);

        assertEquals(1, person.getId());
        assertEquals("Jeanette", person.getFirstName());
        assertEquals("Penddreth", person.getLastName());
        assertEquals("jpenddreth0@census.gov", person.getEmail());
        assertEquals("Female", person.getGender());
        assertEquals("26.58.193.2", person.getIpAddress());
    }

}