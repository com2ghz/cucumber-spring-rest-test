package nl.orhun.restapp.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.orhun.restapp.Person;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonDao {

    private ObjectMapper objectMapper;

    @Inject
    public PersonDao(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Person> getPersons() {
        String content = readFile();
        try {
            Person[] persons = objectMapper.readValue(content, Person[].class);
            return Arrays.asList(persons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readFile() {
        URL resource = getClass().getClassLoader().getResource("./persons.json");
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));
            return new String(bytes);
        } catch (Exception e) {
            throw new RuntimeException("Could not read file", e);
        }
    }
}
